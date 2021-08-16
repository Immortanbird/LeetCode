/* 
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

仿照上题继续使用双指针，更优解是双指针从两端开始，到相遇时结束
 */
#include <vector>

using namespace std;

class Solution //偷懒用模板
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int i = 0;
        while (i < nums.size())
        {
            if (nums[i] == val)
                nums.erase(nums.begin() + i);
            else
                i++;
        }

        return nums.size();
    }
};

class Solution //双指针
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int j = 0;

        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] != val)
                nums[j++] = nums[i];
        }

        return j;
    }
};