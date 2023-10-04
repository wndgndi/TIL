import java.io.*;
import java.math.BigInteger;

public class Main {
	//입력 부분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        long[] numbers =  new long[T]; //정수들을 압력받아 저장할 배열

        for(int i = 0; i < T; i++){
            numbers[i] = Long.parseLong(br.readLine()); //정수 입력 받고
        }

        br.close(); //입력 버퍼 닫기

        printSection(numbers);
    }
    //소수 찾는 메소드
    static BigInteger findPrimeNumber(BigInteger num){

        if(num.isProbablePrime(10)){ //만약 지금 받은 매개변수가 소수이면
            return num; //그대로 반환
        }else{
            return num.nextProbablePrime(); //다음 소수 반환
        }
    }

    //출력 부분
    static void printSection(long[] array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < array.length; i++){
        	//isProbablePrime()랑 nextProbablePrime()가 BigInteger의 형태에서만 지원함.
            BigInteger bigNumber = new BigInteger(String.valueOf(array[i]));
            bw.write(findPrimeNumber(bigNumber) + "\n"); 
        }

        bw.flush();
        bw.close();
    }
}