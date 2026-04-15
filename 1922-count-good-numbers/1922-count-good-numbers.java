class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;

        long evenPower = (n + 1) / 2;
        long oddPower = n / 2;

        long goodNum = (powerModRecursive(5, evenPower, mod) * powerModRecursive(4, oddPower, mod)) % mod;
return (int) goodNum;
    }

    public long powerModRecursive(long base, long power, long mod) {
        if (power == 0) {
            return 1;
        }

        long halfPower = powerModRecursive(base, power / 2, mod);
        long halfSquared = (halfPower * halfPower) % mod;

        if (power % 2 == 0) {
            return halfSquared;
        } else {
            return (base * halfSquared) % mod;
        }
    }
}