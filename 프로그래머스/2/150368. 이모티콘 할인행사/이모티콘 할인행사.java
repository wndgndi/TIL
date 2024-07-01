class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int maxPlus = 0;
    static int maxCost = 0;
    static int[] currentDiscounts; // 현재 할인율을 저장하는 배열
    
    public int[] solution(int[][] users, int[] emoticons) {
        currentDiscounts = new int[emoticons.length];
        calculate(0, users, emoticons);
        return new int[]{maxPlus, maxCost};
    }
    
    private void calculate(int idx, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            int cost = 0;
            int plus = 0;

            for (int[] user : users) {
                int userDiscountRate = user[0];
                int userMaxCost = user[1];
                int sum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (currentDiscounts[i] >= userDiscountRate) {
                        sum += emoticons[i] * (100 - currentDiscounts[i]) / 100;
                    }
                }

                if (sum >= userMaxCost) {
                    plus++;
                } else {
                    cost += sum;
                }
            }
            
            if (plus > maxPlus) {
                maxPlus = plus;
                maxCost = cost;
            } else if (plus == maxPlus) {
                maxCost = Math.max(maxCost, cost);
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            currentDiscounts[idx] = discounts[i];
            calculate(idx + 1, users, emoticons);
        }
    }
}
