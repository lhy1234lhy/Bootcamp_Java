package com.wanted.exceptionhandeler;

// Exception을 상속받아 예외 관련 클래스가 됨
public class MemberNotFoundException extends Exception {

    public  MemberNotFoundException(String message){
        super(message);
    }

}
