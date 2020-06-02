import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (size != 0) {
            if (size >= k) {
                int count = k;

                List<ListNode> list = new ArrayList<>();

                list = reverseKNodes(nextHead, count);

                tail.next = list.get(0);
                nextHead = list.get(1);

                tail = head;
                head = nextHead;

                size -= k;
            } else {
                tail.next = nextHead;

                size = 0;
            }
        }

        return dummy.next;
    }

    public List<ListNode> reverseKNodes(ListNode head, int count) {
        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;

        while (count > 1) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count--;
        }

        return Arrays.asList(prev, curr);
    }
}
// @lc code=end
