package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import model.ConfigurationList;
import ui.panels.DisplayPanel;
import ui.panels.InterfacePanel;

//TODO: remember to delete this later!!!!
import java.awt.event.KeyEvent;

/*
 * Runs the GUIMandelbrotSetViewerApp. Is used like a mediator between 
 * the various classes. 
 */
public class GuiMandelbrotSetViewerApp extends JFrame {
    private InterfacePanel ip;
    private DisplayPanel dp;
    private ConfigurationList configList;
    
    private PanelsEventMediator panelsEventMediator;

    public GuiMandelbrotSetViewerApp() {
        super("Mandelbrot Set Viewer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeElements();
        setDefaults();
        addElements();

        pack();
        setVisible(true);
        //addKeyListener(new KeyboardEvent());
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
}
