package org.example;

public class LC206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        ListNode answer = reverseList(head);
        System.out.println(answer);
    }

    public static ListNode reverseList(ListNode head) { // O(n), O(1)
        if (head == null) return null;
        ListNode i = head;
        ListNode current = head;
        ListNode prev = null;
        while (i.next != null) {
            i = i.next;
            current.next = prev;
            prev = new ListNode(current.val, current.next);
            current = i;
        }
        current.next = prev;
        return current;
    }

    public static ListNode recReverseList(ListNode head) {
        if (head == null) return null;
        ListNode[] answer = new ListNode[2];
        answer = rec(head, answer);
        answer[1].next = null;
        return answer[0];
    }

    private static ListNode[] rec(ListNode current, ListNode[] recc) { // O(n), O(1) - размер стека
        if (current.next == null) return new ListNode[]{current, current};
        recc = rec(current.next, recc);
        recc[1].next = current;
        recc[1] = recc[1].next;
        return recc;
    }

}
