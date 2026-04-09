package com.wanted.section02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityManagerCRUD {

    private static EntityManagerFactory factory;
    // 애플리케이션 당 딱 하나만 생성하며, DB 연동을 위한 전체 설정을 가지고 있는 공장
    private EntityManager manager;
    // DB에 저장하고 조회하는 실제 작업을 수행하며, 하나의 작업(세션)이 끝나면 닫아줘야 합니다.
    // 작업 하나당 매니저 한 개

    @BeforeAll
    static void initFactory(){
        factory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach // 메소드 시작 전
    void initManager(){
        manager = factory.createEntityManager();
    }

    @AfterEach // 메소드 시작 후
    void closeManager(){
        manager.close();
    }

    @AfterAll
    static void closeFactory(){
        factory.close();
    }

    @Test
    // 보통 자바 프로그램은 main 메서드부터 시작하지만,
    // @Test가 붙으면 IDE(IntelliJ 등)에서 해당 메서드만 따로 실행할 수 있는 화살표 버튼이 생간다.
    @DisplayName("메뉴 코드로 메뉴 조회하기") // 테스트 결과 창에 출력될 이름을 직접 지정하는 기능
    void findMenuByMenuCode(){

        // given  (request로 받아오는 값)
        int menuCode = 2;

        // when  (쿼리문 만들어짐)
        Menu foundMenu = manager.find(Menu.class, 2);

        // then  (테스트 검증(성공 여부)을 위한 코드)
        Assertions.assertNotNull(foundMenu); // foundMenu이 notnull이면 테스트 1차 통과
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode()); // foundMenu과 menuCode를 비교해서 같으면 테스트 2차 통과

        System.out.println("foundMenu = " + foundMenu);

    }

    @Test
    @DisplayName("새로운 메뉴 추가 테스트")
    // new로 만든 순수한 자바 객체를 JPA가 관리하는 상태로 만듭니다.
    // 나중에 트랜잭션이 commit될 때 INSERT SQL이 자동으로 생성되어 DB에 날아갑니다.

    void testInsertNewMenu(){

        // given
        Menu newMenu = new Menu();
        newMenu.setMenuName("JPA 테스트 메뉴");

        newMenu.setMenuPrice(15000);
        newMenu.setCategoryCode(4);
        newMenu.setOrderableStatus("Y");

        // when
        EntityTransaction transaction = manager.getTransaction();

        // DB에 실제로 반영하기 위해 transaction 시작!
        transaction.begin();

        try{
            manager.persist(newMenu); // persist는 전달해주는 역할 (자바에있는걸 어디로?)
            transaction.commit();
        } catch(Exception e){
            transaction.rollback();
        }


        // then
        Assertions.assertTrue(manager.contains(newMenu));

    }

    @Test
    @DisplayName("메뉴 이름 수정 테스트")
    void updateMenuName(){

        // given
        Menu menu = manager.find(Menu.class, 2); // 2번쨰 메뉴 가져다줘
        System.out.println("menu = " + menu);

        String changeName = "아이스아메리카노얼음많이연하게";

        // when
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        // 트랜잭션
        try{
            menu.setMenuName(changeName);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }

        // then
        Assertions.assertEquals(changeName, manager.find(Menu.class, 2).getMenuName());

    }

    @Test
    @DisplayName("메뉴 삭제하기 테스트!")
    void deleteMenu(){

        Menu removeMenu = manager.find(Menu.class, 24);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        try{
            manager.remove(removeMenu);
            transaction.commit();
        } catch(Exception e){
            transaction.rollback();
        }

        Menu removedMenu = manager.find(Menu.class, 24);

        Assertions.assertNull(removedMenu);

    }



}
