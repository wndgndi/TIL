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

        int sub = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int max = Arrays.stream(arr).map(Integer::parseInt).mapToInt(i -> i).max().getAsInt();
        Double avg = Arrays.stream(arr).map(Double::parseDouble).mapToDouble(i -> i).map(i -> i/max*100).average().getAsDouble();

        bw.write(avg + "\n");
        bw.flush();
        bw.close();
    }

}