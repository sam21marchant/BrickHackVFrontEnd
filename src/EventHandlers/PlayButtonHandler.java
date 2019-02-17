package EventHandlers;

import GUI.MainWindow;
import networking.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonHandler implements ActionListener {
    MainWindow window;
    JButton button;
    Client client;


    public PlayButtonHandler(MainWindow window, JButton button){
        this.window = window;
        this.button = button;
        client = window.getClient();
    }

    @Override
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
