package com.wanted.oop.f_keyword.b_singleton;
public class Application {
    public static void main(String[] args) {

        /* hi. static 키워드를 이용한 singleton 패턴
        *   어플리케이션이 실행될 때 어떤 클래스가 최초 한 번만
        *   메모리에 할당되고, 그 메모리에 인스턴스를 만들어서
        *   하나의 인스턴스를 공유해 사용하여 메모리 낭비를 방지할 수 있게하는 디자인 패턴이다.
        *  */


        /* hi. 싱글톤 패턴을 만드는 방법은 2가지가 있다.
        *    1. 이른 초기화 (Eager)
        *    2. 게으른 초기화 (Lazy)
        * */

        // 기본 생성자 private으로 막아놔서 안됨
//        EagerSingleton eager1 = new EagerSingleton();

        // 주소 알아보기 쉽게 바꾸는 hashCode 사용. eager1,2 주소 똑같이 나옴
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();

        // 두 객체는 static 키워드로 만든 객체이기 때문에 동일한 인스턴스임을 확인할 수 있다.
        System.out.println("eager1의 주민번호 : " + eager1.hashCode());
        System.out.println("eager2의 주민번호 : " + eager2.hashCode());

        /*========================================================================*/
        // 실무에서는 lazy 씀. 필요한 시점에 만듦
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        System.out.println("lazy1의 주민번호 : " + lazy1.hashCode());
        System.out.println("lazy2의 주민번호 : " + lazy2.hashCode());

    }
}
