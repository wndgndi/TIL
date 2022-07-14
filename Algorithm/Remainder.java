3052번 문제

두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];     // arr 배열에 10개의 인덱스 생성
		int count=0;
		int tmp;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt()%42;   // arr 배열의 i번째 인덱스에 입력값을 42로 나눈 나머지
		}
		
		for(int i=0; i<10; i++) {    // 중복값을 걸러내기 위한 반복
			tmp=0;   
			for(int j=i+1;j<10; j++) {     // i와 j를 비교하여 같으면 tmp 값을 1 증가시킨다
				if(arr[i] == arr[j]) {     // 중복되는 값을 걸러낸다
					tmp++;
				}
			}
			if(tmp==0) {    // 중복되지 않은 값을 걸러낸다.
				count++; 
			}
		}
		System.out.println(count);
	}
}
