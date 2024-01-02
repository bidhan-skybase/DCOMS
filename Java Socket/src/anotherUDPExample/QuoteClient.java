package anotherUDPExample;
import java.net.*;
import java.io.*;
public class QuoteClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Syntax:QuoteClient<hostname> <port>");
            return;
        }
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
                socket.send(request);
                byte[] buffer = new byte[512];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                String quote = new String(buffer, 0, response.getLength());
                System.out.println(quote);
                System.out.println();
                Thread.sleep(1000);
            }
        } catch (SocketTimeoutException e) {
            System.out.println(e);
            throw new RuntimeException(e);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }}
