package com.wanted.project.domain.menu.controller;

import com.wanted.project.domain.menu.model.dto.CategoryDTO;
import com.wanted.project.domain.menu.model.dto.MenuDTO;
import com.wanted.project.domain.menu.model.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor    // 필드에 final 키워드가 붙은 친구들을 자동으로 생성자 주입 해줌.
@RequestMapping("/menu/**")
public class MenuController {

    private final MenuService menuService;  // 자동으로 생성자 주입 받음. (Autowired X)



    @GetMapping("/{menuCode}")                                  //= 13
    public ModelAndView findByMenuByPathVariable(@PathVariable int menuCode, ModelAndView mv) {
        // PathVariable로
        MenuDTO findMenu = menuService.findMenuByMenuCode(menuCode);

        mv.addObject("result", findMenu);      // 키 값: result,
        // modelAndView에
        mv.setViewName("menu/detail"); // View: html 파일

        return mv; // mv로 던져준 화면: 메뉴상세정보 조회
    }

    @GetMapping("/querymethod")
    public void queryPage(){} // 쿼리메소드 기능 버튼을 실행시키는 GET 호출
    // 왜 void? 뷰를 리턴하는 방식 중 하나임.. @RequestMapping("/menu/**") 저 메뉴 뒤에 붙음.
    // 화면만 이동할 때는 이런 방식으로 하면 되겠죠?

    // 쿼리메소드 html에서 여기로 날라옴
    @GetMapping("/search")
    public ModelAndView findByMenuPrice(@RequestParam int menuPrice, ModelAndView mv){

        System.out.println("사용자가 입력한 menuPrice = " + menuPrice);

        List<MenuDTO> menuList = menuService.findMenuByPrice(menuPrice);

        mv.addObject("menuList", menuList);
        mv.addObject("price", menuPrice);
        mv.setViewName("menu/searchResult");
        return mv;

    }


    @GetMapping("/regist")
    public String regist(){
        return "menu/regist";
    }

    // 해당 메서드는 비동기 방식으로 페이지를 리턴하는 것이 아닌
    // 데이터만 리턴할 것이다.
    @GetMapping("/category")
    /* hi.
    *   @ResponseBody 를 붙이게 되면 웹 페이지에 Json 형태로 데이터를
    *   리턴하게 된다.
    *   Json 은 JavaScript 객체 표기법으로 우리 Java 클래스와 비슷한 역할이라고
    *   보면 된다. @ResponseBody는 1개의 페이지에 여러 데이터를 표현할 때
    *   1개의 핸들러메서드에서 여러 데이터를 넣는 것이 아닌 비동기 방ㅅ기으로
    *   각 핸들러메서드에서 전달되는 값을 조합할 때 유용하게 사용된다.
    *  */
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){ // Void, ModelAndView, String
        return menuService.findAllCategory();
    }
}