class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countMax(nums, right) - countMax(nums, left - 1);
    }

    private int countMax(int[] nums, int bound) {
        int ans = 0;
        int len = 0;
        for (int num : nums) {
            if (num <= bound) {
                len++;
            } else {
                len = 0;
            }
            ans += len;
        }
        return ans;
    }
}