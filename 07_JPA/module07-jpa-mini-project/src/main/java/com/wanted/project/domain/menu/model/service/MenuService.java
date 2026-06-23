package com.wanted.project.domain.menu.model.service;

import com.wanted.project.domain.menu.model.dao.CategoryRepository;
import com.wanted.project.domain.menu.model.dao.MenuRepository;
import com.wanted.project.domain.menu.model.dto.CategoryDTO;
import com.wanted.project.domain.menu.model.dto.MenuDTO;
import com.wanted.project.domain.menu.model.entity.Category;
import com.wanted.project.domain.menu.model.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;    // 생성자 주입 완료 된 것.
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;          // 생성자 주입 완료 된 것.

    /* 1. 메뉴코드로 특정 메뉴 조회하기*/
    public MenuDTO findMenuByMenuCode(int menuCode) {

        // Entity 등장!               // findById = 우리가 만든 것이 아닌 JPA 가 제공하는 것.
        Menu foundMenu = menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);
//        System.out.println("foundMenu = " + foundMenu);        // entity를 사용자에게 그대로 보여주면 X. DTO로 보낼 것.

        // map(변환 대상, 변환 할 타입)
        MenuDTO menuDTO = modelMapper.map(foundMenu, MenuDTO.class);

        return menuDTO;     // DTO 타입으로 변환

    }

    // 쿼리 메소드 (얼마 이상만 조회...)
    public List<MenuDTO> findMenuByPrice(int menuPrice) {

        // Entity 등장!
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);
        // 메뉴 리스트에서 얼마 이상인거만 선별해서 가져옴(리스트로)
        // menuRepository 에 어떤 메소드들이 있나를 알아야 함
        // 조인할수록 findByMenuPriceGreaterThanOrderByMenuPrice이게 길고길어짐..
        // 그러면 쿼리문을 직접 작성해야되겠져?? (논리상의 오류는 없지만 가독성 안 좋으니깐..)
        System.out.println("menuList = " + menuList);

        return menuList.stream() //
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                // modelMapper: 엔티티를 DTO에 매핑을 해줌
                .collect(Collectors.toList()); // DTO를 다시 리스트로 만들어줌. 최종적으로 DTO 10개(예시임)가 담긴 리스트를 던져주는 것임
        //stream: 나열을 해줌
    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional // 커밋하고 뭐 하는 역할..
    public int registNewMenu(MenuDTO registMenu) {

        // save 시에는 entity 타입을 넣어야 한다.
        // 하지만 전달받고 있는 객체 타입은 DTO 타입이기 때문에
        // 마찬가지로 modelMapper 로 DTO -> Entity로 바꿔줄 것이다.
        Menu menu = modelMapper.map(registMenu, Menu.class);
        System.out.println("menu = " + menu);
        menuRepository.save(menu);

        return menu.getMenuCode();
        //menuRepository.save(modelMapper.map(registMenu, Menu.class)); // save랑 persist는 엔티티를 등록해줌

    }

    @Transactional
    public void modifyMenuName(int menuCode, String menuName) {

        // 수정 대상 엔티티 객체 찾아오기
        Menu foundMenu = menuRepository.findById(menuCode)
                                        .orElseThrow(IllegalArgumentException::new);

        System.out.println("영속성 컨텍스트에서 찾아온 foundMenu = " + foundMenu);
        // foundMenu 변수에는 수정 대상 엔티티가 담겨있다.

        /* 1. setter 사용해서 update -> setter 사용은 지양한다. */
//        foundMenu.setMenuName(menuName);

        /* 2. @Builder 어노테이션을 사용한 update 기능 */
//        foundMenu = foundMenu.toBuilder()
//                .menuName(menuName).build();
        // 새로운 인스턴스가 대입되는 것은 영속성 컨텍스트가
        // 아직 새로운 인스턴스가 알지 못하는 상황이다.
//        menuRepository.save(foundMenu);

        /* 3. Entity 내부에 직접 Builder 패턴을 구현 */
        foundMenu = foundMenu.changeMenuName(menuName).builder();
        // 원래 메뉴 정보 => 수정
        menuRepository.save(foundMenu);

    }
}
