package com.wanted.securitysession.domain.user.model.dao;


import com.wanted.securitysession.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 엔티티 매니저가 엔티티 클래스를 관리하는 공간 (persistence Context)

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // <> 안에는 User 엔티티와 기본키인 userCode의 형식? Integer 작성
    // 사용자 ID로 사용자 찾기
    Optional<User> findByUserId(String userId);
    
    // 사용자 ID가 이미 존재하는지 확인 (중복 ID 체크)
    boolean existsByUserId(String userId);
}
