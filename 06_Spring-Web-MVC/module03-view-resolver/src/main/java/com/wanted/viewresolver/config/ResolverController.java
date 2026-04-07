package com.wanted.viewresolver.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    @GetMapping("string")
    // HttpResponse -> model, HttpRequest -> @Re, @Mo
    public String stringView(Model model){
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환");

        /* hi.
        *   Controller에서 문자열 리턴의 의미는 반환 후
        *   ThymleafViewResolver 에게
        *   resources/templates/ 를 prefix로,
        *   .html을 suffix로 하겠다는 의미이다.
        *   아래 리턴값은 실제로 resource/tempaltes/result.html
        *   이 의미로 해석된다.
        *  */

        return "result"; // resource/tempaltes/result.html 이렇게 쓰면 html이 두 번 쓰여서 화면 안 나옴
    }

    @GetMapping("string-redirect")
    public String stirngRedirect(){

        /* hi.
        *   View 리턴 시 기본 방식은 forward이다.
        *   redirect가 필요하면, 접두사 redirect:{보낼 url}
        *   이렇게 작성을 해주면 된다.
        *  */

        return "redirect:/";

    }

    @GetMapping("string-redirect-attr")
    public String stirngRedirectAttr(RedirectAttributes rttr){

        /* hi.
        *   redirect 시에는 재요청이 발생한다. 그렇기 떄문에
        *   최초에 model 담아둔 test 값은 재요청시 소멸된다.
        *   우리는 redirect 시 값을 저장하기 위해
        *   session, cookie 개념을 배웠었다.
        *   redirect 를 하더라도 값을 저장할 수 있는 방법을 제공해준다.
        *  */

        // model.addAttribute("test", "test");
        // redirect 시 유지하고 싶은 값
        /* hi.
        *   세션에 임시로 값을 담아두고, 자동 소멸하는 방식이기 때문에
        *   session, cookie 를 사용하는 것보다 훨씬 메모리적으로 유리하다.
        *  */
        rttr.addFlashAttribute("flasshMessage", "리다이렉트 시 유지되는 값");


        return "redirect:/";
    }
    @GetMapping("modelAndView")
    public ModelAndView modelAndView(ModelAndView mv){
        mv.addObject("forwardMessage", "ModelAndView를 이용한 값과 뷰 반환");
        mv.setViewName("result");

        return mv;
    }
    /* hi.
    *   spring 에서 @Controller는 View를 반환해야 하는 책임을 가진다.
    *   View를 반환하는 방법은 크에 3가지가 있다.
    *   1. void -> 요청 url이 view 경로가 됨.
    *   2. string -> 문자열 리턴값이 view 경로가 됨.
    *   3. ModelAndView -> setViewName(문자열) 문자열이 view 경로가 됨.
    *  */
    @GetMapping("result")
    public void result(){}
}
