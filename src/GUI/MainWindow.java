package GUI;

import sun.applet.Main;

import javax.swing.*;


import java.awt.*;


public class MainWindow {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private String userID;
    private String passWord;

    public MainWindow(){

        mainFrame = new JFrame();
        mainPanel = new JPanel();


        //Create JPanel that contains fields for the user to input their login information
        JPanel loginPanel = new JPanel();
        loginPanel.setSize(new Dimension(1000, 500));

        JLabel usernameLabel = new JLabel("Username");
        JTextField username = new JTextField(30);
        JLabel passwordLabel = new JLabel("Password");
        JTextField password = new JTextField(30);

        loginPanel.add(usernameLabel);
        loginPanel.add(username);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);


        JButton submit = new JButton("Submit");

        mainPanel.add(loginPanel);

        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    /*
     * When the user submits their username and password capture it in the
     * instance variables
     */
    public void setUserIDAndPassWord(String userID, String passWord){
        this.userID = userID;
        this.passWord = passWord;
    }

    public static void main(String[] args) {
        MainWindow w = new MainWindow();

    }

}
