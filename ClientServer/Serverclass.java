package ClientServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverclass {
    

    int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader inC;
    private PrintWriter out;
    private String clientmessage = null;
    private String serverMessage;
    private boolean running = true;
    Serverclass(int port) throws IOException{//Constructor to initialize the server socket
         serverSocket = new ServerSocket(port);//Starter
        
    }
        public void acceptClient() throws IOException {
        System.out.println("Server is running and waiting for client connection...");
        clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        inC = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }





public String recive_Clientmsg() throws IOException{
    clientmessage = inC.readLine(); //takes client input 

    if(clientmessage.equalsIgnoreCase("quit")){ //Quits
      System.out.println("XXXXXXXXXXXXClient has requested to quitXXXXXXXX");
         System.out.println("XXXXXXXXXXX CLOSING THE Client NOW XXXXXXXXXXX");    
         clientSocket.close();
        return"quit";
        }
        if(clientSocket.isClosed()){
            System.out.println("Client socket is closed.");
            clientSocket.close();
            return "Socket Closed";
        }
        else{
            return clientmessage;

        }
    
}//end reciving
public void Send_Clientmsg(String serverMessage) throws IOException{
            out.println(serverMessage);
            if(serverMessage.equalsIgnoreCase("quit")){
                System.out.println("XXXXXXXXXXXXXXXXXXX!!DISCONNECTED FROM THE CLIENT!!XXXXXXXXXXXXXXXXXXXXXXXX");
        clientSocket.close();
            }

}//end sending
public void Dir(String[] files){
    for(String file:files){
        out.println(file);
    }
    out.println("End"); // Indicate the end of the directory listing
}
public void Shutdown() throws IOException {
 clientSocket.close();
 serverSocket.close();
    System.out.println("Server shutdown successfully.");}
    public boolean isRunning() {
        return running;
    }
}