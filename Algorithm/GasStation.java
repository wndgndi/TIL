import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());   // 도시의 개수를 문자열로 입력받아 정수로 변환
        long[] distance = new long[n-1];   // 크기가 n-1인 배열 생성
        long[] price = new long[n];  // 크기가 n인 배열 생성

        String[] distancestr = br.readLine().split(" ");   // 공백을 구분자로 나눠서 거리 넣어줌

        for(int i=0; i<n-1; i++) {    // n-1번만큼 반복
            distance[i] = Long.parseLong(distancestr[i]);   // 배열에 들어있는 거리 인덱스들을 정수로 변환
        }

        String[] pricestr = br.readLine().split(" ");  // 공백을 구분자로 나눠서 가격 넣어줌

        for(int i=0; i<n; i++) {  // n번만큼 반복
           price[i]  = Integer.parseInt(pricestr[i]);   // 배열에 들어있는 가격 인덱스들을 정수로 변환
        }

        long minprice = price[0];   // 최소 가격을 minprice로 정하고 첫번째 도시의 가격 넣어줌
        long value = minprice*distance[0];  // 최소 가격*거리를 통해 최소 비용 구함

        for(int i=1; i<n-1; i++) {    // n-1번만큼 반복
            if(minprice>price[i]) {   // minprice가 가격 배열의 i번째 인덱스보다 작으면,
                minprice = price[i];  // 해당 인덱스 값을 minprice로 정함
            }
            value += minprice*distance[i];   // 최소값*거리를 누적해서 더하여 최소 비용 구함
        }

        System.out.println(value);  // 최소 비용 출력
    }
}