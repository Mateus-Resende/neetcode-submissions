class Solution {
    public int climbStairs(int n) {
        int i0 = 1;
        int i1 = 1;

        for (int i = 2; i <= n; i++) {
            int next = i0 + i1;
            i0 = i1;
            i1 = next;
        }
        
        return i1;
    }
}
