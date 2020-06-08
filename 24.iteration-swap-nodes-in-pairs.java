/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);

        // in case head or head.next is null;
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode l = head;
            ListNode r = head.next;

            // link prev 2 nodes to current group
            prev.next = r;
            prev = l;

            head = r.next;

            r.next = l;
            l.next = head; /* for odd size input */
        }

        return dummy.next;
    }
}
//@lc code=end
