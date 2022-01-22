/*
* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
* */

class Solution {
    static int res = 0;

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(s.kthSmallest(root, 2));
    }

    private int search(TreeNode root, int k) {
        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = search(root.left, k);

            if (left == k) {
                res = root.left.val;
                return -1;
            }
        }

        if (left == -1)
            return -1;

        if (left + 1 == k) {
            res = root.val;
            return -1;
        }

        if (root.right != null) {
            right = search(root.right, k);
            if (left + right + 1 == k) {
                res = root.right.val;
                return -1;
            }
        }

        return right + left + 1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int head = search(root, k);
        if (head == k)
            return head;
        return res;
    }
}
