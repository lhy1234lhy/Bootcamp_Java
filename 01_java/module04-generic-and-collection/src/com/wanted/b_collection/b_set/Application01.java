package com.wanted.b_collection.b_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application01 {
    public static void main(String[] args) {
        
        /* hi. Set 자료구조의 특징
        *   1. 요소의 저장 순서를 유지하지 않는다.
        *   2. 같은 요소의 중복저장을 허용하지 않는다. (null 도 단 1개의 null 만 들어간다.) 
        * */
        
        // Set 을 구현한 HashSet 클래스를 가장 많이 사용한다.
        Set<String> hset = new HashSet<>();
        
        hset.add("java");
        hset.add("db");
        hset.add("servlet");
        hset.add("spring");
        // 중복 허용 금지!
        hset.add("grafana");
        hset.add("grafana");

        System.out.println("hset = " + hset);

        // 순서 똑같음
//        for(String str : hset){
//            System.out.println("str = " + str);
//        }

        // 값 꺼내는 대표적인 방법
        // Iterator 클리스의 iterator() 메소드 활용해서 연속 처리
        Iterator<String> iter = hset.iterator();

        // hasNext() : 순서가 없는 자료형에서 순회를 해야 할 때 많이 쓰인다.
        // 다음 요소가 있는 지를 확인해주는 메소드로, 요소가 더 이상 없을 떄까지 반복해준다.
        while ((iter.hasNext())){
            System.out.println(iter.next());
        }
        
    }
}
