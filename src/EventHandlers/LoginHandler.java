package EventHandlers;

import GUI.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {
    //button stores a reference to the submit button in the login pane
    //window stores a reference to the MainWindow object that manages the user's end
    private JButton button;
    private MainWindow window;

    public LoginHandler(JButton button, MainWindow window){
        this.button = button;
        this.window = window;
    }

    /*
     * When the user enters their login information, the data will be captured to create
     * a Client Object managed by the main window.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel parentPanel = (JPanel)button.getParent();
        JTextField userField = (JTextField)parentPanel.getComponent(1);
        JTextField passField = (JTextField)parentPanel.getComponent(3);

        String username = userField.getText();
        String password = passField.getText();

        window.setupClient(username, password);

    }
}
