import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String args[]) throws IOException 
    {
       
        
    
        // create a socket to connect to the server running on localhost at port number 9090
        Socket socket = new Socket("192.168.100.19", 9090);
        
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
while (true) {
    
         System.out.println("Enter a message to send to the server (type 'quit' to exit):");
        Scanner inpt = new Scanner(System.in);
        String clientMessage= inpt.nextLine();

        // Send message to the server
    
        out.println(clientMessage);
        if(clientMessage.equals("quit")) {
            System.out.println("Client has requested to quit.");
            System.out.println("Disconnected");
            break;
        }

        // Receive response from the server
        String response ;
        if (clientMessage.equalsIgnoreCase("dir")) {
            while (!(response = in.readLine()).equals("END")) {
                System.out.println("Server: " + response);
            }
        }
        if(clientMessage.contains(".get()")) {
            while (!(response = in.readLine()).equals("END")) {
                System.out.println( response);
            }}
         else {
            response = in.readLine();
             System.out.println("192.168.100.19 Server says: " + response);
        }

       }

        // Close the socket
        socket.close();
        System.out.println("Client shut down.");
    }
}
