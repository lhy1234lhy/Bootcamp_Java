package com.wanted.entitymapping.section01.entity;

/* hi.
*   JDBC 프로젝트에서 DB와 접근하는 객체는 DAO 라고 표현했다.
*   Spring 환경에서는 JPA 를 사용할 때  DAO 계층을
*   @Repository 로 표현한다.
*   - Mybatis 기술을 사용하게 되면 @Mapper 라고 표현한다.
*  */

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    /* hi.
    *   해당 클래스는 엔티티 매니저를 주입받아
    *   영속성 컨텍스트가 Entity 클래스를 관리할 수 있도록 한다.
    *  */
    private EntityManager manager;

    public void save(Member member){
        manager.persist(member);
    }
}
