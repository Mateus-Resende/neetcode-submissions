
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNums = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (visitedNums.containsKey(target - nums[i])) {
                return new int[]{visitedNums.get(target - nums[i]), i};
            } else {
                visitedNums.put(nums[i], i);
            }
        }

        return new int[2];
    }
}
