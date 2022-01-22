/*
* You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
* Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
* */
class Solution {
    public void DFS(Node head) {
        Node next = head.next;
        Node child = head.child;

        while (head != null) {
            if (head.child != null) {
                next = head.next;
                child = head.child;
                head.child = null;
                child.prev = head;
                DFS(child);
            }
            head = head.next;
        }

        child.next = next;
    }

    public Node flatten(Node head) {
        Node iterator = head;

        while (iterator != null) {
            if (iterator.child != null) {
                iterator = iterator.next;
                DFS(iterator.prev);
                continue;
            }
            iterator = iterator.next;
        }

        return head;
    }
}