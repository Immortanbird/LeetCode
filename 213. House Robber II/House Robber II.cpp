/* 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/
/* 同198题，只是去头或去尾两种情况做两次dp */
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

        int *dp = new int[size - 1];

        dp[0] = nums[1];
        dp[1] = nums[2] > nums[1] ? nums[2] : nums[1];
        for (int i = 2; i < size - 1; i++)
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i + 1]);

        int dp1 = dp[size - 2];

        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < size - 1; i++)
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp1 > dp[size - 2] ? dp1 : dp[size - 2];
    }
};

int main()
{
    vector<int> vec = {1, 3, 1, 3, 100};
    Solution s;
    cout << s.rob(vec) << endl;

    return 0;
}