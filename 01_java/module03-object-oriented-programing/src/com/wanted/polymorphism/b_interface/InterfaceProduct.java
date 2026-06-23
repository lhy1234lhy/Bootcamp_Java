package com.wanted.polymorphism.b_interface;

public interface InterfaceProduct {

    /* hi.
    *   인터페이스는 구현부가 있는 메소드를 작성할 수 없다.
    *   또한 생성자 역시 가질 수 없다.
    *   인터페이스의 역할 : 인터페이스 안에서 작성한건 다 구현해야함
    *  */

    // 인터페이스는 생성자를 못 쓴다.
//    public InterfaceProduct(){}

    // 인터페이스는 구현부({})가 있는 메소드를 못 쓴다.
//    public void test(){}

    void methodA();

    // 잘 안 씀
    static void staticMethod(){
        // static 메소드는 구현부 작성이 가능하다.
    };

}
