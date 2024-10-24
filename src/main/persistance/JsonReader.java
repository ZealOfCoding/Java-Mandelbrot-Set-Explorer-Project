
package persistance;

import model.ConfigurationList;

import java.io.IOException;

import org.json.JSONObject;

//Referred to the demo of json the following github repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
   
    private String fileLocation;

    /*
     * EFFECTS: constructs a reader that reads a json file from fileLocation
     */
    public JsonReader(String fileLocation) {
        
    }

    /*
     * EFFECTS: reads data from json file and returns a configurationList.
     *          throws an IOException if an error occurs while reading from the file
     */
    public ConfigurationList read() throws IOException {
        return null;
    }

    /*
     * EFFECTS: reads source file and returns it as a string.
     */
    private String readFile() throws IOException {
        return "";
    }

    /*
     * EFFECTS: parses ConfigurationList from JSON object and returns it
     */
    private ConfigurationList parseConfigurationsList(JSONObject jsonObject) {
        return null;
    }

    /*
     * MODIFIES: configList
     * EFFECTS: parses configList from JsonObject and adds them to a configList. Will produce
     *          JSONArray object, and iterate through it, calling addConfiguration() in the process.
     */
    private void addConfigurationList(ConfigurationList configList, JSONObject jsonObject) {

    }

    /*
     * EFFECTS: parses each individual configuration from JsonObject with all it's parameters, 
     *          adds them to configList.
     */
    private void addConfiguration(ConfigurationList configList, JSONObject jsonObject) {

    }






}
