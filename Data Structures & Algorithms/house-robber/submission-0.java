class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        List<Integer> dp = new ArrayList<>(nums.length + 1);

        dp.add(nums[0]);
        dp.add(Math.max(dp.get(0), nums[1]));

        for (int i = 2; i < nums.length; i++) {
            dp.add(
                Math.max(
                    dp.get(i - 1),
                    nums[i] + dp.get(i - 2)
                )
            );
        }
        
        
        return dp.get(nums.length - 1);
    }
}
