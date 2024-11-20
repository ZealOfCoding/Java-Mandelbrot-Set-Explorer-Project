package ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.util.ArrayList;

import model.Configuration;
import model.ConfigurationList;
import ui.PanelsEventMediator;

public class ConfigurationsPanel extends JPanel {

    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    
    private JScrollPane configurationListScrollPane;
    private JPanel configButtonListPanel;
    private ArrayList<JButton> buttonsList;

    private JLabel configNameLabel;
    private JTextField configName;
    private JButton deleteConfiguration;
    private JButton addConfiguration;

    private PanelsEventMediator panelsEventMediator;

    public ConfigurationsPanel() {
        super();
        initializeElements();
        setDefaults();
        addElements();
    }

    /*
     * EFFECTS: sets the mediator object for inter-class communication. 
     */
    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
    }

    private void initializeElements() {

        //panels to organize elements
        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();

        configurationListScrollPane = new JScrollPane(initializeConfigurationListScrollPane());
        configurationListScrollPane.setPreferredSize(new Dimension(380, 285));
        buttonsList = new ArrayList<>();

        //Config label prompt and txtbox
        configNameLabel = new JLabel("Enter Configuration Name:");
        configName = new JTextField("configuration name...");

        //delete and save buttons
        deleteConfiguration = new JButton("Delete Configuration");
        addConfiguration = new JButton("Add Configuration");

        //add action listeners for delete and save buttons
        deleteConfiguration.addActionListener(new DeleteConfigurationAction());
        addConfiguration.addActionListener(new AddConfigurationAction());

    }

    private JPanel initializeConfigurationListScrollPane() {
        configButtonListPanel = new JPanel();
    
        //default button will always show up and generate default configuration
        //TODO: make this a better name...
        JButton jbuttonTest = new JButton("--------------- Default ---------------");

        jbuttonTest.addActionListener(new DefaultButtonAction());
        jbuttonTest.setAlignmentX(Component.LEFT_ALIGNMENT);
        jbuttonTest.setMaximumSize(new Dimension(Integer.MAX_VALUE, jbuttonTest.getMinimumSize().height));
        
        configButtonListPanel.add(jbuttonTest);

        return configButtonListPanel;
    }
    
    private void setDefaults() {
        setBackground(Color.PINK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(new Dimension(400, 500));

        configButtonListPanel.setLayout(new BoxLayout(configButtonListPanel, BoxLayout.Y_AXIS));

        row1.setBackground(Color.RED);
        row1.setPreferredSize(new Dimension(400, 300));
        row2.setBackground(Color.YELLOW);
        row2.setPreferredSize(new Dimension(400, 80));
        row3.setBackground(Color.GREEN);
        row3.setPreferredSize(new Dimension(400, 40));

        configName.setPreferredSize(new Dimension(350, 30));
    }

    private void addElements() {

        row1.add(configurationListScrollPane);

        row2.add(configNameLabel);
        row2.add(configName);

        row3.add(deleteConfiguration);
        row3.add(addConfiguration);

        add(row1);
        add(row2);
        add(row3);
    }

    
    public void loadButtonsFromConfigList() {
        /*
        * 0. Remove all previous buttons from config buttons list.
        * 1. get configList
        * 2. Iterate through each config in list
        * 3. get JUST the name of the config
        * 4. add a new button that has that config name on it to the JScrollPane
        */

        //remove any old buttons in the list
        //BUG: save isn't working properly...
        //I click to save the configurations, but when I go to load, 
        // it doesn't load all the previously loaded configs. 
        //check the JSON file.....
        for (int i = 0; i < buttonsList.size(); i++) {
            JButton currentButton = buttonsList.get(i);
            removeConfigButtonFromConfigButtonAndConfigurationsList(currentButton);
        }
        
        //add new buttons from the saved Json file
        String[] configListNames = panelsEventMediator.getConfigList().getConfigNames();
        for (String configName : configListNames) {
            addButtonToConfigButtonAndConfigurationsList(configName);
        }
    }
    
    
    private void addButtonToConfigButtonAndConfigurationsList(String configName) {
        JButton newJScrollPaneButton = new JButton(configName);
        newJScrollPaneButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Dimension temp = new Dimension(Integer.MAX_VALUE, newJScrollPaneButton.getMinimumSize().height);
        newJScrollPaneButton.setMaximumSize(temp);
        newJScrollPaneButton.addActionListener(new ConfigurationButtonAction());
        
        buttonsList.add(newJScrollPaneButton);
        configButtonListPanel.add(newJScrollPaneButton);
        configButtonListPanel.revalidate();
        configButtonListPanel.repaint();
    }
    
    private void removeConfigButtonFromConfigButtonAndConfigurationsList(JButton button) {
        String buttonText = button.getText();

        configButtonListPanel.remove(button);
        buttonsList.remove(button);
        panelsEventMediator.removeConfigurationFromConfigurationList(buttonText);
        configButtonListPanel.revalidate();
        configButtonListPanel.repaint();
    }

    private class AddConfigurationAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            addConfiguration();
        }

        private void addConfiguration() {
            /*
             * Adding a button steps:
             * - read data from fields in ManualInputsPanel. Make a call to PanelsEventMediator for
             *   a request in a method from ManualInputsPanel that creates and sends a Configuration object.
             * 
             * - read string from "configName" field. 
             * - add/change fields like the configurationName to "configName" in the passed Configuration.
             * 
             * - make a request to ManualInputsPanel for getConfigList(). 
             * - add the new Configuration to the ConfigurationList.
             * 
             * - make a new button with the name, add it to the buttonsList.
             * 
             * Something to do later:
             * ***** ADD an exception handler. This should throw an exception for when the 
             *       the class is unable to add a configuration due to improper format. Could 
             *       the exception handling already existent in ManualInputsPanel... Try to model it.
             * ***************************************************************************************
             */

            try {

                if (!configName.getText().isEmpty()) {
    
                    Configuration configTemp = panelsEventMediator.manualInputsPanelGetConfiguration();
                    configTemp.setConfigName(configName.getText());
    
                    // System.out.println("____________________Configuration data with updated configName:_________");
                    // System.out.println(configTemp.getConfigName());
                    // System.out.println(configTemp.getIteration());
                    // System.out.println(configTemp.getRenderHeight());
                    // System.out.println(configTemp.getRenderWidth());
                    // System.out.println(configTemp.getRealStart());
                    // System.out.println(configTemp.getRealEnd());
                    // System.out.println(configTemp.getImagStart());
                    // System.out.println(configTemp.getImagEnd());
                    // System.out.println(configTemp.getZoomScale());
                    // System.out.println("___________________________________________________________________");
        
                    addButtonToConfigButtonAndConfigurationsList(configName.getText());

                    panelsEventMediator.addConfigurationToConfigurationList(configTemp);
                    configName.setText("");

                } else {
                    panelsEventMediator.messagesPanelUpdate("Error: Configuration name field is blank."
                                                            + " \nEnter a name for the configuration.");
                }

            } catch (NumberFormatException e) {
                panelsEventMediator.messagesPanelUpdate("Error: one or multiple fields don't have a proper value. "
                                                        + "Make sure to enter specified number types into each field.");
            }
        }
    }

    private class DeleteConfigurationAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteConfigurationByName();
        }

        private void deleteConfigurationByName() {
            String buttonText = configName.getText();

            if (!buttonText.isEmpty()) {

                for (JButton button : buttonsList) {

                    if (button.getText().equals(buttonText)) {

                        removeConfigButtonFromConfigButtonAndConfigurationsList(button);
                        configName.setText("");
                        break;
                    }
                }

            } else {
                panelsEventMediator.messagesPanelUpdate("Error: Configuration name field is blank."
                                                        + " \nEnter the name of configuration to delete.");
            }
        }
    }

    private class ConfigurationButtonAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            /* 
             * load a configuration from the button press. 
             * 
             * using panelsEventMediator, call a method in it, passing the configuration 
             * of data from a button to the ManualInputsPanel.
             * 
             * In ManualInputsPanel, have a method set the JTextFields to the configuration.
             * 
            */
            JButton buttonSource = (JButton) e.getSource();
            String buttonText = buttonSource.getText();
            loadConfigurationIntoManualInputPanelFields(buttonText);
        }

        private void loadConfigurationIntoManualInputPanelFields(String buttonText) {

            try {
                //need to get the name of the selected button...
                Configuration config = panelsEventMediator.getConfigurationFromConfigurationList(buttonText);
                panelsEventMediator.manualInputsPanelSetFields(config);

            } catch (NullPointerException e) {
                panelsEventMediator.messagesPanelUpdate("Shouldn't need to catch null pointer exception...");
            }
        }
    }

    private class DefaultButtonAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonSource = (JButton) e.getSource();
            String buttonText = buttonSource.getText();

            panelsEventMediator.manualInputsPanelSetFieldDefaults();
        }

    }

    //TODO: add new config button, take in name parameter, current config values in ManualInputsPanel

    //TODO: add click config to load a config in ManualInputsPanel
    //TODO: add a delete selected button config 
}
