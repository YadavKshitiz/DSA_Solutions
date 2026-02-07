class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0){return 0;}
        int n = nums.length, prefixPrd = 1, count = 0;
        for(int i = 0, j = 0;j<n;j++){
            prefixPrd*=nums[j];
            while(i<=j&&prefixPrd>=k){
                prefixPrd/=nums[i++];
            }
            count+=j-i+1;
        }
        return count;
    }
}