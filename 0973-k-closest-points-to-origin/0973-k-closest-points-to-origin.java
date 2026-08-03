class Solution {
    class Point {
        int index;
        double value;

        Point(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.value, a.value));
        for (int i = 0; i < points.length; i++) {
            Point p=new Point(i,0);
            p.value = Math.sqrt((Math.pow(points[i][0], 2)) + (Math.pow(points[i][1], 2)));
            heap.offer(p);
            if(heap.size()>k){
                heap.poll();
            }
        }
        
        int[][] array=new int[k][2];
        int j=0;
        while(!heap.isEmpty()){
            Point p=heap.poll();
            array[j][0]=points[p.index][0];
            array[j++][1]=points[p.index][1];
        }
        return array;
    }
}
