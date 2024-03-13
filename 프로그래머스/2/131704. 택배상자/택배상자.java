import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // `sub` 스택은 보조로 사용됩니다.
        Stack<Integer> sub = new Stack<>();
        // `yjIndex`는 현재 처리해야 할 상자의 순서를 가리킵니다.
        int yjIndex = 1;

        for (int i = 0; i < order.length; i++) {
            // 현재 주문이 창고의 순서와 일치할 때까지 상자를 `sub`로 보냅니다.
            while (yjIndex <= order.length && (sub.isEmpty() || sub.peek() != order[i])) {
                sub.push(yjIndex);
                yjIndex++;
            }

            // `sub` 스택의 상자가 택배 기사가 필요한 상자와 일치하는 경우,
            // 해당 상자를 처리하고 `answer`를 증가시킵니다.
            if (!sub.isEmpty() && sub.peek() == order[i]) {
                sub.pop();
                answer++;
            } else {
                // 현재 상자를 처리할 수 없는 경우, 더 이상의 처리가 불가능하므로 반복을 종료합니다.
                break;
            }
        }

        return answer;
    }
}