class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combi(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    void combi(int[] array, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == array.length || array[index] > target)
            return;

        current.add(array[index]);
        combi(array, index + 1, target - array[index], current, result);
        current.remove(current.size() - 1);
        int nextIndex = index + 1;
        while (nextIndex < array.length && array[nextIndex] == array[index]) {
            nextIndex++;
        }
        combi(array, nextIndex, target, current, result);

    }
}