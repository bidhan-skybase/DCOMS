import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class Table1 {
     synchronized void printTable(int n){
        for(int i=1;i<=5;i++){
            System.out.println(n+"*"+i+"="+(n*i));
        }try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            System.out.println(ie);
        }
    }
}
 class ExecutorServiceExample{
     public static void main(String[] args){
        Table1 obj= new Table1();
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        executorService.execute(()->obj.printTable(2));
         executorService.execute(()->obj.printTable(5));
         executorService.execute(()->obj.printTable(1));
         executorService.execute(()->obj.printTable(9));
         executorService.shutdown();


    }
}

