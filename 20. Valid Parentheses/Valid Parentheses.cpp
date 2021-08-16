/* 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    1.Open brackets must be closed by the same type of brackets.
    2.Open brackets must be closed in the correct order.
 */
#include <iostream>
#include <stack>

using namespace std;

class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> stk;
        int i = 0;
        while (i < s.length())
        {
            if (stk.empty())
                stk.push(s[i]);
            else
            {
                switch (stk.top())
                {
                case '(':
                    if (s[i] == ')')
                        stk.pop();
                    else
                        stk.push(s[i]);
                    break;
                case '[':
                    if (s[i] == ']')
                        stk.pop();
                    else
                        stk.push(s[i]);
                    break;
                case '{':
                    if (s[i] == '}')
                        stk.pop();
                    else
                        stk.push(s[i]);
                    break;
                }
            }
            i++;
        }

        return stk.empty() ? true : false;
    }
};

int main()
{
    Solution s;
    cout << s.isValid("(]") << endl;

    return 0;
}