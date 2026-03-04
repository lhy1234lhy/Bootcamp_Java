package com.wanted.inheritance.extend;

public class Application {
    public static void main(String[] args) {

        /* hi. extend
        *   상속의 개념을 가지고 있다. 현실세계와 같은 개념이다.
        *   (부모의 돈은 내 돈, 내 돈도 내 돈)
        *   부모가 가지고 있는 멤버(필드, 메소드)를 자식이 물려받는다.
        *   따라서 자식은 실제로 내 것은 아니지만, 내 것처럼 사용을 할 것이다.
        *  */

        /* hi. overriding
        *   오버라이딩이랑?
        *   메소드를 재정의 하는 것이다
        *   부모가 가지는 메소드 선언부를 그대로 사용하면서
        *   자식인 클래스가 정의한 메소드 대로 동작할 수 있도록
        *   구현 몸체를 새롭게 작성하는 것을 말한다.
        *  */

        // 부모꺼 먼저 호출 (Car 클래스의 기본 생성자 호출됨... / FireCar 의 기본 생성자 호출됨...) 후에 자식꺼 호출
        Car car = new Car();
        car.soundHorn();
        car.run();
        car.soundHorn();
        car.stop();
        car.soundHorn();
        System.out.println("=================구분선=================]");

        FireCar fireCar = new FireCar();
        fireCar.soundHorn();
        fireCar.run();
        fireCar.soundHorn();
        fireCar.stop();
        fireCar.soundHorn();
        fireCar.sprayWater();
        System.out.println("=================구분선=================]");
    }
}
