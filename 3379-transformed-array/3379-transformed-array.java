class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0, i = 0, n = nums.length;
        while (count < n) {
            if (nums[i] > 0) {
                i = (i + nums[i]) % n;
                result[count] = nums[i];
            } else if (nums[i] < 0) {
                i = ((i + nums[i]) % n + n) % n;
                result[count] = nums[i];
            } else {
                result[count] = nums[i];
            }
            count++;
            i = count;
        }
        return result;
    }
}