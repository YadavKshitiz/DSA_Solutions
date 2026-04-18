class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solve(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public void solve(int n, int k, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index > n) {
            return;
        }
        current.add(index);
        solve(n, k, index + 1, current, result);
        current.remove(current.size() - 1);
        solve(n, k, index + 1, current, result);

    }
}