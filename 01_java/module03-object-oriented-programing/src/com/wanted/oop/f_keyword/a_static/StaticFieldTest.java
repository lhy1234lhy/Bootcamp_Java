package com.wanted.oop.f_keyword.a_static;

public class StaticFieldTest {

    private int nonStaticCount;
    private static int staticCount;

    // 기본 생성자
    public StaticFieldTest(){}

    // alt + insert로 getter만 가져옴
    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }


    /* 각 필드를 호출 시 마다 1씩 증가시키는 용도의 메소드 */
    public void increaseNonStatic(){
        this.nonStaticCount++; // this는 자기 자신. 즉 주소.
    }

    public void increaseStatic(){
        // static이 붙은 키워드들은 힙메모리 공간에 없음 (메소드 Area에 있음)
        // 클래스명.변수명
        StaticFieldTest.staticCount++;

    }

}
