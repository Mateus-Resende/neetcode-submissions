class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return 0;

        int prev2 = 0;
        int prev1 = 0;
        
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(
                prev2 + cost[i - 2],
                prev1 + cost[i - 1]
            );
            prev2 = prev1;
            prev1 = next;
        }
        return prev1;
    }
}
