 package MMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler  implements Runnable{
    public static ArrayList<ClientHandler> clients = new ArrayList<>();
    private Socket socket;
    BufferedReader in;
    PrintWriter out;
    private String clientusername;



//Client handler CONSTRUCTOR
    ClientHandler(Socket socket) throws IOException{
       try{ 
        this.socket=socket;
        this.in= new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true); 
        this.clientusername= in.readLine();
        clients.add(this);
        broadcastMessage("Server: "+ clientusername+ " has entered the chat");
        }
    catch(IOException e){
        closeEverything(socket, in, out);
       
    } 

}//end CONSTRUCTOR



    @Override
    public void run() {//THREAD RUN METHOD
    String messageFromClient;
        
     
        while(socket.isConnected()){
            try{
            messageFromClient = in.readLine();
            broadcastMessage(messageFromClient);}

        
        catch(IOException e){
            closeEverything(socket, in, out);
            System.out.println("ERROR READING MSG FORM CLIENT CLIENTHANDLER-->Run METHOD");
            break;
        }}
    }
    public void broadcastMessage(String messageTOSend){
      for(ClientHandler client : clients) {
    if(!client.clientusername.equals(this.clientusername)) {
        client.out.println(messageTOSend);
        
    }
}
    }

public void removeClientHandler(){
    clients.remove(this);
    broadcastMessage("SERVER: "+clientusername+" has Disconnected!");
}



public void closeEverything(Socket socket,BufferedReader in,PrintWriter out){
    try{if(in !=null){
        in.close();
    }
    if(out !=null){
        out.close();
    }
    if(socket !=null){
        socket.close();
    }}
    catch(IOException e){
        System.out.println("Error Occured Closing ");
        }
}

}

