package java15_0520;

public class Node {
    public static final Node N1 = new Node();
    public static final Node N2 = new Node();
    public static final Node N3 = new Node();
    public static final Node N4 = new Node();
    public static final Node N5 = new Node();

    public static Node[] values() {
        Node[] nodes = new Node[5];
        nodes[0] = N1;
        nodes[1] = N2;
        nodes[2] = N3;
        nodes[3] = N4;
        nodes[4] = N5;
        return nodes;
    }

    public static void main(String[] args) {
        //直接使用枚举类
        Thread.State s = Thread.State.NEW;
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}
