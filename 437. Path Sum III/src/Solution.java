/*
* Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

* The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
* */

class Solution {
    public int DFS(TreeNode root, int targetSum) {
        int res = 0;

        targetSum -= root.val;

        if (targetSum == 0)
            res ++;

        if (root.left != null)
            res += DFS(root.left, targetSum);

        if (root.right != null)
            res += DFS(root.right, targetSum);

        return res;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int res = DFS(root, targetSum);

        if (root.left != null)
            res += pathSum(root.left, targetSum);

        if (root.right != null)
            res += pathSum(root.right, targetSum);

        return res;
    }
}