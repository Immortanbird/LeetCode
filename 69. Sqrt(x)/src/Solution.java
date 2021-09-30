/*
* Given a non-negative integer x, compute and return the square root of x.
* Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
* Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
* */

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if ((long)mid*mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        return res;
    }
}