2839번 문제

상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 
배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 
3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.


import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {	
		   Scanner sc = new Scanner(System.in);
		   int sugar = sc.nextInt();
		   int bag = 0;
		   
		   loop :       // loop를 통해 break으로 빠져나올 위치 지정
		   for(int i=0; i<=sugar/3; i++) {   // 3킬로 봉지가 차선
			   for(int j=0; j<=sugar/5; j++) {    // 5킬로 봉지가 최선
				  if(sugar == 5*j + 3*i) {    // 봉지의 개수와 일치할 시
					  bag = i+j;	// 위에서 구한 3키로 봉지와 5키로 봉지를 더함					  
					  break loop;
				 }
				  else {     // 3, 5키로 봉지로 설탕 무게를 맞출 수 없는 경우
					  bag = -1;
				  }
			   }
		   	 }		
		   System.out.println(bag);
	  }
}
