package com.wanted.a_generic.b_use;
// 그냥 클래스
public class WildcardFarm {

    /* hi. 와일드카드
     *   제네릭 클래스 타입의 객체를 메소드의 매개변수로
     *   전달 받을 때, 그 객체의 타입 변수를 제한할 수 있다.
     *   <?> : 제한 없음
     *   <? extends Type> : 와일드카드 상한 제한 // 위는 안된다.
     *   <? super Type> : 와일드카드 하한 제한 // 아래는 안된다.
     *  */

    // 3가지 메소드 생성
    public void anyType(RabbitFarm<?> farm){ // farm 에 .찍는 순간 래빗이 됨 (.cry() 하면 토끼 울음소리 출력)
        farm.getAnimal().cry();
    }

    public void extendsType(RabbitFarm<? extends  Bunny> farm){ //버니가 기준. 상한 제한. (래빗 안됨)
        farm.getAnimal().cry();
    }

    public void superType(RabbitFarm<? super Bunny>farm){ // 래빗팜에서 <T> 하면 애니멀, 매멀 등도 있어서 cry() 찾다가 에러남
        farm.getAnimal().cry();
    }
}
