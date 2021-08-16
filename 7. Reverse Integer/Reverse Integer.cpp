/* 
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

还是大佬比较屌，直接将输入的末尾弹出然后压入新的长整型，最后将long强制转为int，如果转换前后相等就说明没有溢出
 */
#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
    int reverse(int x)
    {
        long n = 0;
        while (x)
        {
            n = n * 10 + x % 10;
            x /= 10;
        }

        return (int)n == n ? n : 0;
    }
};

int main()
{
    Solution S;
    cout << S.reverse(1534236469);

    return 0;
}