public class Solution {
    public int fib(int n) {
        int f1 = 0;
        int f2 = 1;

        for(int i=0; i<n; i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
            f1 %= 1000000007;
            f2 %= 1000000007;
        }

        return f1;
    }
}
