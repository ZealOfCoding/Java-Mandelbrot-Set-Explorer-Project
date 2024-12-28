package ui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.event.*;

import model.Configuration;
import model.Renderer;
import ui.PanelsEventMediator;

/*
 * DisplayPanel is the main panel that displays the rendered image of the Mandelbrot Set.
 */
public class DisplayPanel extends JPanel {

    protected static final int DISPLAY_WIDTH = 800;
    protected static final int DISPLAY_HEIGHT = 800;

    private double zoomScale;

    private Renderer renderer;
    private PanelsEventMediator panelsEventMediator;
    private int[][] setData;
    private BufferedImage image;

    private MouseMotionEvent mouseCoords;

    /*
     * EFFECTS: sets defaults, adds listeners for the keyboard event, mouse entering & exiting 
     * the panel. 
     */
    public DisplayPanel() {
        super();
        setDefaults();
        setFocusable(true);

        addKeyListener(new KeyboardEvent(zoomScale));

        requestFocusInWindow();

        //allows the DisplayPanel to have focus when the mouse is in the DisplayPanel, and loose it when
        //the mouse is outside the DisplayPanel. 
        addMouseListener(new MouseInPanelEvent());

        mouseCoords = new MouseMotionEvent();
        addMouseMotionListener(mouseCoords);
    }

