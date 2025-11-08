import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainServer {
    public static void main(String args[]) throws IOException {
        

    
        String[] files = {"file1.txt", "file2.txt", "file3.txt"}; // Example file list
        Serverclass sclass = new Serverclass(9090);
        Scanner scanner = new Scanner(System.in);
        String Sendmsg = "";
        while(sclass.isRunning()){
            sclass.acceptClient(); // Accept client connection
        
        while(true){

        String CRecive = sclass.recive_Clientmsg();

         if(CRecive.equalsIgnoreCase("quit")) {
                System.out.println("You have closed Server Client  connection.");
                break;
            }
            System.out.println(CRecive);
            if(CRecive.equalsIgnoreCase("dir")) {
                System.out.println("Client requested Files listing.");
                sclass.Dir(files);
            } 

        System.out.println("Enter a Message to Client:");
        Sendmsg = scanner.nextLine();
        sclass.Send_Clientmsg(Sendmsg);
           if(Sendmsg.equalsIgnoreCase("quit")) {
                System.out.println("You have closed Server SEnd main the connection.");
                break;
            }
           if(Sendmsg.equalsIgnoreCase("shutdown")){
                System.out.println("Server is shutting down.");
                sclass.Shutdown();
                break;
            }
        
        }

        if(Sendmsg.equalsIgnoreCase("shutdown")){
                break;
    }}
scanner.close(); }}