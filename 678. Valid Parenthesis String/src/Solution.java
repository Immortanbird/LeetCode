/*
* Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

* The following rules define a valid string:
* Any left parenthesis '(' must have a corresponding right parenthesis ')'.
* Any right parenthesis ')' must have a corresponding left parenthesis '('.
* Left parenthesis '(' must go before the corresponding right parenthesis ')'.
* '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
* */
/*建议看题解，还是题解比较捞*/
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkValidString("()"));
    }

    public boolean checkValidString(String s) {
        if (s.charAt(0) == ')')
            return false;

        Stack<Integer> left = new Stack<>();
        Stack<Integer> general = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                left.push(i);
            else if(s.charAt(i) == '*')
                general.push(i);
            else {
                if (!left.empty())
                    left.pop();
                else if (!general.empty())
                    general.pop();
                else
                    return false;
            }
        }

        while (!left.empty() && !general.empty()) {
            if (left.peek() < general.peek()) {
                left.pop();
                general.pop();
            }
            else
                return false;
        }

        return left.empty();
    }
}
