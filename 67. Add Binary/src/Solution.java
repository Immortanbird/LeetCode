/*Given two binary strings a and b, return their sum as a binary string.*/

import java.util.Stack;

class Solution {
    public String addBinary(String a, String b) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<a.length(); i++)
            stk1.push(Integer.valueOf(a.substring(i, i+1)));
        for(int i=0; i<b.length(); i++)
            stk2.push(Integer.valueOf(b.substring(i, i+1)));

        while(!stk1.empty() && !stk2.empty()) {
            int temp = stk1.pop() + stk2.pop();
            if(temp > 1) {
                temp -= 2;
                stk.push(temp);
                if(stk1.empty())
                    stk1.push(1);
                else
                    stk1.push(stk1.pop() + 1);
            }
        }

        while(!stk1.empty()) {
            int temp = stk1.pop();
            if(temp > 1) {
                temp -= 2;
                stk.push(temp);
                if(stk1.empty())
                    stk1.push(1);
                else
                    stk1.push(stk1.pop() + 1);
            }
        }

        while(!stk2.empty()) {
            int temp = stk2.pop();
            if(temp > 1) {
                temp -= 2;
                stk.push(temp);
                if(stk2.empty())
                    stk2.push(1);
                else
                    stk2.push(stk1.pop() + 1);
            }
        }

        String s = "";

        while(!stk.empty())
            s = s + stk.pop();

        return s;
    }
}