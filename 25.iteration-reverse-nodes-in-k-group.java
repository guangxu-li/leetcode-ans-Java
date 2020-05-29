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
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }

        if (size < k || k < 2) {
            return head;
        }

        ListNode nextHead = head;
        ListNode tail = new ListNode(0);
        h = tail;
        ListNode next = head;

        while (size != 0) {
            if (size >= k) {
                int count = k;

                ListNode prev = nextHead;
                ListNode curr = nextHead.next;
                prev.next = null;

                while (count > 1) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;

                    count--;
                }

                tail.next = prev;
                tail = nextHead;
                nextHead = next;

                size -= k;
            } else {
                tail.next = nextHead;

                size = 0;
            }
        }

        return h.next;
    }
}
// @lc code=end
