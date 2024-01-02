import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DayClient {
    public static void main(String[] args) {
        DayClient c = new DayClient();
        c.connectServer();
    }
    private void connectServer(){
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            DayCalculator a = (DayCalculator) reg.lookup("server");
            System.out.println("Today is: "+a.getDayOfWeek());


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
