import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientExample {
    public static void main(String[] args) throws UnknownHostException, RuntimeException, IOException, ClassNotFoundException, InterruptedException {
        InetAddress host= InetAddress.getLocalHost();
        Socket socket=null;
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        for(int i=0;i<5;i++){
            socket=new Socket(host.getHostName(),9876);
            oos=new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeObject("Exit");
            else oos.writeObject(""+1);
            ois=new ObjectInputStream(socket.getInputStream());
            String message=(String) ois.readObject();
            System.out.println("Message"+message);
            ois.close();
            oos.close();
           Thread.sleep(1000);
        }

    }
}
