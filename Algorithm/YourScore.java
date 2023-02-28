25206번 문제

인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!

치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.

전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.

인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.

A+	4.5
A0	4.0
B+	3.5
B0	3.0
C+	2.5
C0	2.0
D+	1.5
D0	1.0
F	0.0
P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.

과연 치훈이는 무사히 졸업할 수 있을까?


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        double sum = 0;  // 학점 * 평점의 합을 구하기 위한 변수
        double scoreSum = 0;   // 학점의 총합을 구하기 위한 변수

        for(int i=0; i<20; i++) {   // 20번 반복
            st = new StringTokenizer(br.readLine());   // 문자열을 입력받음
            String subName = st.nextToken();   // 첫 토큰을 과목 이름으로 받음
            double score = Double.parseDouble(st.nextToken());  // 두번째 토큰을 학점으로 받아서 실수로 변환
            String grade = st.nextToken();  // 세번째 토큰을 등급으로 받음 
            scoreSum += score;  // scoreSum에 학점을 누적하여 더해줌

            if(grade.equals("A+")) {  // 등급이 "A+"인 경우,
                sum += score * 4.5;   // sum에 학점 * 4.5 를 더해줌
            } else if(grade.equals("A0")) {   // 등급이 "A0"인 경우,
                sum += score* 4.0;   // sum에 학점 * 4.0 을 더해줌
            } else if(grade.equals("B+")) {   // 등급이 "B+"인 경우,
                sum += score* 3.5;   // sum에 학점 * 3.5 를 더해줌
            } else if(grade.equals("B0")) {  // 등급이 "B0"인 경우,
                sum += score* 3.0;   // sum에 학점 * 3.0 을 더해줌
            } else if(grade.equals("C+")) {   // 등급이 "C+"인 경우,
                sum += score* 2.5;   // sum에 학점 * 2.5 를 더해줌
            } else if(grade.equals("C0")) {    // 등급이 "C0"인 경우,
                sum += score* 2.0;   // sum에 학점 * 2.0 을 더해줌
            } else if(grade.equals("D+")) {  // 등급이 "D+"인 경우, 
                sum += score* 1.5;   // sum에 학점 * 1.5 를 더해줌
            } else if (grade.equals("D0")) {   // 등급이 "D0"인 경우,
                sum += score* 1.0;  // sum에 학점 * 1.0 을 더해줌
            } else if(grade.equals("F")) {   // 등급이 "F"인 경우,
                sum += score* 0.0;  // sum에 학점 * 0.0 을 더해줌
            } else if(grade.equals("P")) {  // 등급이 "P"인 경우,
                scoreSum -= score;  // scoreSum에서 학점을 빼줌
            }
        }

        double avg = sum/scoreSum;   // sum을 scoreSum으로 나눠줌
        String avgs = String.format("%6f", avg);   // 실수 avg의 소수점 여섯 자리 까지만 출력
        bw.write(avgs); 
        bw.flush();
        bw.close();
    }

}