/* 
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

正解：注意题目给的是不减数组，用双指针即可。将跑得快的指针读到的不同的值放在跑得慢的指针+1的位置。
 */
#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {
        for (int i = 0; i < nums.size(); i++)
        {
            for (int j = i + 1; j < nums.size(); j++)
            {
                if (nums[j] == nums[i])
                {
                    nums.erase(nums.begin() + j);
                    j--;
                }
            }
        }

        return nums.size();
    }
};

int main()
{
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);
    nums.push_back(3);

    Solution s;
    cout << s.removeDuplicates(nums) << endl;
    for (int i = 0; i < nums.size(); i++)
        cout << nums[i] << endl;

    return 0;
}