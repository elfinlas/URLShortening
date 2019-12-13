package com.kakaopay.shortening.shorturl.service;

import com.kakaopay.shortening.shorturl.domain.ShortUrlDto;
import com.kakaopay.shortening.shorturl.exceptions.ShortKeyNotFoundException;
import com.kakaopay.shortening.shorturl.repos.ShortUrl;
import com.kakaopay.shortening.shorturl.repos.ShortUrlRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Short Url 데이터의 Repo 처리를 돕는 서비스 객체
 * Created by MHLab on 2019/12/12..
 */

@Slf4j
@Transactional
public class ShortUrlRepoService {

    @Autowired
    private ShortUrlRepo shortUrlRepo;

    /**
     * 새로 등록되는 데이터
     * @param dto
     * @return
     */
    public ShortUrl addData(ShortUrlDto.SaveData dto) {
        //만약 데이터가 존재하는 경우 기존 값 반환
        if (shortUrlRepo.existsByCheckSum(dto.getCheckSum())) {
            return getData4ShortUrl(dto.getShortUrlKey());
        }
        return shortUrlRepo.save(dto.toEntity());
    }

    /**
     * Short url로 데이터를 조회하는 메서드
     * @param shortUrl
     * @return
     */
    protected ShortUrl getData4ShortUrl(String shortUrl) {
        return shortUrlRepo.findByShortUrl(shortUrl)
                .orElseThrow(() -> new ShortKeyNotFoundException("Send shortUrlKey("+shortUrl+") not found.", this));
    }

}
