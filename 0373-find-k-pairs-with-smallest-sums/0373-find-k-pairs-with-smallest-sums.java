class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<nums1.length;i++){
            heap.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        List<List<Integer>> result=new ArrayList<>();

        while(!heap.isEmpty()&&result.size()!=k){
            int[] current =heap.poll();
            List<Integer> list=new ArrayList<>();
            list.add(nums1[current[1]]);
            list.add(nums2[current[2]]);
            result.add(list);

            if(current[2]+1<nums2.length){
               heap.offer(new int[]{
                nums1[current[1]]+nums2[current[2]+1],
                current[1],
                current[2]+1
               }
               );
            }
        }
        return result;
    }
}