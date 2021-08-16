/*
 * @Author: your name
 * @Date: 2021-07-02 14:24:54
 * @LastEditTime: 2021-07-16 14:51:04
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \Codes\C&C++\LeetCode\1.Two sum\Two sum.cpp
 */
/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < nums.size(); i++)
        {
            for (int j = i+1; j < nums.size(); j++)
            {
                if (nums[i] + nums[j] == target)
                    return {i, j};
            }
        }
        return {0,0};
    };
};