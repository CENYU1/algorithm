package chapter4;

public class Partition {
    // 保证原有顺序实现
    public ListNode partition1 (ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallHead = small;
        ListNode largeHead = large;
        while(head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    // 不保证原有顺序实现
    public ListNode partition2 (ListNode head, int x) {
        ListNode p = head;
        int len = 0;
        while(p != null) {
            len++;
            p = p.next;
        }
        ListNode[] arr = new ListNode[len];
        p = head;
        for(int i = 0; i < len; i++) {
            arr[i] = p;
            p = p.next;
        }
        arrPartition(arr, x);
        for(int i = 0; i < len - 1; i++) {
            arr[i].next = arr[i + 1];
        }
        arr[len - 1].next = null;
        return arr[0];
    }

    public void arrPartition(ListNode[] arr, int x) {
        int i = -1, j = arr.length, p = 0;
        while(p != j) {
            if(arr[p].val < x) {
                swap(arr, ++i, p++);
            } else if(arr[p].val == x) {
                p++;
            } else {
                swap(arr, --j, p);
            }
        }
    }

    public void swap(ListNode[] arr, int i, int j) {
        ListNode t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
