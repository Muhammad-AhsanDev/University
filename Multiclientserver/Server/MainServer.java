package Multiclientserver.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket ssocket = new ServerSocket(9090);
        String[] filenames ={"Alpha","Beta","BATMINTIon"};
        System.out.println("SERRVER Is Running ");
        Socket clientSocket = ssocket.accept();
        System.out.println("Client Connected");
        BufferedReader in =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
Scanner sc =new Scanner(System.in);


        

        while (true) {
        String message = in.readLine();
    
         
        if (message.equalsIgnoreCase("quit")){
            System.out.println("Client has requested to quit.");
            out.println("Disconnected!");
           break;
        }
       
        System.out.println("Client says: " + message);//RECIVING Done 


        //SENDING STARTS HERE !!!!!!!!!!!!!!!
        if(message.equalsIgnoreCase("dir")){
            for(String file:filenames){
                out.println(file);
            }
            System.out.println("now");
            out.println("end");
            System.out.println("ALL.FIle.SENDED.To.CLient");
            continue;
        }
        if(message.contains("get()")){
            String[] parts = message.split("get()");
            String path =parts[0]+"txt";
            File file=new File(path);
            Scanner filereader = new Scanner(file);
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                out.println(line);
                
            }
            filereader.close();
             out.println("Done");
        }

             System.out.println("ENTER the Message");
             String sendmsg = sc.nextLine();


             if(sendmsg.equalsIgnoreCase("quit")){
                out.println(sendmsg);
                break;
             }
             else{
                    out.println(sendmsg);
             }
            
        }
       


        clientSocket.close();
        ssocket.close();
System.out.println("SERVER,Close");
      
            
           
    }
}
