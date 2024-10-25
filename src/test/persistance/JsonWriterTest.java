package persistance;

import java.util.ArrayList;

import model.Configuration;
import model.ConfigurationList;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest{
    
    @Test
    void testWriterInvalidFile() {
        try {
            ConfigurationList cl = new ConfigurationList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyConfigurationsList() {
        try {
            ConfigurationList cl = new ConfigurationList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            cl = reader.read();
            assertEquals(0, cl.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    //Checks whether config1 and config2 will be the same after being put through a Json file. 
    @Test
    void testWriterGeneralConfigurationsList() {
        Configuration config1 = new Configuration("someConfig", 10, 1920, 1080, 0.123, 0.456, 0.789, 0.123, 100);
        Configuration config2 = new Configuration("anotherConfig", 20, 1080, 720, 0.111, 0.222, 0.333, 0.444, 200);
        try {
            ConfigurationList cl = new ConfigurationList();
            cl.addConfiguration(config1);
            cl.addConfiguration(config2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            cl = reader.read();

            ArrayList<Configuration> configList = cl.getConfigurationList();
            assertEquals(2, configList.size());
            checkConfiguration(config1, configList.get(0));
            checkConfiguration(config2, configList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

