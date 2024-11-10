package ui;

import java.awt.BorderLayout;
import java.awt.Color;

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
        ip = new InterfacePanel();
        dp = new DisplayPanel();

        setDefaults();

        pack();
        setVisible(true);

    }

    private void setDefaults() {
        add(ip, BorderLayout.WEST);
        add(dp, BorderLayout.CENTER);
        setResizable(false);;
        setBackground(Color.RED);
    }
}
