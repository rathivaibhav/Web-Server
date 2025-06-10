import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    public Consumer<Socket> getConsumer(){
        /* return  new Consumer<Socket>() {
            @Override
            public void accept(Socket clienSocket) {
                try {
                    PrintWriter toClient = new PrintWriter(clienSocket.getOutputStream());
                    toClient.println("Hello from the Server");
                    clienSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }*/
        return(clienSocket)->{
            try (PrintWriter toSocket = new PrintWriter(clienSocket.getOutputStream(), true)){
               toSocket.println("Hello from server "+clienSocket.getInetAddress());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }
    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is Listening on port : "+port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread(()-> server.getConsumer().accept(clientSocket));
                thread.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
