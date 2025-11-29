package Multiclientserver.CLient;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Mainclient {
    public static void main(String args[]) throws IOException 
    {
       
        
    
        // create a socket to connect to the server running on localhost at port number 9090
        Socket socket = new Socket("localhost", 9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner sc =new Scanner(System.in);
        
      


        while (true) {
             System.out.println("ENTER the Message");
            String  msg = sc.nextLine();
            out.println(msg);
            if(msg.equalsIgnoreCase("quit")){
                break;
            }
          String  recivemsg;
            
            if(msg.equalsIgnoreCase("dir")){
                while(!((recivemsg=in.readLine()).equalsIgnoreCase("end"))){
                    System.out.println(recivemsg);
                   
                }
                continue;
            }
            
            if(msg.contains("get()")){
                while(!((recivemsg=in.readLine()).equalsIgnoreCase("done"))){
                    System.out.println(recivemsg);}
                   
                }




            recivemsg=in.readLine();
            if(recivemsg.equalsIgnoreCase("quit")){
                 System.out.println("SERVER SAYS"+ recivemsg);
                break;
            }
            else{
                 System.out.println(recivemsg);
            }
           
            

            
            
        }
        socket.close();
        System.out.println("Client shut down.");
    }
}