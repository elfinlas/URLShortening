package com.kakaopay.shortening.shorturl.repos;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by MHLab on 2019/12/12..
 */

@Entity
@Table(name = "shorturl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode
public class ShortUrl implements Serializable {

    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = 3340198070207694462L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", updatable = false)
    private Long no;

    @Column(name = "origin_url", updatable = false, length = 255)
    private String originUrl;

    @Column(name = "short_url", updatable = false, length = 8)
    private String shortUrl;

    @Column(name = "checksum", updatable = false)
    private Long checkSum;


    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;


    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }

    @Builder
    public ShortUrl(String originUrl, String shortUrl, Long checkSum) {
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
        this.checkSum = checkSum;
    }


}
