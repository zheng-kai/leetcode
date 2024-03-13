package leetcode23;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return lists[i];
        }
        if (j - i == 1) {
            return merge2Lists(lists[i], lists[j]);
        }
        int mid = (i + j) / 2;
        ListNode l1 = mergeLists(lists, i, mid);
        ListNode l2 = mergeLists(lists, mid + 1, j);
        return merge2Lists(l1, l2);
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = l1;
        ListNode resPre = head;
        ListNode resNode = head.next;
        ListNode node = l2;
        while (resNode != null && node != null) {
            if (node.val < resNode.val) {
                ListNode next = node.next;
                resPre.next = node;
                node.next = resNode;
                resPre = node;
                node = next;
            } else {
                ListNode next = resNode.next;
                resPre = resNode;
                resNode = next;
            }
        }
        if (node != null) {
            resPre.next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        Solution s = new Solution();
        ListNode n = s.mergeKLists(lists);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}