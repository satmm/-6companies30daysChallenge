class Solution {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(long a, long b) {
        long temp = (a / gcd((int) a, (int) b)) * b;
        return temp > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) temp;
    }

    public int minimizeSet(int divisor1, int divisor2, int uc1, int uc2) {
        int l = 1, r = Integer.MAX_VALUE;
        int LCM = lcm(divisor1, divisor2);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int a = mid / divisor1, b = mid / divisor2;

            if (uc1 <= mid - a && uc2 <= mid - b && uc1 + uc2 <= (mid - (mid / LCM))) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
