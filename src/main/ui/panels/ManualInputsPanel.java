package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import model.Configuration;
import ui.PanelsEventMediator;

/*
 * ManualInputsPanel handles all of the manual input fields for how to render the set. 
 * Also handles a field to set the zoom scale when zooming into the image by keyboard.
 */
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
    protected JButton infoQuestion;
    //MAKE THIS TINY, stylize to be minimal. Be on the right hand side. Make this call a pop up window with info.

    protected JTextField iteration;
    protected JTextField realStart;
    protected JTextField realEnd;
    protected JTextField imagStart;
    protected JTextField imagEnd;

    protected JTextField zoomScale;
    protected JButton setZoom;

    private String currentConfigName;

    private PanelsEventMediator panelsEventMediator;
    
    /*
     * EFFECTS: makes a new ManualInputsPanel object, and initializes several elements.
     */
    public ManualInputsPanel() {
        super();
        initializeElements();
        tempSetBackgroundColorsOnlyForTesting();
        setDefaults();
        addEventHandlers();
        addElementsToRows();
        addRowsToThis();
    }

    /*
     * EFFECTS: sets the mediator object for inter-class communication. 
     */
    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
    }

    /*
     * EFFECTS: initializes each row, that organizes the JPanel into 8 rows, including all the fields, 
     * and a button.
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
    
        iteration = new JTextField("1000");
        realStart = new JTextField("-1.5");
        realEnd = new JTextField("0.5");
        imagStart = new JTextField("-1");
        imagEnd = new JTextField("1");

        zoomScale = new JTextField("10");
        setZoom = new JButton("SET ZOOM");
    }

    //testing purposes only to distinguish each panel from each other visually
    private void tempSetBackgroundColorsOnlyForTesting() {
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

        iteration.setColumns(25);
        realStart.setColumns(25);
        realEnd.setColumns(25);
        imagStart.setColumns(24);
        imagEnd.setColumns(25);
        zoomScale.setColumns(10);
    }

    public void setFieldDefaults() {
        iteration.setText("1000");
        realStart.setText("-1.5");
        realEnd.setText("0.5");
        imagStart.setText("-1");
        imagEnd.setText("1");
        zoomScale.setText("10");
    }
    
    /*
     * EFFECTS: adds event handlers for every button that 
     * generates an event.
     */
    private void addEventHandlers() {
        generate.addActionListener(new GenerateAction());
        infoQuestion.addActionListener(new InfoQuestionAction());
        zoomScale.addActionListener(new UpdateZoomAction());
    }

    /*
     * EFFECTS: adds all the new elements
     */
    private void addElementsToRows() {

        //adding elements to each row
        row1.add(generate, BorderLayout.CENTER);
        row1.add(infoQuestion, BorderLayout.CENTER);

        row2.add(new JLabel("Iterations(Integer):"));
        row2.add(iteration);

        row3.add(new JLabel("Real Start(Decimal):"));
        row3.add(realStart);

        row4.add(new JLabel("Real End(Decimal):"));
        row4.add(realEnd);

        row5.add(new JLabel("Imaginary Start(Decimal):"));
        row5.add(imagStart);

        row6.add(new JLabel("Imaginary End(Decimal):"));
        row6.add(imagEnd);

        row7.add(new JLabel("When using mouse to zoom:"), BorderLayout.NORTH);

        row8.add(new JLabel("Zoom Scale(Decimal):"));
        row8.add(zoomScale);
        row8.add(setZoom, BorderLayout.EAST);
    }
   
    /*
     * EFFECTS: adds the rows to ManualInputsPanel
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

    // The parsing code is repetitive. I can just have one type of parsing method for each data type. 
    //One for integer, one for double.

    /*
     * EFFECTS: parses a string to an integer.
     */
    private int parsedIterationValue(String iteration) {
        int iterationValue = Integer.parseInt(iteration);
        return iterationValue;
    }

    /*
     * EFFECTS: parses a string to a double.
     */
    private double parsedRealStartValue(String realStart) {
        double realStartValue = Double.parseDouble(realStart);
        return realStartValue;
    }

    /*
     * EFFECTS: parses a string to a double.
     */
    private double parsedRealEndValue(String realEnd) {
        double realEndValue = Double.parseDouble(realEnd);
        return realEndValue;
    }

    /*
     * EFFECTS: parses a string to a double.
     */
    private double parsedImagStartValue(String imagStart) {
        double imagStartValue = Double.parseDouble(imagStart);
        return imagStartValue;
    }

    /*
     * EFFECTS: parses a string to a double.
     */
    private double parsedImagEndValue(String imagEnd) {
        double imagEndValue = Double.parseDouble(imagEnd);
        return imagEndValue;
    }

    /*
     * EFFECTS: parses a string to a double.
     */
    private double parsedZoomValue(String zoomScale) {
        double zoomScaleValue = Double.parseDouble(zoomScale);
        return zoomScaleValue;
    }

    /*
     * EFFECTS: makes a new Configuration object from the text values in the JTextFields.
     */
    private Configuration makeConfigurationObject() {
        Configuration newConfig = new Configuration(currentConfigName,
                                                    parsedIterationValue(iteration.getText()), 
                                                    panelsEventMediator.getDisplayWidth(),
                                                    panelsEventMediator.getDisplayHeight(), 
                                                    parsedRealStartValue(realStart.getText()), 
                                                    parsedRealEndValue(realEnd.getText()), 
                                                    parsedImagStartValue(imagStart.getText()), 
                                                    parsedImagEndValue(imagEnd.getText()), 
                                                    parsedZoomValue(zoomScale.getText()));

        return newConfig;
    }

    /*
     * EFFECTS: calls make makeConfigurationObject()
     */
    public Configuration getFields() {
        return makeConfigurationObject();
    }

    /*
     * EFFECTS: sets the fields based on config
     */
    public void setFields(Configuration config) {
        iteration.setText(Integer.toString(config.getIteration()));
        realStart.setText(Double.toString(config.getRealStart()));
        realEnd.setText(Double.toString(config.getRealEnd()));
        imagStart.setText(Double.toString(config.getImagStart()));
        imagEnd.setText(Double.toString(config.getImagEnd()));
        zoomScale.setText(Double.toString(config.getZoomScale()));
        currentConfigName = config.getConfigName();
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                         EVENT HANDLER CLASSES                                         // 
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * EFFECTS: When the "generate" button is clicked, it takes a copy of all the values currently in the JTextFields and
    * sends them to the instance of the Renderer class. 
    */
    private class GenerateAction extends AbstractAction {


        /*
         * EFFECTS: listens for event, and generates an image based on configuration from makeConfigurationObect()
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Configuration tempConfig = makeConfigurationObject();
                panelsEventMediator.messagesPanelUpdate("Rendering...");
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        panelsEventMediator.displayPanelGenerate(tempConfig);
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
                panelsEventMediator.messagesPanelUpdate("An invalid entry was made. Enter numbers only.");
            }
        }
    }



    /*
     * EFFECTS: makes a pop up window that shows some info and instructions about the ManualInputsPanel
     */
    private class InfoQuestionAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "The parameters after the iteration represent the range and domain of the\n"
                             + " set to be generated. They can be thought of as such: \n\n"
                             + "realStart: left bound on the X axis\n"
                             + "realEnd: right bound on the X axis\n"
                             + "imagStart: bottom bound on the Y axis\n"
                             + "imagEnd: upper bound on the Y axis\n";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    /*
     * Updates the zoom scale when zooming by mouse & keyboard.
     */
    private class UpdateZoomAction extends AbstractAction {

        /*
         * EFFECTS: listens for event, and updates the zoom scale used in DisplayPanel
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: update the ZoomScale value in the Renderer to whatever
            //value the zoomScale is.
            double zoomScaleValue = 0;
            System.out.println("Update zoom action called!");
            try {
                zoomScaleValue = parsedZoomValue(zoomScale.getText());
            } catch (NumberFormatException x) {
                panelsEventMediator.messagesPanelUpdate("An invalid zoomScale was entered.");
            }

            panelsEventMediator.displayPanelSetZoom(zoomScaleValue);

            /*
             * TODO: verify that the code is actually zooming into the image...
             * I don't think it is.....
             */
        }
    }

}
