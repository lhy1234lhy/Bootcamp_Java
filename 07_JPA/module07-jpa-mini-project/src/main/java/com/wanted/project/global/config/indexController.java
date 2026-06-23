package com.wanted.project.global.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// main에서 이거 못읽음(같은 폴더 아니라서 컴포넌트 스캔 불가 -> ContextConfig 파일 만들어서 읽혀줌)
@Controller
public class indexController {

    @GetMapping(value = {"/", "/main"})
    public String mainPage(){
        return "main/main";
    }

}
