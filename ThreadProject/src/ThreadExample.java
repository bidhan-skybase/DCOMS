public class ThreadExample {
    public static void main(String[] args){
        APU thread1=new APU();
        Thread thread=new Thread(thread1);
        thread.start();
        System.out.println(thread.getState());

    }
}
