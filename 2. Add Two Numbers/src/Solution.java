/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int forward = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(l1.val + l2.val + forward);

            if (temp.val > 9) {
                temp.val -= 10;
                forward = 1;
            }
            else
                forward = 0;

            if (head == null) {
                head = temp;
                tail = temp;
            }
            else {
                tail.next = temp;
                tail = tail.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode temp = new ListNode(forward + l1.val);

            if (temp.val > 9) {
                temp.val -= 10;
                forward = 1;
            }
            else
                forward = 0;

            tail.next = temp;
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode temp = new ListNode(forward + l2.val);

            if (temp.val > 9) {
                temp.val -= 10;
                forward = 1;
            }
            else
                forward = 0;

            tail.next = temp;
            tail = tail.next;
            l2 = l2.next;
        }

        if (forward > 0)
            tail.next = new ListNode(1);

        return head;
    }
}