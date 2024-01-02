import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class Server extends UnicastRemoteObject implements DayCalculator {

    protected Server() throws RemoteException {
        super();
    }
    public String getDayOfWeek() throws RemoteException {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String dayName;

        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayName = "Sunday";
                break;
            case Calendar.MONDAY:
                dayName = "Monday";
                break;
            case Calendar.TUESDAY:
                dayName = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                dayName = "Wednesday";
                break;
            case Calendar.THURSDAY:
                dayName = "Thursday";
                break;
            case Calendar.FRIDAY:
                dayName = "Friday";
                break;
            case Calendar.SATURDAY:
                dayName = "Saturday";
                break;
            default:
                dayName = "Unknown";
                break;
        }

        return dayName;
    }
    public static void main(String args[])throws RemoteException{
        try{
            Registry reg = LocateRegistry.createRegistry(1088);
            reg.rebind("server", new Server());
            System.out.println("Server is running");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
