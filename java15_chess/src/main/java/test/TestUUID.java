package test;


import java.util.UUID;

// 是让分布式系统中的所有元素, 都能有唯一的辨识信息
public class TestUUID {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
