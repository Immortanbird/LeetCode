/* 
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */
#include<iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        string prefix = strs.back();
        strs.pop_back();
        int len = strs.size();

        while (len--)
        {
            int longest = min(strs.back().length(), prefix.length());
            int i = 0;
            while (i < longest && strs.back()[i] == prefix[i])
                i++;

            prefix.erase(prefix.begin() + i, prefix.end());
            strs.pop_back();
        }

        return prefix;
    }
};

int main()
{
    Solution s;
    vector<string> vec;
    vec.push_back("reflower");
    vec.push_back("flow");
    vec.push_back("flight");
    cout << s.longestCommonPrefix(vec) <<endl;
}