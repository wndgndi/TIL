10448번 문제

자연수 n에 대해 n ≥ 1의 삼각수 Tn는 명백한 공식이 있다.
Tn = 1 + 2 + 3 + ... + n = n(n+1)/2
1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 예를 들어,

4 = T1 + T2

5 = T1 + T1 + T2

6 = T2 + T2 or 6 = T3

10 = T1 + T2 + T3 or 10 = T4

이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 적은것에서 유레카 이론으로 알려졌다. 꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다. 위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.
자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 단, 3개의 삼각수가 모두 달라야 할 필요는 없다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1500];  // 크기가 1500인 배열 생성

        for(int i=1; i<=50; i++) {  // 50번 반복
            arr[i] = i*(i+1)/2;   // 삼각수들을 배열 arr의 i번째 인덱스에 넣어줌
        }

        int n = Integer.parseInt(br.readLine());   // 입력받은 문자열을 정수로 변환

        for(int i=0; i<n; i++) {   // n번만큼 반복
            int a = Integer.parseInt(br.readLine());  // 문자열 a를 입력받아 정수로 변환
            loop:   // 반복문을 한번에 탈출하기 위한 루프
            for(int j=1; j<50; j++)  {    // 1부터 49까지 반복
                for(int k=1; k<50; k++) {   // 1부터 49까지 반복
                    for(int l=1; l<50; l++) {  // 1부터 49까지 반복
                        if(arr[j] + arr[k] + arr[l] == a) {   // 배열 arr의 j, k, l번째 인덱스의 합이 a와 같다면,
                            System.out.println(1);   // 1을 출력함
                            break loop;   // 1을 출력했으면 루프 탈출
                        } else if(j==49 && k==49 && l==49 && arr[j] + arr[k] + arr[l] != a) {   // j, k, l이 49이고 인덱스의 합이 a와 같지 않다면,
                            System.out.println(0);   // 0을 출력함
                        }

                    }
                }
            }
        }
    }
}
