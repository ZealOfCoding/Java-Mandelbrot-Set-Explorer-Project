package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import model.Configuration;
import model.ConfigurationList;

import java.io.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ConfigurationList cl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyConfigurationsList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            ConfigurationList cl = reader.read();
            assertEquals(0, cl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralConfigurationsList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        Configuration config1 = new Configuration("someConfig", 10, 1920, 1080, 0.123, 0.456, 0.789, 0.123, 100);
        Configuration config2 = new Configuration("anotherConfig", 20, 1080, 720, 0.111, 0.222, 0.333, 0.444, 200);
        try {
            ConfigurationList cl = reader.read();

            ArrayList<Configuration> configList = cl.getConfigurationList();
            assertEquals(2, configList.size());
            checkConfiguration(config1, configList.get(0));
            checkConfiguration(config2, configList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
