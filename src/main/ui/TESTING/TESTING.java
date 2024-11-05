package ui.TESTING;

import javax.swing.*;
import java.awt.*;

//A test to show how the JPanel could be used as my rendering output from render data.
public class TESTING extends JPanel {
    private final int[][] data;
    private final int windowSize = 750;

    public TESTING(int[][] data) {
        this.data = data;
        // Set the preferred size based on the grid size
        int width = windowSize;
        int height = windowSize;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int x = col * windowSize;
                int y = row * windowSize;
                g.drawRect(x, y, windowSize, windowSize); // Draw cell
                // Optionally fill the cell with a color based on data
                if (data[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, windowSize, windowSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[][] data = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };

        TESTING gridPanel = new TESTING(data);
        frame.add(new JScrollPane(gridPanel)); // Add scroll pane to handle large grids

        frame.pack();
        frame.setVisible(true);
    }
}
