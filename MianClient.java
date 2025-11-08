import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MianClient {
    public static void main(String args[]) throws IOException 
    {

        Scanner inpt = new Scanner(System.in);
        Clientclass side = new Clientclass("localhost",9090);
        while (true) {
            System.out.println("Enter a message to send to the server (type 'quit' to exit):");
            String clientMessage= inpt.nextLine();//send message to server
            side.sendtoServer(clientMessage);



            if(clientMessage.equalsIgnoreCase("quit")) {
                System.out.println("You have closed SEnd main the connection.");
                break;
            }
            if(clientMessage.equalsIgnoreCase("dir")) {
                side.Dir();
            }
            String response = side.receiveFromServer();
              if(response.equalsIgnoreCase("quit") || response.equalsIgnoreCase("shutdown")) {
                System.out.println("You have closed main Respnse the connection.");
                break;
            }
           
            System.out.println(response);
            
            
        }
       
        
   
    }
}
