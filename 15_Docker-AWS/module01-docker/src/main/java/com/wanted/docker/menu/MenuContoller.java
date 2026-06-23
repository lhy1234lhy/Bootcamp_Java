package com.wanted.docker.menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuContoller {

    private final MenuRepository menuRepository;

    // 생성자 1개면 AutoWired 없어도 됨
    public MenuContoller(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /* Docker Local 배포 시 Spring Container 와
    *  MySQL Container 연동 확인을 위한 HandlerMethod
    *  Docker Network 동작 확인용
    * */
    @GetMapping("/menus")
    public List<Menu> findAllMenus(){
        return menuRepository.findAll();
    }

}
