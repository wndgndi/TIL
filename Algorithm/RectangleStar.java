Lv1. 직사각형 별찍기 문제

이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.


import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();   // 가로 길이 입력받음
        int b = sc.nextInt();   // 세로 길이 입력받음
        
        for(int i=0; i<b; i++) {   // 세로 길이만큼 반복
            for(int j=0; j<a; j++) {   // 가로 길이만큼 반복
              System.out.print("*");   // "*" 모양을 출력
             }
            System.out.println();  // 줄바꿈
          }
    }
}
