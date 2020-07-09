package day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//学生成绩排列.
class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class DemoC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();  //排序人数.
            int o=sc.nextInt();  //排序策略.
            List<Student> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new Student(sc.next(),sc.nextInt()));
            }

            if(o==0){   //降序
                list.sort((o1, o2) -> o2.score-o1.score);
            }else if(o==1){    //升序
                list.sort((o1, o2) -> o1.score-o2.score);
            }
            for(Student s:list){
                System.out.println(s.name+" "+s.score);
            }
        }
    }
}
