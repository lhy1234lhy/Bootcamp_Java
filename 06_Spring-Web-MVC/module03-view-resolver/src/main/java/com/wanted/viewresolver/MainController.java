package com.wanted.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 어플리케이션 실행해도 이 파일이 실행 안 되는 이유: config 폴더 내에 없기 때문
// (ComponentScan을 해줘야 읽어올 수 있음)
@Controller
public class MainController {

    @RequestMapping(value = {"/", "/main"})
    public String main(){return "main";}

}
