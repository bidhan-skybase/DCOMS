/**
 * Main
 */

public class Main {
    // No need to use this when using non-static method
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }

    // public synchronized static void printMethod(int num) {
    // for (int i = 1; i <= 10; i++) {
    // System.out.println(num + " x " + i + " = " + num * i);
    // }
    // }

    public static void printMethod(int num) {

        // You can use this
        // synchronized (this) {
        synchronized (lock) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + num * i);
            }
        }
    }

    public static class Thread1 extends Thread {

        public void run() {
            printMethod(2);

        }
    }

    public static class Thread2 extends Thread {

        public void run() {
            printMethod(3);
        }
    }
}