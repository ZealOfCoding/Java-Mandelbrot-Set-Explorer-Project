package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.Configuration;
import model.Renderer;
import ui.PanelsEventMediator;

public class DisplayPanel extends JPanel {

    protected static final int DISPLAY_WIDTH = 800;
    protected static final int DISPLAY_HEIGHT = 800;

    private Renderer renderer;
    private PanelsEventMediator panelsEventMediator;
    private boolean[][] setData;
    private BufferedImage image;

    
    public DisplayPanel() {
        super();
        setDefaults();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyboardEvent());
        addMouseListener(new MouseMotionEvent());

    }

    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
    }

    public int displayWidth() {
        return DISPLAY_WIDTH;
    }

    public int displayHeight() {
        return DISPLAY_HEIGHT;
    }

    /*
     * EFFECTS: sets the default display panel stuff
     */
    private void setDefaults() {
        setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
        setBackground(Color.LIGHT_GRAY);
    }

    public void generate(Configuration config) {
        renderer = new Renderer(config);
        renderer.renderSet();
        setData = renderer.getSet();
        displaySetData();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public void displaySetData() {

        int width = setData.length;
        int height = setData[0].length;
        //Fix the error that is showing up here when the generate button is clicked...
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) { 
            for (int y = 0; y < height; y++) {  
                int color = 0xFFFFFF;
                if (setData[y][x]) {
                    color = 0x000000;
                }
                image.setRGB(x, y, color); 
            } 
        }
        updateUI();

        /*
         * FUTURE IMPROVEMENT: If I want to add color or a gradient to the set, i'll have to add that
         * ability in the Renderer class.
         */
    }

    private class KeyboardEvent implements KeyListener {
        /*
        * EFFECTS: when key down is pressed, it takes the current values from the renderer, 
        * and does a zoom on the image. When key up is pressed, it zooms the image out. 
        */

        // TODO: Figure out why code won't listen to a keyboard event.
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Key typed activated");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //do nothing.
            System.out.println("Key pressed activated");
        }

        @Override
        public void keyReleased(KeyEvent e) {

            /*
             * ask chat GPT how to check panel focus. 
             * request focus on the panel that's adding THIS.
             * add keyboard listenter to entire frame. 
             */
            requestFocusInWindow();
            int keyCode = e.getKeyCode();
            String zoomToggle = "";
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    System.out.println("Key UP pressed!");
                    zoomToggle = "ZOOM_IN";
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Key DOWN pressed!");
                    zoomToggle = "ZOOM_OUT";
                    break;
            }
            calculateZoomFactorConfig(zoomToggle);

        }

        //ask for checkstyle override permission here. Doesn't really make sense 
        //to split this method up any more...
        private void calculateZoomFactorConfig(String zoomToggle) {
            Configuration currentConfig = renderer.getCurrentConfiguration();
            
            double realStart = currentConfig.getRealStart();
            double realEnd = currentConfig.getRealEnd();
            double imagStart = currentConfig.getImagStart();
            double imagEnd = currentConfig.getImagEnd();
            double zoomScale = currentConfig.getZoomScale();

            zoomScale = (zoomToggle == "ZOOM_OUT") ? (1 / zoomScale) : zoomScale;

            double newWidth = (realEnd - realStart) / zoomScale;
            double newHeight = (imagEnd - imagStart) / zoomScale;

            MouseMotionEvent mouseCoords = new MouseMotionEvent();

            double realStartNew = mouseCoords.getX() - newWidth / 2;
            double realEndNew = mouseCoords.getX() + newWidth / 2;
            double imagStartNew = mouseCoords.getY() - newHeight / 2;
            double imagEndNew = mouseCoords.getY() + newHeight / 2;

            Configuration newConfig = new Configuration("", 
                                                        currentConfig.getIteration(),
                                                        0,
                                                        0,
                                                        realStartNew, 
                                                        realEndNew, 
                                                        imagStartNew, 
                                                        imagEndNew, 
                                                        zoomScale);

            generate(newConfig);
        }
    }

    private class MouseMotionEvent extends MouseAdapter {

        private int xcoord;
        private int ycoord;

        @Override
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            xcoord = e.getX();
            ycoord = e.getY();
        }

        public int getX() {
            return xcoord;
        }

        public int getY() {
            return ycoord;
        }

    }

    // something to parse the configlist?
    
    //TODO: add ZoomOnClickHandler
    //TODO: add ZoomOnUpArrowHandler
    //TODO: add ZoomOutDownArrowHandler
}
