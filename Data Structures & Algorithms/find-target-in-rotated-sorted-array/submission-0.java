class Solution {

    private int getMid(int left, int right) {
        return left + (right - left) / 2;
    }

    private int findRotatedIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = getMid(left, right);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int search(int[] nums, int target) {
        int left, right;
        int rotatedIndex = findRotatedIndex(nums);
        
        if (target >= nums[rotatedIndex] && target <= nums[nums.length - 1]) {
            left = rotatedIndex;
            right = nums.length - 1;
        } else {
            right = rotatedIndex - 1;
            left = 0;
        }
        while (left <= right) {
            int mid = getMid(left, right);

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
