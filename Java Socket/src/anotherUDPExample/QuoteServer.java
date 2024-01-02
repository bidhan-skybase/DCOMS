package anotherUDPExample;

import java.util.*;
import java.net.*;
import java.io.*;

public class QuoteServer {
    private DatagramSocket socket;
    private List<String> listQuotes=new ArrayList<String>();
    private Random random;
    public QuoteServer(int port) throws SocketException{
        socket=new DatagramSocket(port);
        random=new Random();
    }
    public static void main(String[] args){
        if(args.length<2){
            System.out.println("Syntax: QuoteServer <file> <port>");
            return;
        }
        String quoteFile=args[0];
        int port=Integer.parseInt(args[1]);
        try{
            QuoteServer server=new QuoteServer(port);
            server.loadQuotesFromFile(quoteFile);
            server.service();


        } catch (SocketException e) {
            System.out.println("Socket error: "+e.getMessage());
        }catch (IOException ex){
            System.out.println("I/O error: "+ex.getMessage());
        }
    }
    private void service()throws IOException{
        while(true){
            DatagramPacket request=new DatagramPacket(new byte[1],1);
            socket.receive(request);
            String quote=getRandomQuote();
            System.out.println(quote);
            byte[] buffer= quote.getBytes();
            InetAddress clientAddress= request.getAddress();
            int clientPort=request.getPort();
            DatagramPacket response=new DatagramPacket(buffer,buffer.length,clientAddress,clientPort);
socket.send(response);
        }
    }
    private void loadQuotesFromFile(String quoteFile)throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(quoteFile));
        String aQuote;
        while((aQuote=reader.readLine())!=null){
            listQuotes.add(aQuote);
        }
        reader.close();
    }
    private String getRandomQuote(){
        int randomIndex=random.nextInt(listQuotes.size());
        String randomQuote=listQuotes.get(randomIndex);
        return randomQuote;
    }
}
