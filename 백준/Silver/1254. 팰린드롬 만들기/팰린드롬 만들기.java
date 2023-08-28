import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String palindrome = br.readLine();
        int cnt = findPalindrome(palindrome);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static int findPalindrome(String palindrome) {
        List<String> list = new ArrayList<>(Arrays.asList(palindrome.split("")));
        StringBuilder sb = new StringBuilder(palindrome);

        String a = sb.toString();
        String b = sb.reverse().toString();
        sb.reverse();

        if(a.equals(b)) {
            return sb.length();
        } else {
            for(int i=0; i<list.size()-1; i++) {
                int idx = palindrome.length()-1;
                if(list.get(i).equals(list.get(idx))) {
                    sb.setLength(0);
                    for(int j=i; j<list.size(); j++) {
                        sb.append(list.get(j));
                    }
                    if(sb.toString().equals(sb.reverse().toString())) {
                        return i * 2 + sb.length();
                    }
                }
            }
        }
        return palindrome.length() * 2 - 1;
    }

}
