/* 
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        digits.back()++;
        if (digits.back() < 10)
            return digits;

        int i = digits.size() - 2;
        bool carry = true;
        digits.back() -= 10;
        while (i >= 0)
        {
            digits[i]++;

            if (digits[i] < 10)
            {
                carry = false;
                break;
            }
            else
                digits[i] -= 10;

            i--;
        }

        if (carry)
            digits.insert(digits.begin(), 1);

        return digits;
    }
};