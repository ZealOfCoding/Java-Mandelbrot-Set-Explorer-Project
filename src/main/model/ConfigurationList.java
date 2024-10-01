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
    public Boolean addConfiguration(Configuration config){
        //configurationsList.add(config);
        return true;
    }


    //EFFECTS: Retrives a configuration based on configName. If it doesn't exist, it returns null.
    public Configuration getConfiguration(String configName){

        return null;
    }

    //MODIFIES: configurationsList
    //EFFECTS: removes a configuration from the list based on the name. If such a config
             // exists and it's sucessfully removed, it returns true. Otherwise, it returns
             // false.
    public Boolean removeConfiguration(String configName){
        //probably need a for loop to iterate through the ArrayList
        // and check the config name of every Configruation in the list.
        return true;
    }

    public int getSize(){
        return 0;
    }


}
