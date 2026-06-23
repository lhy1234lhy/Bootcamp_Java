package com.wanted.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* hi.
*   인터셉터를 구현하기 위해서는 HandlerInterceptor를 상속받아야 한다.
*   Interceptor로 등록이 되며, 컨트롤러의 실행 전/후를
*   가로챌 수 있는 권한을 가지게 된다.
*  */

// interceptor: 권한(ex) 관리자. 수강생 등등..) 마다 필터?

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    /* hi.
    *   preHandle 전처리
    *   컨트롤러의 핸들러 메소드가 동작하기 전에 호출된다
    *  */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle 메서드 호출됨...");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        // true : 컨트롤러의 핸들러메서드를 이어서 호출한다.
        // false : 컨트롤러의 핸들러 메서드를 호출하지 않는다.
        return true;
    }

    // preHandler -> Controller -> postHandler 순서로 동작한다.

    /* hi.
     *   preHandle 후처리
     *   컨트롤러의 핸들러 메소드가 동작한 후에 호출된다
     *  */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // response, modelAndView 차이점. 자바 오브젝트를 담기 위해 modelAndView를 사용. (타임리프 써야돼서)
        // response 써도 되는데 그러면 .response 형식으로 꺼내줘야됨(타임리프 문법 쓰기 어려움)
        // 지금은 컨테이너 환경이니까 Spring인 modelAndView를 사용한다.
        System.out.println("postHandler 호출됨... ");

        // int (0) - Integer (null)
        // null값
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();

        // interval = endTime - startTime
        modelAndView.addObject("interval", endTime - startTime);
        // modelAndView: 값도 담을 수 있고 view도 볼 수 있음
    }
}
