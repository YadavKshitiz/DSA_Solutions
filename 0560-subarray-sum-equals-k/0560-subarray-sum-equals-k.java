import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, runningSum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int needed = runningSum - k;
            if (map.containsKey(needed)) {
                count += map.get(needed);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}
