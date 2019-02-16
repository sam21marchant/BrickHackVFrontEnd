import java.net.*;
import java.io.*;
public class client {
    public static void main(String[] args) {
        String host = "10.0.0.118";
        int port = 35002;
        try (Socket socket = new Socket(host, port)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
    }
}