    /*
     * EFFECTS: sets the mediator object for inter-class communication. 
     */
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
        zoomScale = 10;
    }

    // public void setZoom(double zoomScale) {
    //     this.zoomScale = zoomScale;
    //     System.out.println("The zoom was set in DisplayPanel!!!!");
    // }

    /* REQUIRES: a valid Configuration object. 
     * EFFECTS: takes a configuration, and asks the render to generate the set, and calls displayData() to 
     *          display the image to the panel.
     */
    public void generate(Configuration config) {
        renderer = new Renderer(config);
        renderer.renderSet();
        setData = renderer.getSet();
        displaySetData();
    }

    /*
     * EFFECTS: overrride to update the panel. 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    /*
     * EFFECTS: takes the setData(), and iterates through each pixel boolean value. If true, it paints the 
     * current pixel black. If false, it paints the pixel white. 
     * 
     * Updates the UI to render it. 
     */
    public void displaySetData() {

        int width = setData.length;
        int height = setData[0].length;
        //Fix the error that is showing up here when the generate button is clicked...
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) { 
            for (int y = 0; y < height; y++) {  
                image.setRGB(x, y, setData[y][x]); 
            } 
        }
        updateUI();

        /*
         * FUTURE IMPROVEMENT: If I want to add color or a gradient to the set, i'll have to add that
         * ability in the Renderer class.
         */
    }

    /*
     * Handles keyboard up and down arrow events. 
     * 
     * Listens for the keyboard up and down arrow. 
     * 
     * When the key up arrow is pressed, the zoomToggle is set to true, and it's passed to the renderAction() method. 
     * When the key down arrow is pressed, zoomToggle is set to false, and passed to renderAction() method.
     * 
     * In other words, when key down is pressed, it takes the current values from the renderer, 
     * and does a zoom on the image. When key up is pressed, it zooms the image out. 
     */
    private class KeyboardEvent implements KeyListener {
 
        private double zoomScale;

        /*
         * EFEFCTS: sets the zoomScale value.
         */
        public KeyboardEvent(double zoomScale) {
            this.zoomScale = zoomScale;
        }
        
        //redundant, possible future use case
        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Key pressed activated");
        }
        
        //redundant, possible future use case
        @Override
        public void keyTyped(KeyEvent e) {
            //System.out.println("Key typed activated");
        }
        
        /*
         * EFFECTS: if the up key is pressed, calls and passed renderAction("ZOOM_IN")
         *          if down key is pressed, calls and passes renderAction("ZOOM_OUT")
         */
        @Override
        public void keyReleased(KeyEvent e) {
            
            System.out.println("Key released activated");
            
            

            int keyCode = e.getKeyCode();
            String zoomToggle = "";
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    //TODO: comment out this print statement about the key up press
                    //System.out.println("Key UP pressed!");
                    zoomToggle = "ZOOM_IN";
                    renderAction(zoomToggle);
                    break;
                case KeyEvent.VK_DOWN:
                    //TODO: comment out this print statement about the key down press
                    //System.out.println("Key DOWN pressed!");
                    zoomToggle = "ZOOM_OUT";
                    renderAction(zoomToggle);
                    break;
            }
            
            /*
            * SOMETHING TO DO: make a threaded application here, where it runs, 
            * and it updates the display panel to display "rendering...", just 
            * like the execution with the generate button...
            */
        }
        
        /*
         * EFFECTS: 
         * calls calculatecalculateZoomFactorConfig(zoomToggle) that generates a zoomed in configuration.
         * Then makes a RenderFromKeyAndMouseAction() object, passing the newConfig, and calls it's action. 
         */
        private void renderAction(String zoomToggle) {
            Configuration newConfig = calculateZoomFactorConfig(zoomToggle);
            RenderFromKeyAndMouseAction newAction = new RenderFromKeyAndMouseAction(newConfig);
            newAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            panelsEventMediator.manualInputsPanelSetFields(newConfig);
        }
        
        /*
         * EFFECTS: calculates the zoomed configuration and returns the Configuration object. 
         */
        @SuppressWarnings("methodlength")
        private Configuration calculateZoomFactorConfig(String zoomToggle) {
            /*TODO: have a case handle the NullPointerException, and give error message saying 
               that you need to render something before using the keyboard zoom.
            */
            Configuration currentConfig = renderer.getCurrentConfiguration();
            
            double realStart = currentConfig.getRealStart();
            double realEnd = currentConfig.getRealEnd();
            double imagStart = currentConfig.getImagStart();
            double imagEnd = currentConfig.getImagEnd();
            double zoomScaleLocal = panelsEventMediator.manualInputsPanelGetConfiguration().getZoomScale();
            
            if (zoomToggle == "ZOOM_OUT") {//could it be this that's causing issues?
                zoomScaleLocal = 1 / zoomScaleLocal;
            }
            double newWidth = (realEnd - realStart) / zoomScaleLocal;
            double newHeight = (imagEnd - imagStart) / zoomScaleLocal;
            
            double realMouse = realStart + (realEnd - realStart) * mouseCoords.getX() / currentConfig.getRenderWidth();
            double imagMouse = imagStart + (imagEnd - imagStart) * mouseCoords.getY() / currentConfig.getRenderHeight();

            System.out.println("MOUSE COORDINATES MUST HAVE BEEN READ");
            double realStartNew = realMouse - (newWidth / 2);
            double realEndNew = realMouse + (newWidth / 2);
            double imagStartNew = imagMouse - (newHeight / 2);
            double imagEndNew = imagMouse + (newHeight / 2);
            
            Configuration newConfig = new Configuration("", 
                                                        currentConfig.getIteration(),
                                                        panelsEventMediator.getDisplayWidth(),
                                                        panelsEventMediator.getDisplayHeight(),
                                                        realStartNew, 
                                                        realEndNew, 
                                                        imagStartNew, 
                                                        imagEndNew, 
                                                        zoomScale);

            return newConfig;
        }
    }
    
    /*
     * Listens for mouse movements, and can return the mouse's X and Y coordinates at request. 
     */
    private class MouseMotionEvent extends MouseMotionAdapter {
        
        private int xcoord;
        private int ycoord;
        
        /*
         * EFFECTS: listens for mouse movements, and updates the xcoord and ycoord 
         *  to what the coordinates of the mouse are.
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            // System.out.println("MOUSE MOVED");
            xcoord = e.getX();
            ycoord = e.getY();
            // System.out.println("MOUSE X CORD: " + xcoord);
            // System.out.println("MOUSE Y CORD: " + ycoord);
        }
        

        public int getX() {
            return xcoord;
        }
        
        public int getY() {
            return ycoord;
        }
    }
    
    /*
     * Action takes in a Configuration, and then renders it asynchronously with a SwingWorker. 
     */
    private class RenderFromKeyAndMouseAction extends AbstractAction {
        private Configuration newConfig;
        
        //EFFECTS: takes in a Configuration object.
        public RenderFromKeyAndMouseAction(Configuration newConfig) {
            this.newConfig = newConfig;
        }

        /*
         * EFEFCTS: listens for event, and renders the image using a worker that runs on a different thread,
         *  using newConfig.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                panelsEventMediator.messagesPanelUpdate("Rendering...");
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        generate(newConfig);
                        return null;
                    }
                    
                    @Override
                    protected void done() {
                        panelsEventMediator.messagesPanelUpdate("Render completed.");
                    }
                };
                worker.execute();
                /*TODO: FUTURE IMPROVEMENT: Add a "generating" animation to the messages panel. Would probably need 
                 * threads to handle that...
                */
            } catch (NumberFormatException x) {
                panelsEventMediator.messagesPanelUpdate("Error: NumberFormatException thrown...");
            }
        }
    }

    /*
    * Action used to set the focus on the DisplayPanel ONLY when the mouse is in the area of the DisplayPanel.
    * When mouse moves out of the panel, focus returns to main panel.
     * 
     */
    private class MouseInPanelEvent extends MouseAdapter {
        
        // EFEFCTS: explicitly calls focus on the DisplayPanel.
        @Override
        public void mouseEntered(MouseEvent e) {
            requestFocusInWindow();
            // System.out.println("DisplayPanel GAINED FOCUS");
        }

        // EFFECTS: returns focus to main panel when the mouse moves out of the DisplayPanel
        @Override
        public void mouseExited(MouseEvent e) {
            getRootPane().requestFocusInWindow();
            // System.out.println("DisplayPanel LOST FOCUS");
        }
    }
}
