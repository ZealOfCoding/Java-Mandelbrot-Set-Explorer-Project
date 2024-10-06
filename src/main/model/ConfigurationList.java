package model;
import java.util.ArrayList;

/*
 * Represents the list of Configurations in an ArrayList.
 */
public class ConfigurationList {

    ArrayList<Configuration> configurationsList;

    //MODIFIES: this, configurationsList
    //EFFECTS: creates a configurations list using an ArrayList.
    public ConfigurationList(){
        configurationsList = new ArrayList<Configuration>();
    }

    //REQUIRES: configName to be unique name,
                //iteration > 0, renderWidth <= 1920, renderHeight <= 1080, zoomScale < 100 */
    //MODIFIES: configurationsList
    //EFFECTS: constructs a new Configuration, and adds it to configurationsList. 
                //If it sucessfully enters a new configuration with a unique name, it returns true. 
                //Otherwise, it returns false and doesn't add it to the list.    
    public Boolean addConfiguration(Configuration newConfig){
        for(Configuration thisConfig : configurationsList){
            if(thisConfig.getConfigName() == newConfig.getConfigName()){
                return false;
            }
        }
        configurationsList.add(newConfig);
        return true;
    }


    //EFFECTS: Retrives a configuration based on configName. If it doesn't exist, it returns null.
    public Configuration getConfiguration(String configName){
        for(Configuration thisConfig : configurationsList){
            if(thisConfig.getConfigName() == configName){
                return thisConfig;
            }
        }
        return null;
    }

    //MODIFIES: configurationsList
    //EFFECTS: removes a configuration from the list based on the name. If such a config
             // exists and it's sucessfully removed, it returns true. If no config with
             // a matching name exists, it returns false.
    public Boolean removeConfiguration(String configName){
        for(int i = 0; i < configurationsList.size(); i++){
            if(configurationsList.get(i).getConfigName() == configName){
                configurationsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public String[] getConfigNames(){
        return null;
    }

    public int getSize(){
        return configurationsList.size();
    }


}
