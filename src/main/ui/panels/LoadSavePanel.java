package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class LoadSavePanel extends JPanel {
    
    private JButton loadWorkspace;
    private JButton saveWorkspace;

    public LoadSavePanel() {
        super();
        initializeElements();
        setDefaults();
        addElements();
    }

    private void initializeElements() {
        loadWorkspace = new JButton("Load Saved Workspace");
        saveWorkspace = new JButton("Save Current Workspace");
    }
    
    private void setDefaults() {
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(400, 38));
    }

    private void addElements() {
        add(loadWorkspace);
        add(saveWorkspace);
    }

    //TODO: add LoadingHandler
    //TODO: add SavingHandler
}
