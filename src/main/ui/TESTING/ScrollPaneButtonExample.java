package ui.TESTING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollPaneButtonExample {
    private static JPanel buttonPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ScrollPane Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(buttonPanel);

        JButton addButton = new JButton("Add Button");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton();
            }
        });

        JButton removeButton = new JButton("Remove Button");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeButton();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(addButton);
        controlPanel.add(removeButton);

        frame.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addButton() {
        JButton button = new JButton("Button " + (buttonPanel.getComponentCount() + 1));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        buttonPanel.add(button);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private static void removeButton() {
        if (buttonPanel.getComponentCount() > 0) {
            buttonPanel.remove(buttonPanel.getComponentCount() - 1);
            buttonPanel.revalidate();
            buttonPanel.repaint();
        }
    }
}
