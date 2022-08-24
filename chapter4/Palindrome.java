package chapter4;

import java.util.Stack;

public class Palindrome {
    // need n extra space
    public boolean isPail1 (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while(head != null) {
            int popVal = stack.pop();
            if(popVal != head.val) return false;
            head = head.next;
        }
        return true;
    }

    // need O(1) extra space
    public boolean isPail2 (ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode copyPre = pre;
        while(head != null && pre != null) {
            if(head.val != pre.val) return false;
            head = head.next;
            pre = pre.next;
        }
        cur = null;
        while(copyPre != null) {
            ListNode next = copyPre.next;
            copyPre.next = cur;
            cur = copyPre;
            copyPre = next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next = null;
}
