class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }
        List<List<Integer>> result = new ArrayList<>();

        while (!heap.isEmpty() && k>0) {
            int[] current = heap.poll();
            List<Integer> list = new ArrayList<>();
            int i = current[1];
            int j = current[2];
            list.add(nums1[i]);
            list.add(nums2[j]);
            result.add(list);

            if (j + 1 < nums2.length) {
                heap.offer(new int[] {
                        nums1[i] + nums2[j + 1],
                        i,
                        j + 1
                });
            }
            k--;
        }
        return result;
    }
}