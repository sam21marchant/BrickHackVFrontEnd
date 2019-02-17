package EventHandlers;

import GUI.MainWindow;
import networking.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipForwardHandler implements ActionListener {
    MainWindow window;
    JButton button;
    Client client;

    public SkipForwardHandler(MainWindow window, JButton button){
        this.window = window;
        this.button = button;
        client = window.getClient();
    }
    public void actionPerformed(ActionEvent e) {
        client.skipsong();
    }
}
