
package persistance;

import model.ConfigurationList;
import model.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Represents a reader that reads from a JSON file, and converts it 
 * into a ConfigurationList that the MandelbrotSetViewerApp can use.
 * 
 * Referred to the demo of json the following github repository:
 * https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonReader {
   
    private String fileLocation;
    private static final String WORKSPACE_NAME = "workspaceConfigurations";

    /*
     * EFFECTS: constructs a reader that reads a json file from fileLocation
     */
    public JsonReader(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    /*
     * EFFECTS: reads data from json file and returns a configurationList.
     *          throws an IOException if an error occurs while reading from the file
     */
    public ConfigurationList read() throws IOException {
        String jsonData = readFile(fileLocation);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseConfigurationsList(jsonObject);
    }

    /*
     * EFFECTS: reads source file and returns it as a string.
     */
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    /*
     * EFFECTS: parses ConfigurationList from JSON object and returns it
     */
    private ConfigurationList parseConfigurationsList(JSONObject jsonObject) {
        //String name = jsonObject.getString("workspaceConfigurations");
        ConfigurationList cl = new ConfigurationList();
        addConfigurationList(cl, jsonObject);
        return cl;
    }

    /*
     * MODIFIES: configList
     * EFFECTS: parses configList from JsonObject and adds them to a configList. Will produce
     *          JSONArray object, and iterate through it, calling addConfiguration() in the process.
     */
    private void addConfigurationList(ConfigurationList configList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray(WORKSPACE_NAME);
        for (Object json : jsonArray) {
            JSONObject nextConfiguration = (JSONObject) json;
            addConfiguration(configList, nextConfiguration);
        }
    }

    /*
     * EFFECTS: parses each individual configuration from JsonObject with all it's parameters, 
     *          adds them to configList.
     */
    private void addConfiguration(ConfigurationList configList, JSONObject jsonObject) {
        
        String configName = jsonObject.getString("configName");
        int iteration = jsonObject.getInt("iteration");
        int renderWidth = jsonObject.getInt("renderWidth");
        int renderHeight = jsonObject.getInt("renderHeight");
        double realStart = jsonObject.getDouble("realStart");
        double realEnd = jsonObject.getDouble("realEnd");
        double imagStart = jsonObject.getDouble("imagStart");
        double imagEnd = jsonObject.getDouble("imagEnd");
        double zoomScale = jsonObject.getDouble("zoomScale");
        Configuration newConfiguration = new Configuration(configName, iteration, renderWidth, renderHeight, 
                                                            realStart, realEnd, imagStart, imagEnd, zoomScale);
        configList.addConfiguration(newConfiguration);
    }






}
