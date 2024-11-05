package ui;

import java.awt.BorderLayout;

import javax.swing.*;

import ui.panels.DisplayPanel;
import ui.panels.InterfacePanel;

//consider extending JFrame... saves some code, and gives the feel that
// the JFrame code is sort of already integrated into my App class here.
public class GUIMandelbrotSetViewerApp extends JFrame {
    private InterfacePanel ip;
    private DisplayPanel dp;

    public GUIMandelbrotSetViewerApp() {
        super("Mandelbrot Set Viewer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(ip, BorderLayout.EAST);
        add(dp, BorderLayout.CENTER);
        pack();
        setVisible(true);

    }

    // private void runGUIMandelbrotSetViewerApp() {


    //     JFrame frame = new JFrame("Mandelbrot Set Viewer App");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(900,900);

    //     JPanel panel = new JPanel();
    //     frame.add(panel);
        
    //     frame.setVisible(true);

    //     panel.setLayout(null);

    //     JLabel label = new JLabel("Hello world!");

    //     label.setBounds(10, 20, 80, 25);
    //     panel.add(label);

    //     JButton button = new JButton("Click Me");
    //     button.setBounds(10, 50, 150, 25);
    //     panel.add(button);

    //     button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Button Clicked!"));
    // }
}
