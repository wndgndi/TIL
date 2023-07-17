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
        StringBuilder sb = new StringBuilder();

        String equation = br.readLine();
        String[] operator = Arrays.stream(equation.split("-")).toArray(String[]::new);
        int n = 0;

        for(int i=0; i<operator.length; i++) {
            int tmp = sum(operator[i]);

            if(i==0) {
                n += tmp;
            } else {
                n -= tmp;
            }
        }

        System.out.println(n);
    }

    public static int sum(String str) {
        String[] nums = Arrays.stream(str.split("\\+")).toArray(String[]::new);
        return Arrays.stream(nums).map(Integer::parseInt).mapToInt(i->i).sum();
    }

}
