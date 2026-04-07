package com.wanted.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order/*")
// /order/ 바로 뒤에 단어가 하나만 붙은 경우는 모두 처리하겠다
public class ClassMappingController {

    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "GET 방식의 주문 등록 핸들러 메소드 동작..");

        return "mappingResult";
    }

    /* hi.
    *   여러 URL을 동시에 매핑하기
    *  */
    @RequestMapping(value = {"/modify", "/delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message", "POST 방식의 수정 및 삭제 핸들러 메소드 동작..");

        return "mappingResult";
    }

    // 추가 1: POST 방식의 /order/regist 요청을 처리하는 메서드
    @PostMapping("/regist")
    public String postRegistOrder(Model model){
        model.addAttribute("message", "POST 방식의 주문 등록 핸들러 메소드 동작..");
        return "mappingResult";
    }

    // 추가 2: GET 방식의 /order/modify 요청을 처리하는 메서드
    @GetMapping("/modify")
    public String getModifyOrder(Model model){
        model.addAttribute("message", "GET 방식의 주문 수정 핸들러 메소드 동작..");
        return "mappingResult";
    }


    /* hi.
    *   pathVariable -> url 경로를 타고 서버로 넘어오는 값
    *  */
    @GetMapping("/detail/{orderNo}")
    public String pathVariable(Model model, @PathVariable("orderNo") int no){

        model.addAttribute("message", no + "번 주문 상세조회 핸들러 메소드 호출...!");

        return "mappingResult";
    }

}
