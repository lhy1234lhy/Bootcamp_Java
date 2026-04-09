package com.wanted.associationmapping.section03.bidirection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiService {

    // 1. 의존성 주입 (생성자 주입 방식 사용)
    private final BiRepository repository;

    public BiService(BiRepository repository) {
        this.repository = repository;
    }

    public Menu findMenu(int menuCode) {
        return repository.findMenu(menuCode);
    }

    /* hi.
     * OneToMany 관계는 Lazy Loading 이 기본값이다.
     * 따라서 트랜잭션이 없다고 하면 Menu가 필요한 상황에서 데이터를 조회하다가 오류가 발생할 수 있다.
     * 트랜잭션 안에서는 변경 된 내용이 자동으로 반영된다(변경 감지)
     * 여러 객체를 함께 바꿀 때 중간에 실패하면 전부 rollback 을 하는 것이
     * Transaction 의 기능이기 때문에 LazyLoading 시에는 반드시 Transaction을 작성하자.
     * */

    // 2. 중복된 findCategory 메서드 병합 및 변수명(categoryCode) 수정
    @Transactional(readOnly = true)
    public Category findCategory(int categoryCode) {
        Category foundCategory = repository.findCategory(categoryCode);

        // NPE 방지를 위해 null 체크 후 출력하는 것이 좋습니다.
        if (foundCategory != null) {
            System.out.println(foundCategory.getMenuList());
        }

        return foundCategory;
    }

    // 3. 반환값을 void로 수정 & 4. 저장 시 트랜잭션 추가
    @Transactional
    public void registMenu(Menu newMenu) {
        repository.saveMenu(newMenu);
    }

    // 4. 저장 시 트랜잭션 추가
    @Transactional
    public void registCategory(Category category) {
        repository.saveCategory(category);
    }
}