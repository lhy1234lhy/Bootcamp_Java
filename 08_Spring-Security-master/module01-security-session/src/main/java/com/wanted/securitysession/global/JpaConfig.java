package com.wanted.securitysession.global;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.wanted.securitysession")
// Jpa 레파지토러를 사용할 수 있게 함
@EntityScan(basePackages = "com.wanted.securitysession")
// 패키지는 둘 다 같은 곳을 바라보도록 함
@Configuration
public class JpaConfig {
}
