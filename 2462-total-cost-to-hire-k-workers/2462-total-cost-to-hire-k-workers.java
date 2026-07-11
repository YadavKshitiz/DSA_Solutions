class Solution {

    class Worker {
        int index;
        int cost;

        Worker(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int left = 0, right = costs.length - 1;
        long cost = 0;
        Worker worker;
        PriorityQueue<Worker> leftHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.cost == b.cost) {
                        return a.index - b.index;
                    }
                    return a.cost - b.cost;
                });
        PriorityQueue<Worker> rightHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.cost == b.cost) {
                        return a.index - b.index;
                    }
                    return a.cost - b.cost;
                });

        for (int i = 0; i < k; i++) {
            while (leftHeap.size() < candidates && left <= right) {
                leftHeap.offer(new Worker(left, costs[left]));
                left++;
            }

            while (rightHeap.size() < candidates && left <= right) {
                rightHeap.offer(new Worker(right, costs[right]));
                right--;
            }

            if (rightHeap.isEmpty()) {
                worker = leftHeap.poll();
                cost += (long) worker.cost;
            } else if(leftHeap.isEmpty()){
                worker = rightHeap.poll();
                cost += (long) worker.cost;
            }else{
                 if(leftHeap.peek().cost<=rightHeap.peek().cost){
                    worker = leftHeap.poll();
                cost +=(long) worker.cost;
                 }else{
                    worker = rightHeap.poll();
                cost += (long) worker.cost;
                 }
            }

        }

        return cost;

    }
}