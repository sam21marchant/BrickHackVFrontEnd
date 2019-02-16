package networking;

import java.net.*;
import java.io.*;

public class Client {
    private String username;
    private String password;

    public Client(String username, String password){
        this.username = username;
        this.password = password;
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

