class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;

        while(temp != null) {
            temp = temp.next;
            len++;
        }
        while(len-- > k && head != null)
            head = head.next;

        return head;
    }
}