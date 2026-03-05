package com.wanted.a_generic.b_use.run;

import com.wanted.a_generic.b_use.*;

public class Application02 {
    public static void main(String[] args) {

        /* hi. 와일드카드
        *   제네릭 클래스 타입의 객체를 메소드의 매개변수로
        *   전달 받을 때, 그 객체의 타입 변수를 제한할 수 있다.
        *   <?> : 제한 없음
        *   <? extends Type> : 와일드카드 상한 제한 // 위는 안된다.
        *   <? super Type> : 와일드카드 하한 제한 // 아래는 안된다.
        *  */

        // wfarm 공간 만들기
        WildcardFarm wfarm = new WildcardFarm();

        // 이 3줄이
        Rabbit rabbit = new Rabbit();
        RabbitFarm<Rabbit> rfarm = new RabbitFarm<>(rabbit); // rabbit 객체 안 만들고 new Rabbit()를 ()에 통째로 넣음
        wfarm.anyType(rfarm);
        // 이 1줄과 같음
        wfarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));

        // 읽을 때 제일 안쪽에 있는 소괄호부터 읽음
        // new Rabbit() -> new RabbitFarm<Rabbit> -> wfarm.anyType
        // 래빗 객체 생성 -> 래빗객체를 래빗팜에 넣음 -> 애니타입으로 넘어감
        wfarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("======================================");
//        wfarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit())); // 버니 상속받은 것만 나올 수 있도록 함(래빗은 버니보다 상위)
        wfarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("======================================");
        wfarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wfarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny())); // 버니 위에 있는 래빗 & 버니만 가능
    }
}
