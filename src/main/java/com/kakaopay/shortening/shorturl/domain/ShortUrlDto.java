package com.kakaopay.shortening.shorturl.domain;

import com.kakaopay.shortening.common.utils.Base62Helper;
import com.kakaopay.shortening.shorturl.repos.ShortUrl;
import lombok.*;

import java.util.zip.Adler32;
import java.util.zip.Checksum;

/**
 * Created by MHLab on 2019/12/12..
 */

public class ShortUrlDto {

    //Client 에서 등록시 사용
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @ToString
    public static class CreateTarget {
        private String originUrl; //전달된 오리지널 URL

        @Builder
        public CreateTarget(String originUrl) {
            this.originUrl = originUrl;
        }
    }


    //데이터 저장
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @ToString
    public static class SaveData {
        private String originUrl;
        private String shortUrlKey;
        private Long checkSum;

        @Builder
        public SaveData(String originUrl) {
            this.originUrl = originUrl;
            makeShortUrl();
        }

        /**
         * 기본 URL 전달 시 Adler32로 체크섬 한 값과 ShortUrl Key를 만들어저 변수에 저장하는 메서드
         */
        private void makeShortUrl() {
            byte[] byteArr = this.originUrl.getBytes();
            Checksum checksum = new Adler32();
            checksum.update(byteArr, 0 , byteArr.length);
            this.checkSum = checksum.getValue();
            this.shortUrlKey = Base62Helper.encode(this.checkSum);
        }

        /**
         * Entity를 생성해주는 메서드
         * @return
         */
        public ShortUrl toEntity() {
            return ShortUrl.builder()
                    .originUrl(this.originUrl)
                    .shortUrl(this.shortUrlKey)
                    .checkSum(this.checkSum)
                    .build();
        }
    }

    //조회 데이터
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @ToString
    public static class ShortUrlData {
        @Getter(AccessLevel.NONE)
        private final String baseUrl = "http://localhost:8080/";
        private String originUrl;
        private String shortUrlKey;
        private String shortUrl;

        @Builder
        public ShortUrlData(String originUrl, String shortUrlKey) {
            this.originUrl = originUrl;
            this.shortUrlKey = shortUrlKey;
            this.shortUrl = baseUrl+this.shortUrlKey;
        }
    }


}
