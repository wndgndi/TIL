import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		int i = 0;		
		while(true) {
			b++;
			i = i+b;   // 규칙을 찾기 위한 식
			
            if(i >= a) {   // 계차 수열의 마지막 값이므로 a보다 크거나 같아야 함
				if(b%2 == 0) {   // b의 나머지에 따라 1/x인지 x/1인지 구분
						System.out.println((a-i+b) + "/" + (i-a+1));
				}
						
			
				else {
						System.out.println((i-a+1) + "/" + (a-i+b));	
				}
				break;
			}	
		}
	}
}