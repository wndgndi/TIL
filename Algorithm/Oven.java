import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        String str = br.readLine();

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int t = Integer.parseInt(str);
        int cnt = 0;

        if(t>60) {
            while(t>=60){
                t=t-60;
                cnt++;
            }
            a=a+cnt;
        }

        if(b+t>=60) {
            b=b+t-60;
            a=a+1;
        } else {
            b = b+t;
        }

        if(a>=24){
            a=a-24;
        }

        bw.write(a+ " " + b + "\n");
        bw.flush();
        bw.close();
    }
}
