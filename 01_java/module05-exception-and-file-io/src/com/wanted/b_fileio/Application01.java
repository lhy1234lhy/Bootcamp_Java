package com.wanted.b_fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application01 {

    public static void main(String[] args) {

        /* hi. 파일 입력과 출력
        *   파일 입출력은  프로그램에서 데이터를 파일에 저장하거나, 읽어오는 기능을 의미한다.
        *   이는 데이터를 우리가 영구적으로 보존하거나, 외부의 데이터(우리가 작성한 코드 외)를 활용할 때 필수적이다.
        *   파일작업은 외부 자원에 의존을 한다.
        *   파일이 없거나 권한 부족하거나, 이름이 잘못되거나 기타 등등의 예외 상황이 자주 발생한다.
        *  */

        // 기본 파일 작성해보기
        try {
            // 파일 관련 클래스들은 예외를 객체 생성 시에 반드시 처리해야한다.
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello, Wanted!!");
            writer.write("File Test...");

            // flush() 버퍼에 있는 데이터를 밀어서 버퍼를 비우고 즉시 디스크에 기록한다.
            writer.flush();
            System.out.println("파일 쓰기 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // finally 블럭에서 열린 자원을 닫아줘야 한다. (다음 시간에...)

        try {
            FileReader reader = new FileReader("output.txt");
            // 읽을 파일명을 지정하지 않으면, FileNotFFoundException 이 뜨게 된다.

            int data;
            // 파일 끝까지 읽는 방법 (파일 끝은 -1 정의 됨.)
            // .read() : 파일에서 한 문자씩을 읽고, 파일 끝에 도달하면 -1을 반환한다.
            while ((data = reader.read()) != -1){ // 밑에캐치절 추가
                System.out.println((char)data);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
