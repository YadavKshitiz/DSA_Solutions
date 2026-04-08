class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        
        int setBit = res & (-res);
        int []arr=new int[2];
        for (int num : nums) {
            if ((num & setBit) != 0) {
                arr[0] ^= num;
            } else {
                arr[1] ^= num;
            }
        }
        return arr;
    }
}