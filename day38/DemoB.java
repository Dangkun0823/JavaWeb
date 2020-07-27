package day38;

// 空格替换
public class DemoB {
    public String replaceSpace(String iniString, int length) {
        char[] ch = iniString.toCharArray();
        if (iniString == null || length <= 0) {
            return null;
        }
        int len = 0; //字符个数
        int blank = 0; //空格个数
        int i = 0; //从下标0开始遍历

        while (i < ch.length) {
            len++;
            if (ch[i] == ' ') {
                blank++;
            }
            i++;
        }

        int newlen = len + blank * 2; // 新数组长度
        char[] ch2 = new char[newlen];
        // 把数组1的内容全部拷贝到数组2.
        System.arraycopy(ch, 0, ch2, 0, length);
        int index1 = len - 1;
        int index2 = newlen - 1;
        while (index2 > index1 && index1 >= 0) {
            if(ch2[index1]==' '){
                ch2[index2--]='0';
                ch2[index2--]='2';
                ch2[index2--]='%';
            }else {
                ch2[index2]=ch2[index1];
                index2--;
            }
            index1--;
        }
        return String.valueOf(ch2);
    }
}
