/*
* Given two integers a and b, return the sum of the two integers without using the operators + and -.
* */
/*
* 参考：return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
* */

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}