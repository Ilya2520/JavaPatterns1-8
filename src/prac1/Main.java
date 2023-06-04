package prac1;

import java.util.Comparator;
import java.lang.Comparable;

public class Main {
    static Comparator<Student> comp = (a1, a2)->{
        if(a1.getSum()> a2.getSum())
            return a1.getSum();
        else
            return a2.getSum();
    };

    public static void main(String[] args) {
        Student a1 = new Student(18, "ivan", 50);
        Student a2 = new Student(19, "Andrey", 57);
        System.out.println("Наибольшая сумма "+comp.compare(a1,a2));
    }


}
