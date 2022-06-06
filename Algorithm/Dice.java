import java.io.*;

public class Dice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        int sum = 0;

        if(a==b && b==c) {
            sum = 10000 + a*1000;
        }
        else if(a==b && b!=c ) {
            sum = 1000 + a*100;
        }
        else if(a==c && a!=b){
            sum = 1000 + c*100;
        }
        else if(b==c && c!=a) {
            sum = 1000 + b*100;
        }
        else if(a!=b && b!=c && a!=c) {
            sum = Math.max(c,Math.max(a,b))*100;
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}

