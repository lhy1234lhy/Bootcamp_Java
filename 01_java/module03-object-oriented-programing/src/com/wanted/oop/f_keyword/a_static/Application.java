package com.wanted.oop.f_keyword.a_static;

public class Application {
    public static void main(String[] args) {

        /* hi. static 키워드에 대해 알아보자 */

        // 객체 생성 구문
        StaticFieldTest st1 = new StaticFieldTest();

        System.out.println("non=static 변수 확인 : " + st1.getNonStaticCount());
        System.out.println("static 변수 확인 : " + st1.getStaticCount());

        // 각 변수를 1씩 증가시키는 구문
        st1.increaseNonStatic();
        st1.increaseStatic();

        System.out.println("non=static 변수 확인 : " + st1.getNonStaticCount());
        System.out.println("static 변수 확인 : " + st1.getStaticCount());

        /* hi. 핵심 포인트
        *   새로운 StaticFieldTest 객체를 생성
        *   sout 구문을 실행했을 때 0,0 이 나오는 것을 기대했지만,
        *   실제로 static 키워드가 붙은 변수는 1이 출력되었다.
        *
        *   hi. static은 공유하기 위해서 사용됨. 값을 하나 세팅해놓으면 힙메모리와 관련 없이 값을 가져올 수 있다.
        *       (ex) 리모컨, 통로(옮길때마다 새로운 통로 만들지 않고 원래 통로 사용))
        *
        *   힙메모리에는 가비지 컬렉터가 있음. but, static은 없음. 그래서 신중하게 사용(공용으로 쓸거만)
        *  */

        // 객체 새로 만듦 (공간 새로 생성해서 0이 되어야 함. but, 결과가 non=static 변수 확인 : 0, static 변수 확인 : 1)
        // 즉, static 변수는 힙메모리와 관련X (메소드 Area에 저장됨)
        StaticFieldTest st2 = new StaticFieldTest(); // new 만나면 힙메모리 공간이 새로 생김
        System.out.println("non=static 변수 확인 : " + st2.getNonStaticCount());
        System.out.println("static 변수 확인 : " + st2.getStaticCount());

    }
}
