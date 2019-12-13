package com.kakaopay.shortening;

import com.kakaopay.shortening.common.vo.JsonResult;
import com.kakaopay.shortening.shorturl.domain.ShortUrlDto;
import com.kakaopay.shortening.shorturl.repos.ShortUrlRepo;
import com.kakaopay.shortening.shorturl.service.ShortUrlRepoService;
import com.kakaopay.shortening.shorturl.service.ShortUrlService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Short Url Service 테스트 로직
 * Created by MHLab on 2019/12/13..
 */

@SpringBootTest(
        classes = {
        ShortUrlRepoService.class,
        ShortUrlService.class
})
public class ShortUrlServiceTest {

    private Logger log = LoggerFactory.getLogger(ShortUrlServiceTest.class);

    @Autowired
    private ShortUrlService shortUrlService;

    @MockBean
    private ShortUrlRepo shortUrlRepo;


    @DisplayName("Short URL 변경 테스트")
    @Test
    void Short_URL_변경_테스트() {
        JsonResult<ShortUrlDto.ShortUrlData> makeShortUrlJsonResult = makeShortUrl();
        Assertions.assertTrue(makeShortUrlJsonResult.isSuccess());
        log.info("jsonResult = " + makeShortUrlJsonResult);
    }


    /**
     * Short Url 생성 메서드
     * @return
     */
    private JsonResult<ShortUrlDto.ShortUrlData> makeShortUrl() {
        return shortUrlService.convertUrl4Origin2Short(ShortUrlDto.CreateTarget.builder()
                .originUrl("https://kakaopay.recruiter.co.kr")
                .build());
    }

}
