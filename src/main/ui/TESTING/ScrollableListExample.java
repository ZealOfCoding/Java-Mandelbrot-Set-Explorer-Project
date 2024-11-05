package ui.TESTING;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollableListExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollable List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // List of items
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16"};
        JList<String> itemList = new JList<>(items);
        
        // Enable single selection
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add an action listener for item selection
        itemList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = itemList.getSelectedValue();
                JOptionPane.showMessageDialog(null, "You selected: " + selectedItem);
            }
        });

        // Add the JList to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(itemList);

        // Add the JScrollPane to the frame
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}

