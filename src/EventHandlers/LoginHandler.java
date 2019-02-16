package EventHandlers;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {
    JButton button;
    String username;
    String password;

    public LoginHandler(JButton button){
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel parentPanel = (JPanel)button.getParent();
        username =
    }
}
