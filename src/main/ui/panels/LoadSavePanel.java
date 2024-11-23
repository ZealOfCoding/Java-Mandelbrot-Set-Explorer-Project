package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import model.ConfigurationList;
import persistance.JsonReader;
import persistance.JsonWriter;
import ui.PanelsEventMediator;

/*
 * LoadSavePanel handles the loading and saving of the workspace, or the list of confgurations 
 * in the program locally to the computer. 
 */
public class LoadSavePanel extends JPanel {
    
    private static final String JSON_STORE = "./data/workroom.json";
    private JButton loadWorkspace;
    private JButton saveWorkspace;
    private PanelsEventMediator panelsEventMediator;
    
    /*
     * calls initializing and adding methods. 
     */
    public LoadSavePanel() {
        super();
        initializeElements();
        setDefaults();
        addEventHandlers();
        addElements();
    }

    /*
     * EFFECTS: sets the mediator object for inter-class communication. 
     */
    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
    }

    private void initializeElements() {
        loadWorkspace = new JButton("Load Saved Workspace");
        saveWorkspace = new JButton("Save Current Workspace");
    }
    
    private void setDefaults() {
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(400, 38));
    }

    private void addEventHandlers() {
        loadWorkspace.addActionListener(new LoadWorkspaceAction());
        saveWorkspace.addActionListener(new SaveWorkspaceAction());
    }

    private void addElements() {
        add(loadWorkspace);
        add(saveWorkspace);
    }

    //reads from the workroom.json file.
    private class LoadWorkspaceAction extends AbstractAction {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JsonReader jsonReader = new JsonReader(JSON_STORE);
            try {
                /*
                 * How to load the workspace from the workroom.json file:
                 * 
                 * - get the ConfigurationList from the jsonReader.read() method
                 * - 
                 */

                ConfigurationList thisConfigList = jsonReader.read();
                panelsEventMediator.setConfigList(thisConfigList);
                ConfigurationList tempDebugCheck = panelsEventMediator.getConfigList();
                panelsEventMediator.configurationsPanelSetUpdateConfigButtons();

                String eventMessage = "Loaded workspace from " + JSON_STORE;
                System.out.println(eventMessage);
                panelsEventMediator.messagesPanelUpdate(eventMessage);

                /*
                 * TO DO: call ConfigurationsPanel, and make a method there that 
                 * looks through all configurations that have now been added to the 
                 * configurationList, and add a button for each config.
                 */
            } catch (IOException x) {
                String errorMessage = "Error: Unable to read from file: " + JSON_STORE;
                System.out.println(errorMessage);
                panelsEventMediator.messagesPanelUpdate(errorMessage);
            
            }
        }
    }

    private class SaveWorkspaceAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
                jsonWriter.open();
                jsonWriter.write(panelsEventMediator.getConfigList());
                jsonWriter.close();

                System.out.println("Saved current workspace configurations to " + JSON_STORE);
                panelsEventMediator.messagesPanelUpdate("Saved current workspace configurations to " + JSON_STORE);

            } catch (FileNotFoundException x) {
                String errorMessage = "Unable to write to file: " + JSON_STORE;
                System.out.println(errorMessage);
                panelsEventMediator.messagesPanelUpdate(errorMessage);

            }
        }
    }

    //TODO: add LoadingHandler...
    //TODO: add SavingHandler
}
