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

    private String fileName;
    private PrintWriter writer;

    /*
     * REQUIRES: 
     * MODIFIES: 
     * EFFECTS: Constructs the JsonWriter object, and takes in a string parameter for the name of the 
     *          current Json file. 
     */
    public JsonWriter(String fileLocation) {

    }

    /* MODIFIES: writer
     * EFFECTS: creates a PrintWriter, that takes in a new file with a fileLocation.
     *          throws FileNotFoundException if destination file cannot 
     *          be opened for writing.
     */
    public void open() throws FileNotFoundException {

    }

    /* MODIFIES: writer
     * EFFECTS: writes JSON representation of workroom to a .json file. 
     */
    public void write(ConfigurationList cl) {

    }

    /*
     * MODIFIES: writer
     * EFFECTS: closes the writer
     */
    public void close() {
        
    }

    /*
     * MODIFIES: writer
     * EFFECTS: writes String to the writer 
     */
    public void saveToFile(String json) {

    }
    
}
