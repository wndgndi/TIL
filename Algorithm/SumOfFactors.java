백준 9506번 문제

어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.

예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.

n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        while(true) {   // 계속 반복
            int n = Integer.parseInt(br.readLine());   // 문자열 입력받아서 정수로 변환
            int sum = 0;

            if(n == -1) {   
                break;  // 입력받은 정수가 -1이면 반복문 탈출
            }

            for(int i=1; i*i<=n; i++) {   // i*i가 n보다 작을 때까지 반복
                if(n%i == 0) {   // i가 n의 약수이면,
                    list.add(i);   // i를 리스트에 넣어줌
                    list.add(n/i);   // 나머지 약수도 넣어줌
                }
            }

            Collections.sort(list);   // 리스트를 오름차순으로 정렬

            for(int i=0; i<list.size()-1; i++) {    // 리스트 크기-1 만큼 반복
                sum += list.get(i);   // sum에 list의 마지막 값(n)을 제외하고 모두 더해줌
            }

            if(sum == n) {    // sum이 n과 같다면,
                bw.write(n + " = ");  
                for(int i=0; i<list.size()-1; i++) {     // 리스트 크기-1만큼 반복
                    if(i<list.size()-2) {   // n을 제외한 마지막 약수가 아닐 경우,
                        bw.write(list.get(i) + " + ");  
                    } else {   // n을 제외한 마지막 약수일 경우,
                        bw.write(list.get(i) + "\n");
                    }
                }
            } else {   // sum이 n과 다르면,
                bw.write(n + " is NOT perfect." + "\n");
            }
            list.clear();
        }
        bw.flush();
        bw.close();
    }

}
