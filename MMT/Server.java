package MMT;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Serverclass{
    private ServerSocket serverSocket;
    private Socket clientSocket;

    Serverclass(ServerSocket serverSocket) throws IOException{
        this.serverSocket=serverSocket;
    }
    public void Severstart() throws IOException{
        while (!(serverSocket.isClosed())) {
            clientSocket=serverSocket.accept(); 
            System.out.println("A NEW CLIENT CONNECTED");         
            ClientHandler clientHandler= new ClientHandler(clientSocket);
        Thread thread = new Thread(clientHandler);
        thread.start();
        
        
        }

    }
    public void closeServer(){
        if(serverSocket!=null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}   




public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Serverclass server = new Serverclass(serverSocket);
        server.Severstart();
    }
}
