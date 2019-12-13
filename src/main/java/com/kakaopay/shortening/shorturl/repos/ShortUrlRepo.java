package com.kakaopay.shortening.shorturl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by MHLab on 2019/12/12..
 */

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {

    /**
     * Short Url로 값을 찾는 메서드
     * @param shortUrl
     * @return
     */
    Optional<ShortUrl> findByShortUrl(String shortUrl);


    /**
     * CheckSum이 존재하는지 체크하는 메서드
     * @param checkSum
     * @return
     */
    boolean existsByCheckSum(Long checkSum);


}
