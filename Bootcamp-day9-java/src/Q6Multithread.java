class TablePrinter {
    // Synchronization lock object
    synchronized void printTable(int number) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(500); // simulate delay
                notify(); // notify waiting thread
                wait();   // let other thread run
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        notify(); // prevent final deadlock
    }
}

class MyThread extends Thread {
    TablePrinter tp;
    int number;

    MyThread(TablePrinter tp, int number, String name) {
        super(name);
        this.tp = tp;
        this.number = number;
    }

    @Override
    public void run() {
        tp.printTable(number);
    }
}

public class Q6Multithread {
    public static void main(String[] args) {
        TablePrinter tp = new TablePrinter();

        MyThread t1 = new MyThread(tp, 2, "Thread-1");
        MyThread t2 = new MyThread(tp, 4, "Thread-2");

        t1.start();
        t2.start();
    }
}
