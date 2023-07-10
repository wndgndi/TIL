import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        Pattern pattern = Pattern.compile("(?i)D2");
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()) bw.write("D2");
        else bw.write("unrated");

        bw.flush();
        bw.close();

    }

}