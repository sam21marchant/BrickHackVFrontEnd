package networking;
import java.net.*;
import java.io.*;

public class Client {
    private String username;
    private String password;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;


    /*
     * Instantiates a Client Object with a user name and password. This will data will be sent to the server to process.
     */
    public Client(String username, String password){
        this.username = username;
        this.password = password;
        System.out.println("Username: " + username + "\nPassword: " + password);
        try {
            socket = new Socket("10.0.0.118", 35002);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sendLogin() {
        out.println("{username:"+username+", password:"+password+"}");




        return false;
    }
    public static void main(String[] args) {
        String host = "10.0.0.118";
        int port = 35002;
        try (Socket socket = new Socket(host, port)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                out.println("cats");
                System.out.println(in.readLine());

            }

        } catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}

