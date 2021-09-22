/*
* Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

* The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

* The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

* Return an array of the k parts.
* */

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;
        int len = 0;

        while (p != null) {
            p = p.next;
            len ++;
        }

        int size = len / k;
        int rest = len % k;

        ListNode[] res = new ListNode[k];
        p = head;

        for (int index = 0; index<k && p != null; index++) {
            ListNode temp = p;
            for (int i=1; i < (index < rest ? size + 1 : size); i++)
                p = p.next;

            ListNode q = p;
            p = p.next;
            q.next = null;
            res[index] = temp;
        }

        return res;
    }
}