package com.kakaopay.shortening.shorturl.controller;

import com.kakaopay.shortening.common.annotations.PerformanceLog;
import com.kakaopay.shortening.common.vo.JsonResult;
import com.kakaopay.shortening.shorturl.domain.ShortUrlDto;
import com.kakaopay.shortening.shorturl.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Short URL 처리 컨트롤러
 * Created by MHLab on 2019/12/12..
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    /**
     * 메인화면
     * @return
     */
    @GetMapping("")
    public ModelAndView getConvertShortUrl() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/main");
        return mv;
    }

    /**
     * 실질적으로 short url 이 온 경우 처리하는 로직
     * @param shortUrlKey
     * @return
     */
    @GetMapping("{urlKey}")
    public RedirectView getShortUrl(@PathVariable("urlKey") String shortUrlKey) {
        return shortUrlService.redirectShortUrl(shortUrlKey);
    }

    /**
     * 변환 요청시 호출되는 메서드
     * @param dto
     * @return
     */
    @PerformanceLog //수행시간 테스트용
    @ResponseBody
    @PostMapping("convert")
    public JsonResult<ShortUrlDto.ShortUrlData> postConvertShortUrl(@RequestBody ShortUrlDto.CreateTarget dto) {
        return shortUrlService.convertUrl4Origin2Short(dto);
    }

}
