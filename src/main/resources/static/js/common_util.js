/**
 * Created by MHLab on 2019-03-13..
 */

///// == Valid

//Null을 체크하는 함수
//전달인자에 따라서 Bool 리턴함    / Null 일 경우 true   null이 아닌 경우 false
function isNullValue(str) {
    if (str === null) return true;
    if (str === "NaN") return true;
    if (String(str).valueOf() === "undefined") return true;
    let chkStr = String(str);//new String(str);
    if( chkStr.valueOf() === "undefined" ) return true;
    if (chkStr == null) return true;
    return chkStr.toString().length === 0;
}


///// == Utils

//Sweet alert
function showSAlert(title, msg, type) {
    Swal.fire(title, msg, type)
}

//Url 파라메터를 구하는 함수
function getUrlParam(paramName) {
    // 리턴값을 위한 변수 선언
    let returnValue;

    // 현재 URL 가져오기
    let url = location.href;

    // get 파라미터 값을 가져올 수 있는 ? 를 기점으로 slice 한 후 split 으로 나눔
    let parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');

    // 나누어진 값의 비교를 통해 paramName 으로 요청된 데이터의 값만 return
    for (let i = 0; i < parameters.length; i++) {
        let varName = parameters[i].split('=')[0];
        if (varName.toUpperCase() === paramName.toUpperCase()) {
            returnValue = parameters[i].split('=')[1];
            return decodeURIComponent(returnValue);
        }
    }
}