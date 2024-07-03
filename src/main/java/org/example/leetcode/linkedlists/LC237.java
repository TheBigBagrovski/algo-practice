package org.example.LeetCode;

public class LC237 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);
        ListNode nine = new ListNode(9);
        head.next = five;
        five.next = one;
        one.next = nine;
        solve(five);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static void solve(ListNode node) {
        ListNode current = node.next;
        while (current.next != null) {
            node.val = current.val;
            node = current;
            current = current.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

}
