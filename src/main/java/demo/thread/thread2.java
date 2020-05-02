package demo.thread;

public class thread2 implements Runnable {
    private boolean[] flags = {true,false};
    private int total;
    private int step;

    public thread2 (int step){
        this.total = step;
    }

    @Override
    public void run(){
        while(step < total){

            boolean isSleep = flags[((int)(Math.random()*10))%2];
            if(isSleep){
                System.out.println("兔子睡着了");
            }else{
                step+=2;
                System.out.printf("兔子跑了%d 步...%n",step);
            }
        }
    }
}
