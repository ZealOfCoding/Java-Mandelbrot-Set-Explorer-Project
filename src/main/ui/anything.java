package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;

import model.ConfigurationList;
import model.Event;
import model.EventLog;
import ui.panels.DisplayPanel;
import ui.panels.InterfacePanel;


/*
 * Runs the GUIMandelbrotSetViewerApp. Is used like a mediator between 
 * the various classes. 
 */
public class anything extends JFrame {
    private InterfacePanel ip;
    private DisplayPanel dp;
    private ConfigurationList configList;
    
    private PanelsEventMediator panelsEventMediator;

    public anything() {
        super("Mandelbrot Set Viewer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeElements();
        setDefaults();
        addElements();

        pack();
        setVisible(true);
        addWindowListener(new LogToConsoleEvent());
    }

    private void initializeElements() {

        configList = new ConfigurationList();
        ip = new InterfacePanel();
        dp = new DisplayPanel();
        panelsEventMediator = new PanelsEventMediator(ip.getManualInputsPanel(),
                                                      ip.getMessagesPanel(), 
                                                      ip.getLoadSavePanel(), 
                                                      ip.getConfigurationsPanel(), 
                                                      dp, 
                                                      configList);
        ip.setMediator(panelsEventMediator);
        dp.setMediator(panelsEventMediator);
    }

    private void setDefaults() {
        setResizable(false);
        setBackground(Color.GRAY);
        //dp.requestFocusInWindow();
    }

    private void addElements() {
        add(ip, BorderLayout.WEST);
        add(dp, BorderLayout.CENTER);
    }

    private class LogToConsoleEvent extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("This should have been printed after the program closed!");
            printEventLogToConsole();
            dispose();
        }

        private void printEventLogToConsole() {
            EventLog eventLog = EventLog.getInstance();

            System.out.println("\n\n--------------------------------");
            System.out.println("EVENT LOG:");
            System.out.println("--------------------------------");
            
            for (Event next : eventLog) {
                System.out.println(next.toString());
                System.out.println("\n");
            }

            System.out.println("--------------------------------");
            System.out.println("END OF LOGGED EVENTS");
            System.out.println("--------------------------------");
        }
    }
}
