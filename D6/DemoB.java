package D6;

import java.util.ArrayList;
import java.util.Collections;

//22
public class DemoB {
    public void Swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public boolean IsExist(ArrayList<String> result, char[] str) {
        return result.contains(String.valueOf(str));
    }

    public void PermutationHelper(char[] str, int start, ArrayList<String> result) {
        if (start == str.length - 1) {
            if (!IsExist(result, str)) {       // 剪枝
                result.add(new String(str));
            }
            return;
        }
        for (int i = start; i < str.length; i++) {  // start代表的是第一个元素, i和start交换, 意味着 i作为起始元素
            Swap(str, start, i);   // i对应的元素作为开始
            PermutationHelper(str, start + 1, result);   // 以i开头的 所有的可能性的元素,全部保存到result中
            Swap(str, start, i);  // 回溯
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result); // 题目要求是按 字典序 打印所有的字符串
        }
        return result;
    }
}
