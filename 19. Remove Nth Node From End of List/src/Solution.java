/*
* Given the head of a linked list, remove the nth node from the end of the list and return its head.
* */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode begin = head;
        ListNode end = head;

        for (int i=0; i<n; i++)
            end = end.next;

        while (end.next != null) {
            begin = begin.next;
            end = end.next;
        }

        begin.next = begin.next.next;

        return head.next;
    }
}