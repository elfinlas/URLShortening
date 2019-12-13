/**
 * Main.html 에서 사용되는 JS
 * Created by MHLab on 2019/12/12..
 */


$(document).ready(function() {
    //Init with dropdown
    $('.ui.dropdown').dropdown();

    //URL Param으로 전달인자가 잘못 들어온 경우
    let urlParam = getUrlParam('error');
    if (!isNullValue(urlParam)) {
        if (urlParam === 'nf') { //잘못된 url인 경우
            Swal.fire('잘못된 Short url', '찾을 수 없는 short url 입니다.', 'error')
                .then((result) => {self.location='/';})
        }
        else { showSAlert('기타','기타 에러입니다.','error');}
    }
});

//변환 처리
function click4Change() {
    let inputUserUrl = $('#inputUserUrl');
    //공백인 경우
    if (isNullValue(inputUserUrl.val())) {
        showSAlert('변환 불가', '변환할 URL이 비어있습니다.', 'error');
    }
    else { //이상이 없는 경우
        startLoading();
        let jsonObj = {"originUrl":$('#httpType').text() + inputUserUrl.val()};
        startLoading();
        $.ajax({
            url: '/convert',
            type: 'POST',
            contentType: "application/json; charset=UTF-8",
            data: JSON.stringify(jsonObj),
            dataType: "text",
            timeout: 10000, //60 second timeout
            success: function (data) { //로그인 성공
                let json = JSON.parse(data);
                let convertUrlInput = $('#convertUrlInput');
                convertUrlInput.removeClass('hidden');
                convertUrlInput.text(json['data']['shortUrl']);
                showSAlert('변환 완료','변환이 완료되었습니다.','success');
            },
            error:function (request, status, error) {
                let json = JSON.parse(request.responseText);
                showSAlert('처리 에러','처리에 문제가 생겼습니다. \n ' + json,'error');
            },
            complete:function (data) { //완료 시 로딩 창 닫기
                endLoading();
            }
        });
    }
}