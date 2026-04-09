package com.wanted.project.domain.menu.model.dao;

import com.wanted.project.domain.menu.model.entity.Category;
import com.wanted.project.domain.menu.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// 인터페이스는 구현체아님 껍데기. 그래서 상속 받아야 함.

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* hi. 해당 메서드는 JPA 쿼리메소드가 아닌 내가 직접 만든 메서드이다.
    *   Join 이 여러개이거나, 조건이 복잡한 경우 JPA 쿼리메소드로 작성하게 되면
    *   세밀하게 조절이 안 되는 경우가 있다.
    *   위 상황에서는 우리가 직접 SQL 구문을 작성할 수 있다.
    *   -jpql : entity 클래스를 대상으로 sql 구문을 작성하는 것. -> FROM entity명
    *   - native query : 실제 SQL 구문을 작성하는 것. -> FROM 실제테이블명
    *  */
    @Query(value = "SELECT * FROM TBL_CATEGORY ORDER BY CATEGORY_CODE", nativeQuery = true)
    // jpql은 SELECT catrgoryCode FROM category ORDER BY categoryCode 이런식으로 작성해야됨
    List<Category> findAllCategory();
}