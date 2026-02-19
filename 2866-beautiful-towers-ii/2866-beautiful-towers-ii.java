import java.util.*;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];

        Deque<Integer> stack = new ArrayDeque<>();

        // Compute left contribution
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                    maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = (long) maxHeights.get(i) * (i + 1);
            } else {
                int prev = stack.peek();
                left[i] = left[prev] +
                        (long) maxHeights.get(i) * (i - prev);
            }
            stack.push(i);
        }

        stack.clear();

        // Compute right contribution
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                    maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = (long) maxHeights.get(i) * (n - i);
            } else {
                int next = stack.peek();
                right[i] = right[next] +
                        (long) maxHeights.get(i) * (next - i);
            }
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            result = Math.max(result,
                    left[i] + right[i] - maxHeights.get(i));
        }

        return result;
    }
}