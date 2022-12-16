Lv1. 비밀지도 문제

네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
"지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.


< 코드 >

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        
        for(int i=0; i<n; i++) {   // n번만큼 반복
            sb1.append(Integer.toString(arr1[i], 2));   // sb1에 arr1의 i번째 인덱스를 이진수로 변환해 넣어줌
            sb2.append(Integer.toString(arr2[i], 2));   // sb2에 arr2의 i번째 인덱스를 이진수로 변환해 넣어줌
            
            int a = sb1.length();   // 변수 a에 sb1의 길이를 넣어줌
            int b = sb2.length();   // 변수 b에 sb2의 길이를 넣어줌
            
            if(sb1.length() != n) {       // sb1의 길이가 n과 다르면,
                for(int j=0; j<n-a; j++)   // n-a번 만큼 반복
                sb1.insert(0, "0");     // sb1의 0번째 인덱스에 "0"을 넣어줌
            }
            
            if(sb2.length() != n) {   // sb2의 길이가 n과 다르다면,
                for(int j=0; j<n-b; j++)   // n-b번 만큼 반복
                sb2.insert(0, "0");   // sb2의 0번째 인덱스에 "0"을 넣어줌
            }
            
            str1[i] = sb1.toString();     //  str1의 i번째 인덱스에 sb1을 넣어줌
            str2[i] = sb2.toString();     //  str2의 i번째 인덱스에 sb2를 넣어줌
            sb1.setLength(0);   // sb1의 길이를 0으로 초기화
            sb2.setLength(0);   // sb2의 길이를 0으로 초기
        }
        
        for(int i=0; i<n; i++) {    // n번만큼 반복
 
            for(int j=0; j<n; j++) {   // n번만큼 반복
                char num1 = str1[i].charAt(j);   // str1의 i번째 인덱스의 j번째 글자를 넣어줌
                char num2 = str2[i].charAt(j);   // str2의 i번째 인덱스의 j번째 글자를 넣어줌
                if(num1 == '1' || num2 == '1') {   // num1이 '1' 또는 num2가 '1'이라면,
                    sb1.append("#");    // sb1에 "#"을 넣어줌
                }  else {     // num1과 num2가 모두 '1'이 아니라면,
                    sb1.append(" ");   // sb1에 " "을 넣어줌
                }
            }
            answer[i] = sb1.toString();   // sb1을 answer의 i번째 인덱스에 넣어줌
            sb1.setLength(0);   // sb1의 길이를 0으로 초기화
            
        }
        
        return answer;    // answer를 반환
    }
}