/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int min = 0;
        int max = 0;
        int profit = 0;

        for (int i = 1; i < prices.size(); i++)
        {
            if (prices[i] > prices[max])
            {
                max = i;
                profit = prices[max] - prices[min] > profit ? prices[max] - prices[min] : profit;
            }
            else if (prices[i] < prices[min])
                min = max = i;
        }

        return profit;
    }
};