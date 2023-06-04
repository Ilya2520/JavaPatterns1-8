package Prac3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Test {
    public static void Ts() {

        MyMap abc=new MyMap();
        Runnable runnable=()->{
            Thread currentThread = Thread.currentThread();
            for(int i=0;i<10;i++) {
                if (abc.isEmpty()) {
                    abc.put(1,1 + "num");
                } else {
                    abc.put(abc.size() + 1, abc.size()+ 1+"num");
                }

                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread a1=new Thread(runnable);
        Thread a2=new Thread(runnable);
        Thread a3=new Thread(runnable);
        a1.start();
        a2.start();
        a3.start();
    }
    public static void m() {
        MySet abc = new MySet();
        Runnable runnable=()->{
            Thread currentThread = Thread.currentThread();
            for(int i=0;i<10;i++) {
                if (abc.isEmpty()) {
                    abc.add(1);
                } else {
                    abc.add((Integer) (abc.toArray()[abc.size() - 1]) + 1);


                }
            }
        };
        Thread a1=new Thread(runnable);
        Thread a2=new Thread(runnable);
        Thread a3=new Thread(runnable);
        a1.start();
        a2.start();
        a3.start();
    }

    public static void main(String[] args) {
        Ts();
    }

}
