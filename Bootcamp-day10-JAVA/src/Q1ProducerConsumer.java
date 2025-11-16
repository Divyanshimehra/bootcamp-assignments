class Buffer {
    int value;
    boolean available = false;

    synchronized void put(int v) throws InterruptedException {
        while (available) wait();
        value = v;
        System.out.println("Produced: " + v);
        available = true;
        notify();
    }

    synchronized void get() throws InterruptedException {
        while (!available) wait();
        System.out.println("Consumed: " + value);
        available = false;
        notify();
    }
}

public class Q1ProducerConsumer {
         static void main(String[] args) {
            Buffer b = new Buffer();

            new Thread(() -> {
                for (int i = 1; i <= 50; i++) {
                    try { b.put(i); } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }).start();

            new Thread(() -> {
                for (int i = 1; i <= 50; i++) {
                    try { b.get(); } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }).start();
        }
    }