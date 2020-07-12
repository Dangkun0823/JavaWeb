package day22;

// 给定两个链表ListNodeA，ListNodeB，返回A+B的结果(一个新的ListNode)
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DemoA {
    public ListNode plusAB(ListNode A, ListNode B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        ListNode p1 = A, p2 = B;
        ListNode pHead = new ListNode(-1);
        ListNode cur = pHead;
        int sum = 0;
        while (p1!=null||p2!=null||sum!=0){
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            } if(p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            cur.next=new ListNode(sum%10);
            sum/=10;
            cur=cur.next;
        }
        return pHead.next;
    }
}
