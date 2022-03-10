/*
* Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        list.add(root.val);
        stack.push(root);

        while (!stack.isEmpty()) {
            if (!stack.peek().children.isEmpty()) {
                Node temp = stack.peek().children.get(0);
                list.add(temp.val);
                stack.peek().children.remove(0);
                stack.push(temp);
            }
            else
                stack.pop();
        }

        return list;
    }
}