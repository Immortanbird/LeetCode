/* 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

线性规划依旧是个菜逼，前n个数的最大子段和f(n)=max(f(n-1)+nums[n], nums[n])，但是如果之后的子段不能使现有子段和变大或出现更大的子段和，就舍弃，所以需要pre做缓冲，ans做记录
 */
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int pre = 0, maxAns = nums[0];
        for (const auto &x : nums)
        {
            pre = max(pre + x, x);
            maxAns = max(maxAns, pre);
        }
        return maxAns;
    }
};

int main()
{
    int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    vector<int> vec;
    for (int i = 0; i < 9; i++)
        vec.push_back(arr[i]);

    Solution s;
    cout << s.maxSubArray(vec) << endl;

    return 0;
}