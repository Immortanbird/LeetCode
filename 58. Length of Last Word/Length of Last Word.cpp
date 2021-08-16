/* 
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.
 */
#include <iostream>

using namespace std;

class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        int len = s.length();
        int i = len - 1;
        while (i >= 0 && s[i] == ' ')
            i--;

        int j = i;
        while (i >= 0 && s[i] != ' ')
            i--;

        return j - i;
    }
};

int main()
{
    Solution s;
    cout << s.lengthOfLastWord("abc  ") << endl;
    return 0;
}