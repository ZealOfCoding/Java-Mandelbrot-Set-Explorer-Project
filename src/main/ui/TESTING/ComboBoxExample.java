package ui.TESTING;

import javax.swing.*;
import java.awt.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JComboBox with the predefined values
        Integer[] values = {2, 4, 8, 16, 32};
        JComboBox<Integer> comboBox = new JComboBox<>(values);

        // Add the JComboBox to the frame
        frame.setLayout(new FlowLayout());
        frame.add(comboBox);
        frame.setVisible(true);
    }
}

