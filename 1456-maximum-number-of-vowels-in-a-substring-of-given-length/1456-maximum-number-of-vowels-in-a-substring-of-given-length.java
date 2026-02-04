class Solution {

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public int maxVowels(String s, int k) {
        if (k < s.length()) {
            int windowVowel = 0;
            for (int i = 0; i < k; i++) {
                if (isVowel(s.charAt(i))) {
                    windowVowel++;
                }
            }

            int maxVowel = windowVowel;
            if (k != s.length()) {
                for (int i = k; i < s.length(); i++) {
                    if (isVowel(s.charAt(i - k))) {
                        windowVowel--;
                    }
                    if (isVowel(s.charAt(i))) {
                        windowVowel++;
                    }
                    maxVowel = Math.max(maxVowel, windowVowel);
                }
            }
            return maxVowel;
        }
        return 0;
    }
}