package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MessagesPanel extends JPanel {
    private JTextArea messagesBox;
    
    public MessagesPanel() {
        super();
          initializeElements();
          setDefaults();
          addElements();

    }

    private void initializeElements() {
        messagesBox = new JTextArea("System Messages Display Panel");
    }

    private void setDefaults() {
        setBackground(Color.ORANGE);
        setPreferredSize(new Dimension(400, 75));
        messagesBox.setBackground(Color.GRAY);
        messagesBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        messagesBox.setPreferredSize(new Dimension(380, 65));
        messagesBox.setLineWrap(true);
        messagesBox.setEditable(false);
    }

    private void addElements() {
        add(messagesBox, BorderLayout.CENTER);
    }

    private void setMessage(String message) {
        messagesBox.setText(message);
    }

    //some method to update the JLabel text here...


    //TODO: use to catch exceptions, and their error messages, and display them to the user.
}
