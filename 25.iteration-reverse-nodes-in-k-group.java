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

        // no need to reverse
        if (k < 2 || head == null || head.next == null) {
            return head;
        }

        // get number of nodes
        ListNode h = head;
        int size = 0;

        while (h != null) {
            size++;
            h = h.next;
        }

        ListNode prevTail = new ListNode(0);
        h = prevTail; /* return h.next */
        ListNode currHead = head;

        while (size >= 2 && size >= k) {

            // get head of current reversed group and tail of next group
            List<ListNode> currGroup = reverseKNodes(currHead, k);

            prevTail.next = currGroup.get(0);
            prevTail = currHead;
            currHead = currGroup.get(1);

            size -= k;
        }

        prevTail.next = currHead; /* remaining nodes that don't need to reverse */

        return h.next;
    }

    public List<ListNode> reverseKNodes(ListNode head, int count) {

        // initialize pointers position
        ListNode prev = head;
        ListNode curr = head.next;

        while (count - 1 > 0) {
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
