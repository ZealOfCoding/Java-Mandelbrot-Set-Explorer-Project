package ui.TESTING;

import javax.swing.*;
import java.awt.*;

public class TESTINGTextBoxPairs {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Text Box Pairs Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns, 10px gaps

        // Add pairs of text boxes and text fields
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel("This is static text.");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            JTextField rightTextField = new JTextField("TextField " + (i + 1));

            mainPanel.add(label);
            mainPanel.add(rightTextField);
        }

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Set frame visibility
        frame.setVisible(true);
    }
}

