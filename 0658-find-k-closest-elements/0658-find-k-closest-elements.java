class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> {
                    int diff1 = Math.abs(a - x);
                    int diff2 = Math.abs(b - x);

                    if (diff1 != diff2) {
                        return Integer.compare(diff1, diff2);
                    }

                    return Integer.compare(a, b);
                });

                for(int i=0;i<arr.length;i++){
                   heap.offer(arr[i]);
                }
                List<Integer> list=new ArrayList<>();
                for(int i=0;i<k;i++){
                    list.add(heap.poll());
                }
                Collections.sort(list);
                return list;

    }
}