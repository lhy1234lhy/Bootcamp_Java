package com.wanted.c__method;

public class Calculator {

    /* hi. 계산을 잘할 수 있는 메소드들의 집합체 */

    // 전달 받은 두 수를 비교해서 최솟값 반환하는 메소드
    public int minNumberOf(int first, int second){
        // first 는 100 , second 는 50이 들어있는 상태.

        return (first > second) ? second : first; //true면 첫번째(second), false면 두번째(first) (3항 연산자?)
    }

    // 전달 받은 두 수를 비교해서 최솟값 반환하는 메소드
    public static int maxNumberOf(int first, int second){
        return (first > second) ?  first : second; //true면 첫번째, false면 두번째 (3항 연산자)
    }
}
