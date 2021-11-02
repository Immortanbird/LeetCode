/*
* Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
*
* It is guaranteed that the node to be deleted is not a tail node in the list.
* */
/*
* 傻逼脑筋急转弯，引用评论里的一句话“让一个人消失的方法是先变成那个人然后再杀了他” */

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
