/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
 */
#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        if (nums.empty())
            return {-1, -1};

        if (nums.size() == 1)
            if (nums.back() == target)
                return {0, 0};
            else
                return {-1, -1};

        vector<int> result;
        int head = 0, tail = nums.size();

        while (tail > head)
        {
            int i = (head + tail) / 2;
            if (nums[i] >= target)
                tail = i;
            else
                head = i+1;
        }

        if (nums[head] != target)
            return {-1, -1};

        result.push_back(head);

        head = 0;
        tail = nums.size();
        while (tail > head)
        {
            int i = (head + tail) / 2;
            if (nums[i] > target)
                tail = i;
            else
                head = i;
        }
        result.push_back(tail);

        return result;
    }
};