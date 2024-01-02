class abc implements Runnable{
    public void run(){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("The state of thread T1 while it invoked the method join() on thread t2 - "+ThreadState.t1.getState());
        try{
            Thread.sleep(2000);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
public class ThreadState implements Runnable{
    public static Thread t1;
    public static ThreadState obj;
    public static void main(String args[]){
        obj=new ThreadStatee();
        t1=new Thread(obj);
        System.out.println("The state of thread t1 after spawning it - "+t1.getState());
        t1.start();
        System.out.println("The state of thread t1 after invoking the method start()"+t1.getState());
    }
}