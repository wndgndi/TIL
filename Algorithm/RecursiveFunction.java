import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String underbar ="";
    public static void recur(int N) {
        
        //따로 저장을 안하면 나중에 line이 안줄어든다.
        String line = underbar;

        //재귀함수의 종료
        if(N==0) {
            System.out.println(line + "\"재귀함수가 뭔가요?\"");
            System.out.println(line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(line + "라고 답변하였지.");
            return;
        }
        //재귀함수 반복
        System.out.println(line +"\"재귀함수가 뭔가요?\"");
        System.out.println(line +"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        //줄 생성
        underbar += "____";

        recur(N-1);  // N이 1씩 감소하며 recur에 매개변수로 다시 들어감

        // 맨 마지막
        // 위의 recur(N-1)에서 계속 재귀하며 N=2, N=1 일때의 출력문을 출력한다.
        System.out.println(line + "라고 답변하였지.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(N);
    }
}