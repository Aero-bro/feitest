package demo.thread;

public class test
{
    public static void main(String[] args) {
        thread1 t = new thread1(10);
        thread2 t2 = new thread2(10);
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
