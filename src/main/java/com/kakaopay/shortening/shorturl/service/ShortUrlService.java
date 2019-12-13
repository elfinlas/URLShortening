package com.kakaopay.shortening.shorturl.service;

import com.kakaopay.shortening.common.vo.JsonResult;
import com.kakaopay.shortening.shorturl.domain.ShortUrlDto;
import com.kakaopay.shortening.shorturl.repos.ShortUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.regex.Pattern;

import static com.kakaopay.shortening.common.enums.JsonSuccess.*;

/**
 * Short url service
 * Created by MHLab on 2019/12/12..
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortUrlService extends ShortUrlRepoService {


    /**
     * 변환 처리를 해주는 메서드
     * @param dto
     * @return
     */
    public JsonResult<ShortUrlDto.ShortUrlData> convertUrl4Origin2Short(ShortUrlDto.CreateTarget dto) {
        //전달된 클라이언트의 데이터를 저장용 DTO로 변환
        ShortUrlDto.SaveData saveDataDto = ShortUrlDto.SaveData.builder().originUrl(dto.getOriginUrl()).build();
        addData(saveDataDto);

        //응답결과를 Json 객체 형태로 조립
        return JsonResult.<ShortUrlDto.ShortUrlData>builder()
                .code(CONVERT_URL.code())
                .msg(CONVERT_URL.msg())
                .data(ShortUrlDto.ShortUrlData.builder()
                        .originUrl(saveDataDto.getOriginUrl())
                        .shortUrlKey(saveDataDto.getShortUrlKey())
                        .build()
                )
                .build();
    }

    /**
     * 전달된 ShortUrl key로 데이터를 조회하여 가져오는 메서드
     * @param shortKey
     * @return
     */
    public ShortUrlDto.ShortUrlData getData4ShortUrlKey(String shortKey) {
        ShortUrl entity = getData4ShortUrl(shortKey);
        return ShortUrlDto.ShortUrlData.builder()
                .originUrl(entity.getOriginUrl())
                .shortUrlKey(entity.getShortUrl())
                .build();
    }

    /**
     * ShortUrlKey가 들어온 경우 리다이렉션 처리를 하는 메서드
     * @param shortUrlKey
     * @return
     */
    public RedirectView redirectShortUrl(String shortUrlKey) {
        //특수문자 체크용
        Pattern pattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");

        //특수문자가 들어간 경우 메인화면 그 외에는 전달된 URL로 이동 처리
        String redirectUrl = pattern.matcher(shortUrlKey).find()?
                "":getData4ShortUrlKey(shortUrlKey).getOriginUrl();

        return new RedirectView(redirectUrl);
    }

}
