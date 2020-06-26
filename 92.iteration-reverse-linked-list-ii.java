/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(0);
        h.next = head;

        ListNode curr = h;
        ListNode prev = null;
        while (m > 0) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode reversedHead = prev;
        prev = curr;
        curr = curr.next;
        ListNode next = null;
        while (n-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        reversedHead.next.next = curr;
        reversedHead.next = prev;

        return h.next;
    }
}
// @lc code=end

