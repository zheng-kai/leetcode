package leetcode160;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> map = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            map.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (map.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}

// 双指针，空间复杂度 O(1)
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
//    }
//}

