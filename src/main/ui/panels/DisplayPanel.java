package ui.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
    
    public DisplayPanel() {
        super();
        //initializeElements();
        setDefaults();
        //addElementsTo...();
    }

    /*
     * EFFECTS: sets the default display panel stuff
     */
    private void setDefaults() {
        setPreferredSize(new Dimension(800, 800));

        setBackground(Color.GRAY);
    }
    
    //TODO: add ZoomOnClickHandler
    //TODO: add ZoomOnUpArrowHandler
    //TODO: add ZoomOutDownArrowHandler
}
