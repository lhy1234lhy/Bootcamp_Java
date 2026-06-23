package com.wanted.securitysession.global;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.wanted.securitysession")
// "com.wanted.securitysession" 패키지와 그 하위 패키지들을 싹 다 뒤져서
// @Controller, @Service, @Repository, @Component 등의 어노테이션이 붙은 클래스들을 찾아
// 스프링 빈(Bean)으로 자동 등록
public class ContextConfig {

   @Bean
   // 엔티티객체를 dto로, dto 객체를 엔티티로 바꿀 수 있음..
   // 서로 다른 클래스의 객체 간에 필드 값을 자동으로 복사(매핑)
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }

}
