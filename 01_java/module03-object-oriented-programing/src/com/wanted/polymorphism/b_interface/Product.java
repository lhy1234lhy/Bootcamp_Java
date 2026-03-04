package com.wanted.polymorphism.b_interface;

public class Product implements InterfaceProduct{

    // 인터페이스에 작성한 methodA()를 반드시 써야한다.
    @Override
    public void methodA() {
        System.out.println("methodA 호출됨..");
    }

}
