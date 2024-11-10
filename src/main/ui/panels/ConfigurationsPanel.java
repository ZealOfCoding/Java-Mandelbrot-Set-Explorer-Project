package ui.panels;

import java.awt.*;

import javax.swing.*;

public class ConfigurationsPanel extends JPanel {

    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    
    private JScrollPane configurationListScrollPane;
    private JPanel configButtonListPanel;

    private JLabel configNameLabel;
    private JTextField configName;
    private JButton deleteConfiguration;
    private JButton saveConfiguration;

    public ConfigurationsPanel() {
        super();
        initializeElements();
        setDefaults();
        addElements();
    }

    private void initializeElements() {

        //panels to organize elements
        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();

        configurationListScrollPane = new JScrollPane(initializeConfigurationListScrollPane());
        configurationListScrollPane.setPreferredSize(new Dimension(380, 285));

        //Config label prompt and txtbox
        configNameLabel = new JLabel("Enter Configuration Name:");
        configName = new JTextField("configuration name...");

        //delete and save buttons
        deleteConfiguration = new JButton("Delete Configuration");
        saveConfiguration = new JButton("Save Configuration");

    }

    private JPanel initializeConfigurationListScrollPane() {
        configButtonListPanel = new JPanel();
    
        //default button will always show up and generate default configuration
        JButton jButtonTest = new JButton("Default");
        jButtonTest.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButtonTest.setMaximumSize(new Dimension(Integer.MAX_VALUE, jButtonTest.getMinimumSize().height));
        
        configButtonListPanel.add(jButtonTest);
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));
        configButtonListPanel.add(new JButton("TESTING"));

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
        row3.add(saveConfiguration);

        add(row1);
        add(row2);
        add(row3);
    }
    //TODO: add LoadingHandler
    //TODO: add SavingHandler
}
