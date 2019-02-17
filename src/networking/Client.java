package networking;
import java.net.*;
import java.io.*;
import java.util.HashMap;

import org.json.*;

import javax.swing.*;

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



    /*
     * Send login information to the server
     * The server will tell the user if they are the
     */
    public boolean sendLogin() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("action", "login");

        JSONObject obj = new JSONObject(map);

        out.println(obj.toString());
        boolean successful = false;
        boolean retVal = false;
        while(!successful) {
            try {
                System.out.println(in.readLine());
                String loginResponse = in.readLine();
                JSONObject loginObject = new JSONObject(loginResponse);
                successful = loginObject.getBoolean("successful");
                if (!successful){
                    String message = loginObject.getString("message");
                    JOptionPane.showMessageDialog(null, message);
                }
                retVal = loginObject.getBoolean("isPartyLeader");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return retVal;
    }



    public void playPause(boolean play){
        HashMap<String, String> map = new HashMap<>();
        JSONObject obj;

        if(play){
            map.put("action", "play");
            obj = new JSONObject(map);
        } else{
            map.put("action", "pause");
            obj = new JSONObject(map);
        }

        out.println(obj.toString());
    }
    public void skipsong(){
        HashMap<String, String> map = new HashMap<>();
        JSONObject obj;
        map.put("action","skip");
        obj = new JSONObject(map);
        out.println(obj.toString());

    }

    public void replaysong(){
        HashMap<String, String> map = new HashMap<>();
        JSONObject obj;
        map.put("action","replay");
        obj = new JSONObject(map);
        out.println(obj.toString());

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

