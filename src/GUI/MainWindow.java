package GUI;


import EventHandlers.LoginHandler;
import networking.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainWindow {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Client conn;

    /*
     * Construct the window that prompts the user to enter their login credentials
     */
    public MainWindow(){

        mainFrame = new JFrame();
        mainPanel = new JPanel();


        //Create JPanel that contains fields for the user to input their login information
        JPanel loginPanel = new JPanel();
        loginPanel.setSize(new Dimension(1000, 500));

        JLabel usernameLabel = new JLabel("Username");
        JTextField username = new JTextField(30);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField password = new JPasswordField(30);
        password.setEchoChar('*');


        loginPanel.add(usernameLabel);
        loginPanel.add(username);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);


        JButton submit = new JButton("Submit");
        ActionListener loginHandler = new LoginHandler(submit, this);
        submit.addActionListener(loginHandler);

        loginPanel.add(submit);


        mainPanel.add(loginPanel);

        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    /*
     * When the user submits their username and password the conn instance variable will be ins
     */
    public void setupClient(String username, String password){
        conn = new Client(username, password);
    }

    public static void main(String[] args) {
        MainWindow w = new MainWindow();

    }

}
