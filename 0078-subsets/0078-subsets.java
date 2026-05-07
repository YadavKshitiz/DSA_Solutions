class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subMaker(0, nums, new ArrayList<>(), result);
        return result;
    }

    void subMaker(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subMaker(index + 1, nums, current, result);
        current.remove(current.size() - 1);
        subMaker(index + 1, nums, current, result);

    }
}