package com.wanted.section03;

import com.wanted.section02.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityLifeCycle {

    private static EntityManagerFactory factory;
    // 애플리케이션 당 딱 하나만 생성하며, DB 연동을 위한 전체 설정을 가지고 있는 공장
    private EntityManager manager;
    // DB에 저장하고 조회하는 실제 작업을 수행하며, 하나의 작업(세션)이 끝나면 닫아줘야 합니다.
    // 작업 하나당 매니저 한 개

    @BeforeAll
    static void initFactory(){
        factory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void initManager(){
        manager = factory.createEntityManager();
    }

    @AfterEach
    void closeManager(){
        manager.close();
    }

    @AfterAll
    static void closeFactory(){
        factory.close();
    }

    @Test
    void 비영속_상태_테스트(){

        /* hi.
        *   객체를 생성하면(new), 영속성 컨텍스트와는 전혀 관련 없는 비영속 상태이다.
        *  */

        // given
        Menu foundMenu = manager.find(Menu.class, 1);
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());
        // 자료형 같고, 값도 똑같음.

        // when
        boolean isTrue = (foundMenu == newMenu);

        Assertions.assertFalse(isTrue);

    }

    @Test
    void 영속성_테스트_메서드(){

        /* hi.
         *   객체를 생성하면(new), 영속성 컨텍스트와는 전혀 관련 없는 비영속 상태이다.
         *  */

        // given
        Menu foundMenu = manager.find(Menu.class, 1);
        Menu newMenu = manager.find(Menu.class, 1);

        // when
        boolean isTrue = (foundMenu == newMenu);

        // then
        Assertions.assertTrue(isTrue); // assertTrue / assertFalse

    }

    @Test
    void 준영속_detach_테스트(){ // db에 반영이 안되면 대부분 영속 상태에서 벗어난거임

        // given
        Menu foundMenu1 = manager.find(Menu.class, 11);
        Menu foundMenu2 = manager.find(Menu.class, 12);

        // when
        manager.detach(foundMenu2);
        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        // then
        assertEquals(5000, manager.find(Menu.class, 11).getMenuPrice());
        //assertEquals(5000, manager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    void 삭제_remove_테스트(){
        /* hi.
        *   remove(): 엔티티를 영속성 컨텍스트 및 DB에서 삭제한다.
        *   단, 트랜잭션을 제어하지 않으면 영구 반영되지 않는다.
        *  */

        Menu foundMenu = manager.find(Menu.class, 2); // 2번 메뉴 찾아와서

        manager.remove(foundMenu);

        Menu refoundMenu = manager.find(Menu.class, 2);

        assertEquals(2, foundMenu.getMenuCode());
        assertEquals(null, refoundMenu);
    }

    @Test
    void 병합_merge_수정_테스트(){

        // detach(주소값 달라짐(비영속)) -> merge(주소값 다시 같아짐(영속))

        Menu detachMenu = manager.find(Menu.class, 2);
        manager.detach(detachMenu); // 별도 공간으로 이동시켜서 다른 주소값을 갖게 됨 (해쉬코드값 혼자 다름)


        detachMenu.setMenuName("보쌈");
        Menu refoundMenu = manager.find(Menu.class, 2);

        System.out.println("detachMenu.hashCode() = " + detachMenu.hashCode());
        System.out.println("refoundMenu.hashCode() = " + refoundMenu.hashCode());

        manager.merge(detachMenu);

        Menu mergeMenu = manager.find(Menu.class, 2);
        System.out.println("mergeMenu.hashCode() = " + mergeMenu.hashCode());

        assertEquals("보쌈", mergeMenu.getMenuName());
    }
}
