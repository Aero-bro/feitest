package demo.thread;

public class thread1 implements Runnable{

    private int total;
    private int step;

    public thread1(int step){
        this.total = step;
    }

    @Override
    public void run(){
        while(step < total){
            step++;
            System.out.printf("乌龟跑了%d 步...%n",step);
        }
    }
}
