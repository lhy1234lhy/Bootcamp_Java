package com.wanted.springasync.section03.async_event;

import com.wanted.springasync.common.support.SleepUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CompletionSummaryService {

    /* hi.
    *   비동기 메서드의 반환형 차이
    *   1. void : 비동기 메서드 호출하는 곳은 비동기 완료 결과를 받을 수 없다.
    *   2. CompletableFuture : 호출자는 thenAccept(), join(), get() 등으로
    *   비동기 메서드 완료 결과를 이어서 다룰 수 있게 된다.
    *  */

    @Async
    // CompletableFuture 이거 왜 씀? :
    // 비동기로 시작한 작업의 결과나 예외를 나중에 이어서 처리하기 위해..
    public CompletableFuture<String> createSummaryAsync(Long enrollmentId) {

        log.info("[section03] 🚨비동기🚨 CompletableFuture 수강 완료 시 진행되는 이벤트 작업 시작! 작업 중인 Thread = {}", Thread.currentThread().getName());

        SleepUtils.sleep(3000L);
        // 실제 프로젝트 시에는 DB에 요약본이 저장되거나, 조회하는 형태로 변경한다.
        String summary = "enrollmentId = " + enrollmentId + "어쩌구 저쩌구";
        log.info("[section03] 🚨비동기🚨 CompletableFuture 수강 완료 시 진행되는 이벤트 작업 시작! 작업 중인 Thread = {}", Thread.currentThread().getName());

        return CompletableFuture.completedFuture(summary);
    }
}
