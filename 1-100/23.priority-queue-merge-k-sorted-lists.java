import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
        Comparator<ListNode> cmp = new Comparator<>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };

        Queue<ListNode> queue = new PriorityQueue<>(cmp);

        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode h = head;

        while (!queue.isEmpty()) {
            h.next = queue.poll();
            h = h.next;
            if (h.next != null) {
                queue.add(h.next);
            }
        }

        return head.next;
    }
}


class ListNode {

}
// @lc code=end
