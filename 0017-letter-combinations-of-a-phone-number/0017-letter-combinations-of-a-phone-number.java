import java.util.*;

class Solution {

    private static final String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base condition: one character chosen for each digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map[digit - '0'];

        // Core idea: loop over all choices for this digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));     // choose
            backtrack(digits, index + 1, current, result); // explore
            current.deleteCharAt(current.length() - 1);    // undo (backtrack)
        }
    }
}