11866번 문제

요세푸스 문제는 다음과 같다.
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");  // 입력받은 문자열을 공백을 구분자로 나눔
        int n = Integer.parseInt(str[0]);  // str[0]을 정수로 변환
        int k = Integer.parseInt(str[1]); // str[1]을 정수로 변환
        int cnt=1;  // k번째 사람을 제거하기 위한 변수

        for(int i=1; i<=n; i++) {
            que.add(i);  // 큐에 n명을 넣어줌
        }
        while(que.size()!=0) {  // 큐의 크기가 0이 아닐 동안 반복
            if (cnt==k) {  // k번째가 된다면
                if(que.size()==n && n!=1) {  // 큐 크기가 n과 같을 경우
                    sb.append("<" + que.poll() + ", ");  // sb에 '<'를 넣고 큐를 poll 해준다
                    cnt = 1;  // 다시 k번째를 세기 위해 cnt를 1로 초기화 해준다.
                }
                else if(n==1) {   //  n이 1인 경우
                    sb.append("<" + que.poll() + ">");  //  sb에 '< >' 과 큐를 poll 해준다
                }
                else {   // 큐의 크기가 n과 다른 경우
                    if (que.size() == 1) {  // 큐 크기가 1인 경우
                        sb.append(que.poll() + ">");  // sb에 큐를 poll해주고 '>'를 넣는다.
                    } else {  // 큐의 크기가 1이 아닌 경우
                        sb.append(que.poll() + ", ");  // sb에 큐를 poll 해주고 ', '를 넣는다.
                        cnt = 1;  //  k번째를 세기 위해 다시 cnt를 초기화
                    }
                }
            } else {   cnt가 k번째가 아닐 경우
                que.add(que.poll());  // 큐를 poll해서 다시 add 해준다
                cnt++;  // cnt가 1씩 증가
            }
        }
        bw.write(sb.toString());  // sb를 출력해준다
        bw.flush();
        bw.close();
    }
}