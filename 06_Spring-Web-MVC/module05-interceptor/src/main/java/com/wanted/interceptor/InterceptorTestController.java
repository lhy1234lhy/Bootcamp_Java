package com.wanted.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {

    @GetMapping("/stopwatch")
    public String handleMethod() throws InterruptedException {

        System.out.println("stopwatch 요청을 처리하는 핸들러 메소드 호출됨//");
        // 아무것도 수행하지 않으면 소요 시간이 0으로 나올 수 있기 때문에
        // 의도적으로 2초간 정지
        Thread.sleep(2000);
        // 멈추기만 하는데 왜 예외처리를 할까? 다른 병렬적인 작업이 방해를 받을 수 있기 때문..

        return "result"; // html 파일 이름
    }

}
