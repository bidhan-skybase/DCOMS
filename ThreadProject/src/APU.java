public class APU implements Runnable{
@Override
    public void run(){

        try{
            System.out.println("Hello from APU");
            Thread.yield();

            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
