class Solution {

    class Pair {
        int value;
        int index;
        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public Pair solve(String s, int i) {
        int result = 0;
        int num = 0;
        int sign = 1;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '+' || ch == '-') {
                result += sign * num;
                num = 0;
                sign = (ch == '+') ? 1 : -1;
            }
            else if (ch == '(') {
                Pair p = solve(s, i + 1);
                num = p.value;
                i = p.index; 
            }
            else if (ch == ')') {
                result += sign * num;
                return new Pair(result, i);
            }
            i++;
        }
        result += sign * num;
        return new Pair(result, i);
    }

    public int calculate(String s) {
        return solve(s, 0).value;
    }
}