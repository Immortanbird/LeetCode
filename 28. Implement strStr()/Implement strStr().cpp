/* 
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

详见KMP算法
 */
#include <iostream>

using namespace std;

class Solution
{
public:
    int strStr(string haystack, string needle)
    {
        if (needle == "")
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i < haystack.length(); i++)
        {
            if (haystack[i] == needle[0])
            {
                bool temp = true;
                for (int j = 1; j < needle.length(); j++)
                {
                    if (needle[j] != haystack[i + j])
                    {
                        temp = false;
                        break;
                    }
                }
                if (temp)
                    return i;
            }
        }

        return -1;
    }
};