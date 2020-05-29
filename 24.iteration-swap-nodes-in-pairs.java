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
        dummy.next = head;

        ListNode prevNode = dummy;

        while (head != null && head.next != null) {
            ListNode l = head;
            ListNode r = head.next;

            prevNode.next = r;
            l.next = r.next;
            r.next = l;

            prevNode = l;
            head = l.next;
        }

        return dummy.next;
    }
}
// @lc code=end
