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

        // get number of nodes
        while (h != null) {
            size++;
            h = h.next;
        }

        // no need to reverse
        if (size < k) {
            return head;
        }

        // move to the head of next group
        ListNode nextHead = head;

        for (int i = 0; i < k; i++) {
            nextHead = nextHead.next;
        }

        /*
         * 1. reverse current group
         * 2. reverse remaining nodes
         */
        h = reverseKNodes(head, k);
        head.next = reverseKGroup(nextHead, k);

        return h;
    }

    public ListNode reverseKNodes(ListNode head, int count) {
        // no need to reverse
        if (count < 2) {
            return head;
        }

        // initialize pointers position
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while (count > 1) {
            // keep next node
            ListNode next = curr.next;

            // reverse
            curr.next = prev;

            // move to the next
            prev = curr;
            curr = next;

            count--;
        }

        return prev;
    }
}
// @lc code=end
