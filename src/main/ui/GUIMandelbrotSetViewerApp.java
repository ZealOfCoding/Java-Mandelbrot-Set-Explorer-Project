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
public class GUIMandelbrotSetViewerApp extends JFrame {
    private InterfacePanel ip;
    private DisplayPanel dp;
    private ConfigurationList configList;
    
    private PanelsEventMediator panelsEventMediator;

    public GUIMandelbrotSetViewerApp() {
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
        dp.requestFocusInWindow();
    }

    private void addElements() {
        add(ip, BorderLayout.WEST);
        add(dp, BorderLayout.CENTER);
    }

    //try adding keyboard listener here.

    //THOUGHT: Perhaps all my Event Handlers should go in this class? 

    /*
     * SOLUTION: use the mediator pattern. Have an interface represent 
     * represent common actions that need to be done across various classes.
     * 
     */

     //add an AppEventsHandler class, to serve as a mediator.





    //             Debugging stuff for keyboard event listener...
    /////////////////////////////////////////////////////////////////////
    // private class KeyboardEvent implements KeyListener {
    //     /*
    //     * EFFECTS: when key down is pressed, it takes the current values from the renderer, 
    //     * and does a zoom on the image. When key up is pressed, it zooms the image out. 
    //     */

    //     // TODO: Figure out why code won't listen to a keyboard event.
    //     @Override
    //     public void keyTyped(KeyEvent e) {
    //         System.out.println("Key typed activated");
    //     }

    //     @Override
    //     public void keyPressed(KeyEvent e) {
    //         //do nothing.
    //         System.out.println("Key pressed activated");
    //     }

    //     @Override
    //     public void keyReleased(KeyEvent e) {

    //         /*
    //          * ask chat GPT how to check panel focus. 
    //          * request focus on the panel that's adding THIS.
    //          * add keyboard listenter to entire frame. 
    //          */
    //         requestFocusInWindow();
    //         int keyCode = e.getKeyCode();
    //         String zoomToggle = "";
    //         switch (keyCode) {
    //             case KeyEvent.VK_UP:
    //                 System.out.println("Key UP pressed!");
    //                 zoomToggle = "ZOOM_IN";
    //                 break;
    //             case KeyEvent.VK_DOWN:
    //                 System.out.println("Key DOWN pressed!");
    //                 zoomToggle = "ZOOM_OUT";
    //                 break;
    //         }


    //     }
    // }
}
