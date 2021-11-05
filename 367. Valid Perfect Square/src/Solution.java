/*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.
* Follow up: Do not use any built-in library function such as sqrt.
* */

class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;

        while (left < right) {
            long mid = (left + right) / 2;

            if (mid * mid == num)
                return true;
            else if (mid * mid > num)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left * left == num;
    }
}