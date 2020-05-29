/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = head;
        int size = 0;

        while (h != null) {
            size++;
            h = h.next;
        }

        if (size < k) {
            return head;
        } else {
            ListNode nextHead = head;

            for (int i = 0; i < k; i++) {
                nextHead = nextHead.next;
            }

            ListNode dummy = reverseKNodes(head, k);
            head.next = reverseKGroup(nextHead, k);

            return dummy;
        }
    }

    public ListNode reverseKNodes(ListNode head, int count) {
        if (count < 2) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while (curr != null && count > 1) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count--;
        }

        return prev;
    }
}
// @lc code=end
