package D4;

import java.util.Stack;

//18
public class DemoA {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        for (; i < pushA.length; i++) {
            //如果该条件不满足，就要一直入栈
            //如果该条件满足，就要一直出栈
            //两个元素相等，代表入栈逻辑结束，出栈逻辑开始
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[j]) {
                //入栈逻辑结束，开始出栈逻辑 
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
