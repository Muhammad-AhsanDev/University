package ClientServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Clientclass {
     Socket socket;
     PrintWriter out;
     BufferedReader in;
     String ip;
     int port;
    String Servermsg= null;
    String messageClient;
Scanner inpt = new Scanner(System.in);


     Clientclass(String ip,int port) throws IOException { //Constructor to initialize the socket
        socket = new Socket(ip, port);
        // Setup output stream to send data to the server
          out = new PrintWriter(socket.getOutputStream(), true);
        // Setup input stream to receive data from the server
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     }
    public void sendtoServer(String messageClient) throws IOException {
        // Continuously read input from the user and send it to the server
            out.println(messageClient);
            if(messageClient.equalsIgnoreCase("quit")) {
                System.out.println("You have closed the connection.");
                try {
                    socket.close();
                    
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }}
          public void Dir() throws IOException{
               System.out.println("Class Received directory request from server.");
                System.out.println("Class Available files:");
                while (!(Servermsg = in.readLine()).equalsIgnoreCase("end") ) {
                    System.out.println(Servermsg);
          }
            
        }
    
    public String receiveFromServer() {
       
        try {
            Servermsg = in.readLine();
            if(Servermsg.equalsIgnoreCase("quit") || Servermsg.equalsIgnoreCase("shutdown") ) {
                System.out.println("Server has closed the connection.");
                   try {
                    socket.close();
                    
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            } 
         
            
        } catch (Exception e) {
            System.out.println("Error reading from server: " + e.getMessage());
        }
        return Servermsg;
       
    }

}

