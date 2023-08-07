import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int tmp = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > tmp) {
                tmp = nums[i];
                stack1.push(nums[i]);
                nums[i] = 0;
            }
        }
        tmp = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > tmp) {
                tmp = nums[i];
                stack2.push(nums[i]);
                nums[i] = 0;
            }
        }
        tmp = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > tmp) {
                tmp = nums[i];
                stack3.push(nums[i]);
                nums[i] = 0;
            }
        }
        tmp = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > tmp) {
                tmp = nums[i];
                stack4.push(nums[i]);
                nums[i] = 0;
            }
        }
        if(stack1.size() + stack2.size() + stack3.size() + stack4.size() != nums.length) {
            bw.write("NO");
        } else {
            bw.write("YES");
        }

        bw.flush();
        bw.close();
    }

}