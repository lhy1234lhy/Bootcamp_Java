package com.wanted.di.section03.config;

import com.wanted.di.section03.gateway.PaymentInterface;
import com.wanted.di.section03.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.wanted.di.section03")
// 스캔범위 주의(아예 안 쓰면 자기꺼 자동으로..)
public class AppConfig {


}
