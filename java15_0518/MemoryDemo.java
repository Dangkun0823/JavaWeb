package java15_0518;


public class MemoryDemo {

    //n=10--->隐藏了int n=传入的值。
    // 方法的传入参数，都是一个局部变量：绑定在线程执行方法的方法栈
    public static int f(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return f(n-1)+f(n-2);
    }

    public static void t2(Node node){
        node.next=new Node("B");
        node=new Node("C");
    }

    public static void main(String[] args) {
        System.out.println(f(10)); //有一个10这样的数值
        Node n=new Node("A");
        t2(n);
        System.out.println(n.name);
        System.out.println(n.next.name);
    }

    private static class Node{
        private Node next;
        private String name;

        public Node(String name) {
            this.name = name;
        }
    }
}
