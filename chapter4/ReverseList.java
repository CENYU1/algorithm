package chapter4;

public class ReverseList {
    // 双指针解法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归解法
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if(cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    // 从后往前翻转
    public ListNode reverseList3(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode (int val) {
        this.val = val;
    }
}
