package D7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// 24
public class DemoA {
    public ArrayList<Integer> topK(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        //  找topk小的,建大堆. 优先级队列默认是小堆, 所以我们让前k个元素自动降序排.
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                queue.offer(input[i]);// 提前插入k个数据，queue会自动排序
            } else {
                if (input[i] < queue.peek()) { // input[i]比最大的小，更新
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }//返回对应的结果
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
