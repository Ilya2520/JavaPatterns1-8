package prac4;

public class Test {
    public static void main(String[] args) {
        My exc=new My(3);
        exc.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        exc.submit(() -> System.out.println("Start"));
        exc.shutdown();
    }
}
