class Solution {
    public int leastInterval(char[] tasks, int n) {
        int output = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(java.util.Comparator.reverseOrder());
        for (Integer value : map.values()) {
            heap.offer(value);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int temp;
        while (!queue.isEmpty() || !heap.isEmpty()) {
            for (int i = 0; i < n + 1; i++) {
                if (queue.isEmpty() && heap.isEmpty())
                    break;
                temp = 0;
                if (!heap.isEmpty()) {
                    temp = heap.poll() - 1;
                }
                if (temp != 0) {
                    queue.offer(temp);
                }
                output++;
            }
            while (!queue.isEmpty()) {
                heap.offer(queue.poll());
            }
        }

        return output;
    }
}