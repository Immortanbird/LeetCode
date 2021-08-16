/* 
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

借鉴自7.Reverse Integer
 */
class Solution
{
public:
    bool isPalindrome(int x)
    {
        if (x < 0)
            return false;

        long n = 0;
        int temp = x;
        while (temp)
        {
            n = n * 10 + temp % 10;
            temp /= 10;
        }
        return (int)n == x ? true : false;
    }
};