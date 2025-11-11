import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SyncPrinter{
    synchronized void printTable(int number){
        for(int i=1; i<= 5; i++){
            System.out.println(Thread.currentThread().getName()+"->"+number+" x "+i+" = "+(number*i));
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class TableTask implements Runnable{
    private SyncPrinter sp;
    int number;

    TableTask(SyncPrinter sp, int number){
        this.sp= sp;
        this.number= number;
    }

    @Override
    public void run(){
        sp.printTable(number);
    }

}

public class Q7ExecutorServiceThread {
    static void main(String[] args) {
        SyncPrinter sp = new SyncPrinter();

        ExecutorService executer = Executors.newFixedThreadPool(2);

        executer.submit(new TableTask(sp, 2));
        executer.submit(new TableTask(sp, 4));

        executer.shutdown();
    }
}
