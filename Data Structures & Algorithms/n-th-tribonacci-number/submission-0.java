class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        
        int i0 = 0;
        int i1 = 1;
        int i2 = 1;

        for (int i = 3; i <= n; i++) {
            int next = i2 + i1 + i0;
            i0 = i1;
            i1 = i2;
            i2 = next;
        }
        return i2;
    }
}