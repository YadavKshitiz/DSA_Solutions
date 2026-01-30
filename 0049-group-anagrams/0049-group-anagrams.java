import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(str);
                // this is a little redundant. use this
                // map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            }
        }
        return new ArrayList<>(map.values());
    }
}