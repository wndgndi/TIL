Lv1. 소수 만들기 문제

주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    private boolean[] prime = new boolean[3001]; // 최대 3000까지이므로 배열 크기 3001
    
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        setPrime();
        for(int i=0; i<prime.length; i++) {   // prime의 길이만큼 반복
            if(prime[i] == false) {  // prime의 i번 인덱스가 false인 경우,
                list.add(i);   // list에 i를 추가함 (소수를 리스트에 넣어줌)
            }
        }
        for(int i=0; i<nums.length-2; i++) {   // nums 길이-2 만큼 반복
            for(int j=i+1; j<nums.length-1; j++) {   // nums 길이-1 만큼 반복
                for(int k=j+1; k<nums.length; k++) {   // nums 길이만큼 반복
                    int sum = nums[i] + nums[j] + nums[k];   // nums의 i, j, k번 인덱스를 더해줌
                    if(list.contains(sum)) {   // sum이 소수들을 모아둔 리스트에 포함되어 있다면,
                        answer++;  // answer를 1 증가시킴
                    }
                }
            }
        }

        return answer;   // answer를 반환
    }
    
    public void setPrime() {
        prime[0] = true;   // 0은 소수가 아니므로 true
        prime[1] = true;   // 1도 소수가 아니므로 true
        
        for(int i=2; i*i <= 3000; i++) {  // 2부터 i*i가 3000보다 작을 때까지 반복
            if(prime[i] == false) {  // prime의 i번 인덱스가 false인 경우(i가 소수인 경우), 
                for(int j=i*i; j<=3000; j+=i) {  // i의 배수들은 소수가 아니므로 
                    prime[j] = true;  j를 true로 바꿔서 소수가 아님을 표시
                }    
            }
        }
    }
}
