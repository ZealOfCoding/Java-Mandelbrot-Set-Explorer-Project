package ui;

import model.Configuration;
import model.ConfigurationList;
import model.Renderer;
import ui.panels.ConfigurationsPanel;
import ui.panels.DisplayPanel;
import ui.panels.LoadSavePanel;
import ui.panels.ManualInputsPanel;
import ui.panels.MessagesPanel;

/*
 * Acts as a mediator class, that handles communications and requests 
 * between the panels. 
 */
public class PanelsEventMediator {
    private ManualInputsPanel mip;
    private MessagesPanel mp;
    private LoadSavePanel lsp;
    private ConfigurationsPanel cp;

    private DisplayPanel dp;

    private ConfigurationList configList;

    /*
     * EFFECTS: gives access to all of the panels in the program.
     */
    public PanelsEventMediator(ManualInputsPanel mip, 
                               MessagesPanel mp, 
                               LoadSavePanel lsp, 
                               ConfigurationsPanel cp, 
                               DisplayPanel dp, 
                               ConfigurationList configList) {
        this.mip = mip;
        this.mp = mp;
        this.lsp = lsp;
        this.cp = cp;

        this.dp = dp;

        this.configList = configList;
    }

    /*
     * EFFECTS: calls DisplayPanel to generate a configuration
     */
    public void displayPanelGenerate(Configuration config) {
        dp.generate(config);
    }


    /*
     * EFFECTS: calls MessagesPanel and updates the messages panel
     */
    public void messagesPanelUpdate(String message) {
        mp.setMessage(message);
    }

    /*
     * EFFECTS: returns the ConfigurationList 
     */
    public ConfigurationList getConfigList() {
        return configList;
    }

    /*
     * EFFECTS: sets the ConfigurationList
     */
    public void setConfigList(ConfigurationList newConfigList) {
        /*
         * NOTE: could it be bad that i'm just giving to the pointer of the newly
         * generated ConfigurationList from the JSONReader? I shall see...
         */
        this.configList = newConfigList;
    }

    /*
     * EFFECTS: removes a configuration based on configName, by calling
     * ConfigurationList to remove it.
     */
    public void removeConfigurationFromConfigurationList(String configName) {
        configList.removeConfiguration(configName);
    }

    /*
     * EFFECTS: Calls ConfigurationList to add a configuration based on 
     * the given configuration object.
     */
    public void addConfigurationToConfigurationList(Configuration config) {
        configList.addConfiguration(config);
    }

    /*
     * EFFECTS: gets a configuration from the ConfigurationList, and returns it
     */
    public Configuration getConfigurationFromConfigurationList(String configName) {
        return configList.getConfiguration(configName);
    }

    /*
     * EFFECTS: gets the display width from DisplayPanel
     */
    public int getDisplayWidth() {
        return dp.displayWidth();
    }

    /*
     * EFFECTS: gets the display height from DisplayPanel
     */
    public int getDisplayHeight() {
        return dp.displayHeight();
    }

    /*
     * EFFECTS: calls ManualInputsPanel to make and get a Configuration object 
     * containing the configurations from it's input fields
     */
    public Configuration manualInputsPanelGetConfiguration() {
        return mip.getFields();
    }

    /*
     * EFFECTS: calls ManualInputsPanel to set it's fields based on 
     * the input Configuration object.
     */
    public void manualInputsPanelSetFields(Configuration config) {
        mip.setFields(config);
    }

    /*
     * EFFECTS: calls ManualInputsPanel to set it it's fields to default.
     */
    public void manualInputsPanelSetFieldDefaults() {
        mip.setFieldDefaults();
    }

    /*
     * EFFECTS: calls ConfigurationPanel to update any changes made based on
     *  the ConfigurationList, and update them on the list of displayed 
     * configurations.
     */
    public void configurationsPanelSetUpdateConfigButtons() {
        cp.loadButtonsFromConfigList();
    }

    public void displayPanelSetZoom(double zoomScale) {
        dp.setZoom(zoomScale);
    }
}
