package day22;

// 链表分割
// 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
// 分割以后保持原来的数据顺序不变
class ListNode1 {
    int val = 0;
    ListNode1 next = null;

    public ListNode1(int val) {
        this.val = val;
    }
}

public class DemoA1 {
    public ListNode1 partition(ListNode1 pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode1 BigHead = new ListNode1(-1);
        ListNode1 BigTail = BigHead;
        ListNode1 SmallHead = new ListNode1(-1);
        ListNode1 SmallTail = SmallHead;
        for (ListNode1 cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                SmallTail.next = new ListNode1(cur.val);
                SmallTail = SmallTail.next;
            } else if (cur.val > x) {
                BigTail.next = new ListNode1(cur.val);
                BigTail = BigTail.next;
            }
        }
        //合并大小链表
        SmallTail.next = BigHead.next;
        return SmallTail.next;
    }
}
