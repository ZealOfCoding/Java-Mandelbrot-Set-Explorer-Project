package ui.panels;

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

    /*
     * EFEFCTS: initializes the loadWorkspace and saveWorkspace buttons.
     */
    private void initializeElements() {
        loadWorkspace = new JButton("Load Saved Workspace");
        saveWorkspace = new JButton("Save Current Workspace");
    }
    
    /*
     * EFEFCTS: sets the defaults for LoadSavePanel
     */
    private void setDefaults() {
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(400, 38));
    }

    /*
     * EFEFCTS: adds event handlers for loadWorkspace and saveWorkspace
     */
    private void addEventHandlers() {
        loadWorkspace.addActionListener(new LoadWorkspaceAction());
        saveWorkspace.addActionListener(new SaveWorkspaceAction());
    }

    /*
     * EFEFCTS: adds the loadWorkspace and saveWorkspace buttons to the panel.
     */
    private void addElements() {
        add(loadWorkspace);
        add(saveWorkspace);
    }

    //reads from the workroom.json file and updates scrollpane in ConfigurationsPanel.
    private class LoadWorkspaceAction extends AbstractAction {
        
        /*
        * EFEFCTS: listens for an event, calls JsonReader, calls it to read the saved configurationList
                   the workroom.json file, and updates the scrollpane in ConfigurationsPanel.
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            JsonReader jsonReader = new JsonReader(JSON_STORE);

            try {
                ConfigurationList thisConfigList = jsonReader.read();
                panelsEventMediator.setConfigList(thisConfigList);
                panelsEventMediator.configurationsPanelSetUpdateConfigButtons();

                String eventMessage = "Loaded workspace from " + JSON_STORE;
                System.out.println(eventMessage);
                panelsEventMediator.messagesPanelUpdate(eventMessage);

            } catch (IOException x) {
                String errorMessage = "Error: Unable to read from file: " + JSON_STORE;
                System.out.println(errorMessage);
                panelsEventMediator.messagesPanelUpdate(errorMessage);
            
            }
        }
    }

    //saves the configurations to workroom.json
    private class SaveWorkspaceAction extends AbstractAction {

        /*
        * EFEFCTS: listens for events, and calls JsonWriter to write the configurations currently in 
                   ConfigurationsList to the workroom.json file.
        */
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
}
