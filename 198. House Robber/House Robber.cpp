/* 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/
/* dp[i] = max(dp[i-2] + nums[i], dp[i-1]) */
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        int size = nums.size();

        if (size == 1)
            return nums[0];

        if (size == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];

        int *dp = new int[size];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < size; i++)
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);

        return dp[size - 1];
    }
};

int main()
{
    vector<int> vec = {3, 1, 3, 100};
    Solution s;
    cout << s.rob(vec) << endl;

    return 0;
}