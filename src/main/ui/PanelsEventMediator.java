package ui;

import model.Configuration;
import model.ConfigurationList;
import ui.panels.ConfigurationsPanel;
import ui.panels.DisplayPanel;
import ui.panels.LoadSavePanel;
import ui.panels.ManualInputsPanel;
import ui.panels.MessagesPanel;

public class PanelsEventMediator {
    private ManualInputsPanel mip;
    private MessagesPanel mp;
    private LoadSavePanel lsp;
    private ConfigurationsPanel cp;

    private DisplayPanel dp;

    private ConfigurationList configList;

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

    public void displayPanelGenerate(Configuration config) {
        dp.generate(config);
    }

    public void messagesPanelUpdate(String message) {
        mp.setMessage(message);
    }

    public ConfigurationList getConfigList() {
        return configList;
    }

    public void setConfigList(ConfigurationList newConfigList) {
        /*
         * NOTE: could it be bad that i'm just giving to the pointer of the newly
         * generated ConfigurationList from the JSONReader? I shall see...
         */
        this.configList = newConfigList;
    }

    public void removeConfigurationFromConfigurationList(String configName) {
        configList.removeConfiguration(configName);
    }

    public void addConfigurationToConfigurationList(Configuration config) {
        configList.addConfiguration(config);
    }

    public Configuration getConfigurationFromConfigurationList(String configName) {
        return configList.getConfiguration(configName);
    }

    public int getDisplayWidth() {
        return dp.displayWidth();
    }

    public int getDisplayHeight() {
        return dp.displayHeight();
    }

    public Configuration manualInputsPanelGetConfiguration() {
        return mip.getFields();
    }

    public void manualInputsPanelSetFields(Configuration config) {
        mip.setFields(config);
    }

    public void manualInputsPanelSetFieldDefaults() {
        mip.setFieldDefaults();
    }

    public void configurationsPanelSetUpdateConfigButtons() {
        cp.loadButtonsFromConfigList();
    }
}
