/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;

        while (true) {
            int min = Integer.MAX_VALUE;
            boolean isBreak = true;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    isBreak = false;

                    if (lists[i].val < min) {
                        minIndex = i;
                        min = lists[i].val;
                    }
                }
            }

            if (isBreak) {
                break;
            }

            h.next = lists[minIndex];
            h = h.next;
            lists[minIndex] = lists[minIndex].next;
        }

        h.next = null;

        return head.next;
    }
}
// @lc code=end
