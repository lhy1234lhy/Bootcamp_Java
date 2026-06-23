package com.wanted.b_variable.chap01;

import java.util.Scanner;

public class Application2 {
    // 제목에 어플리케이션 들어가면 main + enter
    public static void main(String[] args) {

        // Scanner 클래스는 사용자의 입력을 저장할 수 있다.
        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력해주세요: ");
        String name = sc.nextLine(); //next와 nextLine의 차이점: 들여쓰기 하냐 마냐

        System.out.println("입력한 Name 값: " + name);

        // sc. (.은 참조연산자, =은 대입연산자)

    }

}
