package com.wanted.aop.section02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 이거 전체 환경 설정 파일이니까 먼저 읽어
@ComponentScan("com.wanted.aop.section02")
// Bean들을 스캔할 수 있게 설정
@EnableAspectJAutoProxy
public class AppConfig {



}
