import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];

        for(int i=0; i<9; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int row = 0;   // 행 번호를 구하기 위한 변수
        int column = 0;   // 열 번호를 구하기 위한 변수
        int max = 0;   // 최대값을 구하기 위한 변수

        for(int i=0; i<9; i++) {   // 9번 반복
            for(int j=0; j<9; j++) {    // 9번 반복
                if(arr[i][j] > max) {   // i행 j열 값이 max 값보다 크다면
                    max = arr[i][j];   // max에 i행 j열 값을 넣어줌
                    row = i+1;   // 배열은 인덱스 0부터이므로 1을 더해서 행을 계산
                    column = j+1;   // 배열은 인덱스 0부터이므로 1을 더해서 열을 계산
                }
            }
        }

        if(row == 0 && column == 0) {   // 모든 값이 0이라 구한 행과 열이 모두 0인 경우,
            row = 1;   // 행은 1행
            column = 1;   // 열은 1열
        }

        bw.write(max + "\n");
        bw.write(row + " " + column + "\n");
        bw.flush();
        bw.close();
    }

}
