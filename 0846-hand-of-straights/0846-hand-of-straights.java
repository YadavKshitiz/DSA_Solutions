class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            if (map.get(card) == 0)
                continue;
            else {
                for (int i = 0; i < groupSize; i++) {
                    int curr = card + i;

                    if (map.getOrDefault(curr, 0) == 0)
                        return false;

                    map.put(curr, map.get(curr) - 1);
                }
            }
        }
        return true;

    }
}