import java.util.*;

class Solution {

    class Friend {
        int arrival;
        int leave;
        int index;
        Friend(int arrival, int leave, int index) {
            this.arrival = arrival;
            this.leave = leave;
            this.index = index;
        }
    }

    class OccupiedChair {
        int leave;
        int chair;
        OccupiedChair(int leave, int chair) {
            this.leave = leave;
            this.chair = chair;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Friend> arrivalHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.arrival, b.arrival));

        for (int i = 0; i < times.length; i++) {
            arrivalHeap.offer(new Friend(times[i][0], times[i][1], i));
        }

        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        PriorityQueue<OccupiedChair> occupied = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.leave, b.leave));
        int nextChair = 0;

        while (!arrivalHeap.isEmpty()) {
            Friend curr = arrivalHeap.poll();
            while (!occupied.isEmpty() &&
                    occupied.peek().leave <= curr.arrival) {
                freeChairs.offer(occupied.poll().chair);
            }

            int assignedChair;

            if (!freeChairs.isEmpty()) {
                assignedChair = freeChairs.poll();
            } else {
                assignedChair = nextChair;
                nextChair++;
            }

            if (curr.index == targetFriend) {
                return assignedChair;
            }

            occupied.offer(new OccupiedChair(curr.leave, assignedChair));
        }

        return -1;
    }
}