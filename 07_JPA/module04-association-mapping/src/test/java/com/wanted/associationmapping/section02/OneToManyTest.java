package com.wanted.associationmapping.section02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private OneToManyService service;

    @Test
    @DisplayName("1:N 연관관계 객체 그래프 탐색 조회")
    void oneToManyTest() {

        // 카테고리 10번을 전달하면, 10번에 해당하는 메뉴들 조회
        // given
        int categoryCode = 10;

        // 10번 카테고리를 조회함과 도잇에 그에 해당하는 Menu 들 조회 테스트
        Category category = service.findCategory(categoryCode);

//        System.out.println("category.getMenuList() = " + category.getMenuList());
// 메뉴리스트 출력.  근데 이거 트랜젝션 범위 안에 넣어야 작동함. ()
        System.out.println(category); // 카테고리 하나만 출력
        Assertions.assertNotNull(category);

    }

}
