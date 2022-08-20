13305번 문제​

어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다. 편의상 일직선을 수평 방향으로 두자. 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다. 
인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다. 도로 길이의 단위는 km를 사용한다.

처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다. 기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다. 
도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다. 각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다. 가격의 단위는 원을 사용한다.
제일 왼쪽 도시에서 6리터의 기름을 넣고, 더 이상의 주유 없이 제일 오른쪽 도시까지 이동하면 총 비용은 30원이다. 만약 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 
다음 번 도시까지 이동한 후 3리터의 기름을 넣고(3×2 = 6원) 다음 도시에서 1리터의 기름을 넣어(1×4 = 4원) 제일 오른쪽 도시로 이동하면, 총 비용은 20원이다. 
또 다른 방법으로 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 4리터의 기름을 넣고(4×2 = 8원) 
제일 오른쪽 도시까지 이동하면, 총 비용은 18원이다.

각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.


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