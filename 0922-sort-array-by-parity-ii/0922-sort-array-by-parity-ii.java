class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if(nums.length==0) return nums;
        int i=0,j=1;
        while(i<nums.length&&j<nums.length){
            if(nums[i]%2==0) i+=2;
            else if(nums[j]%2==1) j+=2;
            else{
                nums[i]+=nums[j];
                nums[j]=nums[i]-nums[j];
                nums[i]-=nums[j];
            }
        }
        return nums;
    }
}