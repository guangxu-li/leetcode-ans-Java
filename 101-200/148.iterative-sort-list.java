/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    private ListNode split(ListNode head, int length) {
        if (head == null) {
            return head;
        }

        for (int i = 1; head != null && head.next != null && i < length; i++) {
            head = head.next;
        }

        ListNode nextHead = head.next;
        head.next = null;

        return nextHead;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        while (left != null || right != null) {
            int x = left == null ? Integer.MAX_VALUE : left.val;
            int y = right == null ? Integer.MAX_VALUE : right.val;

            if (x <= y) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        return tail;
    }

    public ListNode sortList(ListNode head) {
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int step = 1; step < size; step *= 2) {
            ListNode prev = dummyHead;
            ListNode cur = dummyHead.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);

                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummyHead.next;
    }
}
// @lc code=end

