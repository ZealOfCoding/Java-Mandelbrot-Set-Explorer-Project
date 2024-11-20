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

public class LoadSavePanel extends JPanel {
    
    private static final String JSON_STORE = "./data/workroom.json";
    private JButton loadWorkspace;
    private JButton saveWorkspace;
    private PanelsEventMediator panelsEventMediator;
    public LoadSavePanel() {
        super();
        initializeElements();
        setDefaults();
        addEventHandlers();
        addElements();
    }

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

    private class LoadWorkspaceAction extends AbstractAction {
        JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                jsonWriter.open();
                jsonWriter.write(panelsEventMediator.getConfigList());
                jsonWriter.close();

                panelsEventMediator.configurationsPanelSetUpdateConfigButtons();

                System.out.println("Loaded workspace from " + JSON_STORE);
                panelsEventMediator.messagesPanelUpdate("Loaded workspace from " + JSON_STORE);

                /*
                 * TO DO: call ConfigurationsPanel, and make a method there that 
                 * looks through all configurations that have now been added to the 
                 * configurationList, and add a button for each config.
                 */
            } catch (FileNotFoundException x) {

                System.out.println("Unable to read from file: " + JSON_STORE);
                panelsEventMediator.messagesPanelUpdate("Unable to read from file: " + JSON_STORE);
            
            }
        }
    }

    private class SaveWorkspaceAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
        JsonReader jsonReader = new JsonReader(JSON_STORE);
        ConfigurationList configListPointer = panelsEventMediator.getConfigList();
            try {

                configListPointer = jsonReader.read();
                System.out.println("Saved current workspace configurations to " + JSON_STORE);
                panelsEventMediator.messagesPanelUpdate("Saved current workspace configurations to " + JSON_STORE);

            } catch (IOException x) {

                System.out.println("Unable to write to file: " + JSON_STORE);
                panelsEventMediator.messagesPanelUpdate("Unable to write to file: " + JSON_STORE);

            }
        }
    }

    //TODO: add LoadingHandler...
    //TODO: add SavingHandler
}
