/* 
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class Solution
{
public:
    int climbStairs(int n)
    {
        int dp1 = 1;
        int dp2 = 1;
        int temp;

        for (int i = 2; i <= n; i++)
        {
            temp = dp2;
            dp2 += dp1;
            dp1 = temp;
        }
        
        return dp2;
    }
};