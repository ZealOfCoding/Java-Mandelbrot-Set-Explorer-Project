package persistance;

import org.json.JSONObject;

import model.ConfigurationList;

import java.io.*;

/*
 * Represents a writer that creates a JSON file containing the data of the current list of
 * configurations and states of the configurationList to save the data. 
 * 
 * Referred to the demo of json the following github repository:
 * https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonWriter {

    private static final int TAB = 4;
    private String fileLocation;
    private PrintWriter writer;

    /*
     * REQUIRES: 
     * MODIFIES: 
     * EFFECTS: Constructs the JsonWriter object, and takes in a string parameter for the name of the 
     *          current Json file. 
     */
    public JsonWriter(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    /* MODIFIES: writer
     * EFFECTS: creates a PrintWriter, that takes in a new file with a fileLocation.
     *          throws FileNotFoundException if destination file cannot 
     *          be opened for writing.
     */
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(fileLocation));
    }

    /* MODIFIES: writer
     * EFFECTS: writes JSON representation of workroom to a .json file. 
     */
    public void write(ConfigurationList cl) {
        JSONObject json = cl.configurationsListToJsonObject();
        saveToFile(json.toString(TAB));
    }

    /*
     * MODIFIES: writer
     * EFFECTS: closes the writer
     */
    public void close() {
        writer.close();
    }

    /*
     * MODIFIES: writer
     * EFFECTS: writes String to the writer 
     */
    public void saveToFile(String json) {
        writer.print(json);
    }
    
}
