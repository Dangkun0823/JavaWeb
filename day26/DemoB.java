package day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票.
//每行输出候选人的名字和得票数量
//最后一行输出无效投票Invalid.
public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt(); //候选人数
            String[] p = new String[a];
            Map<String, Integer> map1 = new HashMap<>();
            for (int i = 0; i < a; i++) {
                p[i] = sc.next();
                map1.put(p[i], 0);
            }
            int b = sc.nextInt(); //选票数
            Set<String> set=map1.keySet();
            int cnt=0;            //无效票数
            for (int j = 0; j < b; j++) {
                String tick=sc.next();
                if(set.contains(tick)){
                    map1.put(tick,map1.get(tick)+1);
                }else {
                    cnt++;
                }
            }
            for(String s:p){
                System.out.println(s+" : "+map1.get(s));
            }
            System.out.println("Invalid : "+cnt);
        }
    }
}