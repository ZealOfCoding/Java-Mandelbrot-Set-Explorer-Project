package model;

import java.util.ArrayList;

/*
 * Represents the list of Configurations in an ArrayList.
 */
public class ConfigurationList {

    ArrayList<Configuration> configurationsList;

    /*
     * MODIFIES: this, configurationsList
     * EFFECTS: creates a configurations list using an ArrayList.
     */
    public ConfigurationList() {
        configurationsList = new ArrayList<Configuration>();
    }

    /*
     * REQUIRES: configurationsList is initialized, configName is non zero length
     * EFFECTS: takes in a configName. If it exists in configurationsList,
     * it returns true. Otherwise, it returns false.
     */
    public Boolean doesConfigExist(String configName) {
        for (Configuration thisConfig : configurationsList) {
            if (thisConfig.getConfigName().equals(configName)) {
                return true;
            }
        }
        return false;
    }

    /*
     * MODIFIES: configurationsList
     * EFFECTS: constructs a new Configuration, and adds it to configurationsList. 
                If it sucessfully enters a new configuration with a unique name, it returns true. 
                Otherwise, it returns false and doesn't add it to the list.
     */
    
    public Boolean addConfiguration(Configuration newConfig) {
        for (Configuration thisConfig : configurationsList) {
            if (thisConfig.getConfigName() == newConfig.getConfigName()) {
                return false;
            }
        }
        configurationsList.add(newConfig);
        return true;
    }

    /*
     * EFFECTS: Retrives a configuration based on configName. If it doesn't exist, it returns null.
     */
    public Configuration getConfiguration(String configName) {
        for (Configuration thisConfig : configurationsList) {
            if (thisConfig.getConfigName().equals(configName)) {
                return thisConfig;
            }
        }
        return null;
    }

    /*
     * MODIFIES: configurationsList
     * EFFECTS: removes a configuration from the list based on the name. If such a config
     *          exists and it's sucessfully removed, it returns true. If no config with
     *          a matching name exists, it returns false.
     */
    public Boolean removeConfiguration(String configName) {
        for (int i = 0; i < configurationsList.size(); i++) {
            if (configurationsList.get(i).getConfigName() == configName) {
                configurationsList.remove(i);
                return true;
            }
        }
        return false;
    }

    /*
     * REQUIRES: initialization of configurationsList
     * EFFECTS: returns the size of the configruation list.
     */

    public int getSize() {
        return configurationsList.size();
    }

    // public String[] getConfigNames(){
    //     return null;
    // }
}
