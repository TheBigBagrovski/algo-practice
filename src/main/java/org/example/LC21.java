package org.example;

public class LC21 {

    static class ListNode {
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
        ListNode a = new ListNode(4, null);
        ListNode b = new ListNode(2, a);
        ListNode list1 = new ListNode(1, b);
        ListNode c = new ListNode(4, null);
        ListNode d = new ListNode(3, c);
        ListNode list2 = new ListNode(1, d);
        mergeTwoLists(list1, list2);
    }

    public ListNode best(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = best(l1.next, l2);
            return l1;
        } else{
            l2.next = best(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) { // O(n+m), O(1)
        ListNode answer, head;
        if(list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        if (list1.val >= list2.val) {
            answer = list2;
            list2 = list2.next;
        }
        else {
            answer = list1;
            list1 = list1.next;
        }
        head = answer;
        do {
            if(list1 == null) {
                answer.next = list2;
                return head;
            } else if (list2 == null) {
                answer.next = list1;
                return head;
            }
            if (list1.val >= list2.val) {
                answer.next = list2;
                list2 = list2.next;
            } else {
                answer.next = list1;
                list1 = list1.next;
            }
            answer = answer.next;

        } while (list1 != null || list2 != null);
        return head;
    }

}
