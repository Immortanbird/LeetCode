/* 
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
#include <vector>

using namespace std;

class Solution1
{
public:
    int searchInsert(vector<int> &nums, int target)
    {
        if (target < nums[0])
            return 0;

        int size = nums.size();
        for (int i = 0; i < size; i++)
        {
            if (target <= nums[i])
                return i;
        }

        return size;
    }
};