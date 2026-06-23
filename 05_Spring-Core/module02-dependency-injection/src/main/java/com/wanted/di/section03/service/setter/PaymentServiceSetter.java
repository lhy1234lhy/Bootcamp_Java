package com.wanted.di.section03.service.setter;

import com.wanted.di.section03.gateway.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceSetter {

    /* hi.
    *    @Autowired 를 setter 메소드에 작성해서 의존성 주입
    *   장점
    *   1. 선택적 의존성 : 주입이 필수가 아니며, Setter 메소드를 통해서 변경가능
    *   2. 런타임 변경 가능 : 의존성을 동적으로 변경 가능
    *   단점
    *   1. final 키워드를 사용하지 못하기 때문에 불변성 보장 불가
    *   2. 주입 누락 위험 : setter 메소드를 호출하지 않으면 null 상태로 사용됨.
    *  */


    private PaymentInterface paymentInterface;
    // 얘가 필드. 생성되는 시점에는 기본값인 null이다.

    @Autowired
    public void setPaymentInterface(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }

    public boolean processPayment(String orderId, double amount){
        System.out.println("결제 비즈니스 로직 시작. 주문 ID = " + orderId + ", 금액 = "+ amount);

        // 결제 게이트웨이를 통한 결제 처리
        boolean result = paymentInterface.processPayment(orderId, amount);
        if(result){
            System.out.println("결제 처리가 성공적으로 마무리!");
        } else{
            System.out.println("결제 처리 실패..🚨🚨🚨");
        }
        return result;
    }

}
