class FreqStack {
    int tStack = 0;
    Map<Integer, Stack<Integer>> sMap=new HashMap<>();
    Map<Integer, Integer> fMap = new HashMap<>();

    public FreqStack() {

    }

    public void push(int val) {
        int freq = fMap.getOrDefault(val, 0) + 1;
        fMap.put(val, freq);

        if (sMap.containsKey(freq)) {
            sMap.get(freq).push(val);
        } else {
            sMap.put(freq, new Stack<>());
            sMap.get(freq).push(val);
            tStack++;
        }
    }

    public int pop() {
        int val = sMap.get(tStack).pop();
        int freq = fMap.get(val);
        if (freq == 0) {
            fMap.remove(val);
        } else {
            fMap.put(val, freq - 1);
        }
        if (sMap.get(tStack).isEmpty()) {
            sMap.remove(tStack--);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */