package Practice;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {

        System.out.println("\n 1. 수정 \n 2. 조회 \n 3. 삭제 \n 4. 종료");

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴 번호를 입력하세요 : ");

        int input = sc.nextInt();

        String menu;

        switch(input){
            case 1:
                menu = "수정";
                break;
            case 2:
                menu = "조회";
                break;
            case 3:
                menu = "삭제";
                break;
            case 4:
                menu = "종료";
                break;
        }
        if(input == 4){
            System.out.println("프로그램이 종료됩니다.");
        } else {
            System.out.println(input + "메뉴입니다.");
        }
    }
}
