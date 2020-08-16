package D2;

import java.util.ArrayList;
import java.util.Stack;

//3
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DemoB {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> st = new Stack<>();
        while (listNode != null) {
            st.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!st.empty()) {
            list.add(st.pop());
        }
        return list;
    }
}
