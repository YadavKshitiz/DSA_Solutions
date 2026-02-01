class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int check = runningSum % k;
            if (check < 0) {check += k;}
            if (map.containsKey(check)) {
                count += map.get(check);
            }
            map.put(check, map.getOrDefault(check, 0) + 1);
        }

        return count;
    }
}