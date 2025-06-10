import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ClientInfoStatus;

public class Server {
    public void run() throws IOException {
        int port =8010;
        ServerSocket socket =  new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true){
            try {
                System.out.println("Server is Listening on Port :" + port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection accepted from Client "+acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello From the Server ");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}