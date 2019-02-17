package EventHandlers;

import GUI.MainWindow;
import networking.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipBackwardHandler implements ActionListener {
    MainWindow window;
    JButton button;
    Client client;

    public SkipBackwardHandler(MainWindow window, JButton button){
        this.window = window;
        this.button = button;
        client = window.getClient();
    }
    public void actionPerformed(ActionEvent e) {
        String option = button.getText();
        if (option == "Pause"){
            button.setText("Play");
            client.playPause(false);
        } else {
            button.setText("Pause");
            client.playPause(true);
        }
    }
}
