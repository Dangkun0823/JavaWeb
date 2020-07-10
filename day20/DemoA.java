package day20;

import java.util.HashMap;
import java.util.Map;

//微信红包:
public class DemoA {
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<gifts.length;i++){
            int a=gifts[i];
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
               map.put(a,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>gifts.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
