package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ManualInputsPanel extends JPanel {
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JPanel row6;
    private JPanel row7;
    private JPanel row8;

    protected JButton generate;//MAKE CENTERED
    protected JButton infoQuestion;//MAKE THIS TINY, stylize to be minimal. Be on the right hand side

    protected JTextField iteration;
    protected JTextField realStart;
    protected JTextField realEnd;
    protected JTextField imagStart;
    protected JTextField imagEnd;

    protected JTextField zoomScale;
    protected JButton setZoom;
    
    public ManualInputsPanel() {
        super();
        initializeElements();
        tempSetBackgroundColorsONLYFORTESTING();
        setDefaults();
        addElementsToRows();
        addRowsToThis();
    }

    /*
     * EFFECTS: initializes all the new elements
     */
    private void initializeElements() {
        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();
        row4 = new JPanel();
        row5 = new JPanel();
        row6 = new JPanel();
        row7 = new JPanel();
        row8 = new JPanel();
    
        generate = new JButton("GENERATE");//TODO: MAKE CENTERED
        infoQuestion = new JButton("?");//TODO: MAKE THIS TINY, stylize to be minimal. Be on the right hand side
    
        iteration = new JTextField("integer");
        realStart = new JTextField("decimal");
        realEnd = new JTextField("decimal");
        imagStart = new JTextField("decimal");
        imagEnd = new JTextField("decimal");

        zoomScale = new JTextField("decimal");
        setZoom = new JButton("SET ZOOM");
    }

    private void tempSetBackgroundColorsONLYFORTESTING() {
        row1.setBackground(Color.PINK);
        row2.setBackground(Color.ORANGE);
        row3.setBackground(Color.BLUE);
        row4.setBackground(Color.BLACK);
        row5.setBackground(Color.WHITE);
        row6.setBackground(Color.GREEN);
        row7.setBackground(Color.MAGENTA);
        row8.setBackground(Color.PINK);

    }

    /*
     * EFFECTS: sets the default configurations for the ManualInputsPanel
     */
    private void setDefaults() {
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(new Dimension(400, 200));

        row1.setPreferredSize(new Dimension(400, 35));
        row2.setPreferredSize(new Dimension(400, 30));
        row3.setPreferredSize(new Dimension(400, 30));
        row4.setPreferredSize(new Dimension(400, 30));
        row5.setPreferredSize(new Dimension(400, 30));
        row6.setPreferredSize(new Dimension(400, 30));
        row7.setPreferredSize(new Dimension(400, 22));
        row8.setPreferredSize(new Dimension(400, 35));
    }

    /*
     * EFFECTS: adds all the new elements
     */
    private void addElementsToRows() {

        //adding elements to each row
        row1.add(generate, BorderLayout.CENTER);
        row1.add(infoQuestion, BorderLayout.CENTER);

        row2.add(new JLabel("Iterations:"));
        row2.add(iteration);

        row3.add(new JLabel("Real Start:"));
        row3.add(realStart);

        row4.add(new JLabel("Real End:"));
        row4.add(realEnd);

        row5.add(new JLabel("Imaginary Start:"));
        row5.add(imagStart);

        row6.add(new JLabel("Imaginary End:"));
        row6.add(imagEnd);

        row7.add(new JLabel("When using mouse to zoom:"), BorderLayout.NORTH);

        row8.add(new JLabel("Zoom Scale:"));
        row8.add(zoomScale);
        row8.add(setZoom, BorderLayout.EAST);

    }
   
    /*
     * EFFECTS: adds the rows to this
     */
    private void addRowsToThis() {
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
        add(row6);
        add(row7);
        add(row8);
    }
    //TODO: add GenerateHandler



}
