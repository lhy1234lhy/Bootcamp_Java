package com.wanted.springasync.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.async")
public record AsyncProperties(
        /* hi.
        *   yml 작성한 async 관련 값을 변수처리하여
        *   활용하기 위함.
        *   케밥케이스 단어-단어 (꼬챙이에 꽃힌 것처럼 돼있어서...) / 카멜케이스 단어딴어
        *  */
        int corePoolSize,
        int maxPoolSize,
        int queueCapacity,
        String threadNamePrefix
) {
}
