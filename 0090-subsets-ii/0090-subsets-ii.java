class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, result, new ArrayList<>());
        return result;
    }

    void subset(int []nums, int index,List<List<Integer>> result,List<Integer> current){
    if(index==nums.length){
        result.add(new ArrayList<>(current));
        return;
    }
    current.add(nums[index]);
    subset(nums,index+1,result,current);
    current.remove(current.size()-1);
    while(index + 1 < nums.length && nums[index] == nums[index + 1]){
        index++;
      }
    subset(nums,index+1,result,current);

    }

}