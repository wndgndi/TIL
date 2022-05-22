import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        char[] ch = str.toCharArray();
        int[] arr = new int[26];

       for(int i=0; i<26; i++) {
           arr[i] = -1;
       }

        for(int i=0; i<ch.length; i++) {
            arr[ch[i]-97] = str.indexOf(ch[i]);
        }

        for(int i=0; i<26; i++) {
            sb.append(arr[i]+" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
