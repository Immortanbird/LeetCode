/*
* The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
* For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
* Given an integer num, return its complement.
* */
/*懒蛋做法，正解是不断右移找到最高位，然后按位取反*/

public class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        s = s.replace('1', '2');
        s = s.replace('0', '1');
        s = s.replace('2', '0');

        return Integer.valueOf(s, 2);
    }
}
