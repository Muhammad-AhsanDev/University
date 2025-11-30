package MMT;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


 

public class mainclient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Scanner sc = new Scanner(System.in)) {
            String Username = sc.nextLine();
            Socket socket=new Socket("localhost",9090);
            Client client = new Client(socket,Username);
            client.Listenformsg();
            client.sendmsg();

        }
    }
     
}
class Client {
    private Socket socket;
    private String Username;
    private BufferedReader in ;
    private PrintWriter out;
 
    Client(Socket socket ,String Username){
        this.socket=socket;
        this.Username=Username;
        try {
            this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out=new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
        System.out.println("error initializing in and out ");
        }
        
    }
    public void sendmsg(){//SEND MSG TO CLIENTHANDLER
        out.println(Username);
        Scanner sc = new Scanner(System.in);
        while (socket.isConnected()) {
            String  msgtosend = sc.nextLine();
            out.println(Username+": "+msgtosend);
            
        }
    }
    public void Listenformsg(){
        new Thread(new Runnable(){//anonymus class
               @Override
            public void run(){
                String msgforgroupchat;
                while (socket.isConnected()) {
                    try{
                    msgforgroupchat=in.readLine();//reads from client handlers broadcast method
                    System.out.println(msgforgroupchat);
                    }
                  catch(IOException e){
                    System.out.println("Error Occcured Reading form client");
                  }
                  

                    }

            }
        }).start();
    }


   
}

