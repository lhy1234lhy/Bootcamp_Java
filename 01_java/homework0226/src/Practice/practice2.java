package Practice;

import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 한 개 입력하세요 : ");
        int input = sc.nextInt();
        if(input < 0){
            System.out.println("양수만 입력해주세요.");
        } else if(input%2==1){
            System.out.println("홀수임");
        } else{
            System.out.println("짝수임");
        }
    }
}
