class Solution {
    public int solution(int[] common) {
        int length = common.length;
        
        int diff = common[1] - common[0];
        boolean isArithmetic = true;
        for (int i = 1; i < length - 1; i++) {
            if (common[i + 1] - common[i] != diff) {
                isArithmetic = false;
                break;
            }
        }
        
        if (isArithmetic) {
            return common[length - 1] + diff;
        } else {
            int ratio = common[1] / common[0];
            return common[length - 1] * ratio;
        }
    }
}

