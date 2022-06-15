import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  // 문자열 n을 입력받는다
        int arr[] = new int[n];   // 길이가 n인 배열을 만들어준다

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {   // n번만큼 반복
            arr[i] = Integer.parseInt(st.nextToken());   // 토큰이 없을 때까지 정수로 변환해서  
        }                                                // i번째 인덱스에 넣어줌

        Arrays.sort(arr);  // 배열 arr을 오름차순으로 정렬해줌
        int m = Integer.parseInt(br.readLine());  // 입력받은 문자열을 정수로 변환

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {    // m번만큼 반복
            int temp = Integer.parseInt(st.nextToken());  // 비교하려는 토큰을 정수로 변환
            sb.append(binarySearch(arr,n,temp)+" ");  // sb에 넣어줌
        }
        bw.write(sb.toString() + "\n");  // sb 를 출력해줌
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int[] arr, int n, int search) {
        int first = 0;   // 왼쪽 끝 인덱스
        int last = n-1;  // 오른쪽 끝 인덱스
        int mid = 0;   // 중간 인덱스

        while(first <= last) {   
            mid = (first + last)/2;   // mid는 first와 last의 중간값이다.

            if(arr[mid] == search) {   // 찾으려는 값과 중간 인덱스가 같다면,
                return 1;   // 1을 반환한다
            }

            if(arr[mid] < search) {   // 찾으려는 값이 중간 인덱스보다 크면,
                first = mid + 1;    // first의 값을 mid+1로 만들어준다
            } else {    // 찾으려는 값이 배열의 중간 인덱스보다 작으면,
                last = mid - 1;    // last의 값을 mid-1로 만들어준다.
            }
        }
        return 0;  // 0을 반환한다
    }
}