package GUI;


import EventHandlers.LoginHandler;
import EventHandlers.PlayButtonHandler;
import networking.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainWindow {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Client conn;
    private boolean isPartyLeader;

    /*
     * Construct the window that prompts the user to enter their login credentials
     */
    public MainWindow(){
        isPartyLeader = false;

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
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * When the user submits their username and password the conn instance variable will be ins
     */
    public void setupClient(String username, String password){
        conn = new Client(username, password);
        isPartyLeader = conn.sendLogin();
        mainPanel.remove(0);
        mainPanel.updateUI();
        if(isPartyLeader){
            setUpHostUI();
        } else{
            mainPanel.add(new JLabel("YOU ARE NOT THE HOST"));
        }
        mainPanel.updateUI();
    }


    /*
     * Set up the hosts UI so that they will se the controls available to them such as play, pause, next, prev, etc.
     */
    private void setUpHostUI(){
        JPanel controlPanel = new JPanel();
        controlPanel.setSize(new Dimension(500, 500));

        JButton playPause = new JButton("Play");
        playPause.addActionListener(new PlayButtonHandler(this, playPause));

        JButton skip = new JButton("Skip");
        skip.addActionListener(new PlayButtonHandler(this, skip));

        JButton replay = new JButton("Replay");
        replay.addActionListener(new PlayButtonHandler(this, replay));

        controlPanel.add(replay);
        controlPanel.add(playPause);
        controlPanel.add(skip);

        mainPanel.add(controlPanel);
    }




    public static void main(String[] args) {
        MainWindow w = new MainWindow();
    }


    public Client getClient() {
        return conn;
    }
}
