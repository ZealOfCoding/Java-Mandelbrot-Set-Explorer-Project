package model;//does this give scope visibility into the model package?...

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationListTest {
    ConfigurationList tester; 
    Configuration config1;
    Configuration config2;

    @BeforeEach
    void runBefore() {
        tester = new ConfigurationList();
        config1 = new Configuration("someConfig", 10, 1920, 1080, 0.123, 0.456, 0.789, 0.123, 100);
        config2 = new Configuration("anotherConfig", 20, 1080, 720, 0.111, 0.222, 0.333, 0.444, 200);
    }

    @Test
    void testConstructor() {
        assertEquals(0, tester.getSize());//tests that the arrayList was initialized, and that it has a size of 0
    }

    @Test
    void testDoesConfigExist() {
        tester.addConfiguration(config1);
        assertFalse(tester.doesConfigExist("nonExistentConfig"));
        assertTrue(tester.doesConfigExist("someConfig"));
    }

    @Test
    public void testAddConfiguration() {
        tester.addConfiguration(config1);

        assertNotNull(tester.getConfiguration("someConfig"));
        assertEquals("someConfig", tester.getConfiguration("someConfig").getConfigName());
        assertEquals(10, tester.getConfiguration("someConfig").getIteration());
        assertEquals(1920, tester.getConfiguration("someConfig").getRenderWidth());
        assertEquals(1080, tester.getConfiguration("someConfig").getRenderHeight());
        assertEquals(0.123, tester.getConfiguration("someConfig").getRealStart());
        assertEquals(0.456, tester.getConfiguration("someConfig").getRealEnd());
        assertEquals(0.789, tester.getConfiguration("someConfig").getImagStart());
        assertEquals(0.123, tester.getConfiguration("someConfig").getImagEnd());
        assertEquals(100, tester.getConfiguration("someConfig").getZoomScale());
    
        assertFalse(tester.addConfiguration(config1));
    }

    @Test
    public void testAddMultipleConfigurations() {
        testAddConfiguration();
        tester.addConfiguration(config2);
        assertNotNull(tester.getConfiguration("anotherConfig"));
        assertEquals("anotherConfig", tester.getConfiguration("anotherConfig").getConfigName());
        assertEquals(20, tester.getConfiguration("anotherConfig").getIteration());
        assertEquals(1080, tester.getConfiguration("anotherConfig").getRenderWidth());
        assertEquals(720, tester.getConfiguration("anotherConfig").getRenderHeight());
        assertEquals(0.111, tester.getConfiguration("anotherConfig").getRealStart());
        assertEquals(0.222, tester.getConfiguration("anotherConfig").getRealEnd());
        assertEquals(0.333, tester.getConfiguration("anotherConfig").getImagStart());
        assertEquals(0.444, tester.getConfiguration("anotherConfig").getImagEnd());
        assertEquals(200, tester.getConfiguration("anotherConfig").getZoomScale());

    }

    @Test
    public void testRemoveConfiguration() {
        tester.addConfiguration(config1);
        tester.addConfiguration(config2);

        assertNotNull(tester.getConfiguration("someConfig"));
        tester.removeConfiguration("someConfig");
        assertNull(tester.getConfiguration("someConfig"));
        assertEquals(1,tester.getSize());

        assertFalse(tester.removeConfiguration("nonExistentConfig"));
    }

    @Test
    public void testGetConfigNames() {
        tester.addConfiguration(config1);
        tester.addConfiguration(config2);

        String[] configNames = tester.getConfigNames();

        assertEquals(configNames[0], config1.getConfigName());
        assertEquals(configNames[1], config2.getConfigName());
    }

    @Test 
    public void testGetConfigurationsList() {
        tester.addConfiguration(config1);
        ArrayList<Configuration> testArray = new ArrayList<Configuration>();
        testArray.add(config1);
        assertEquals(testArray.get(0), tester.getConfigurationList().get(0));
    }

    @Test
    void configurationsToJson() {
        tester.addConfiguration(config1);
        tester.addConfiguration(config2);

        JSONArray jsonArray = tester.configurationsToJsonArray();

        checkConfiguration(config1, jsonArray.getJSONObject(0));
        checkConfiguration(config2, jsonArray.getJSONObject(1));
    }

    void checkConfiguration(Configuration original, JSONObject test) {
        assertEquals(original.getConfigName(), test.getString("configName"));
        assertEquals(original.getIteration(), test.getInt("iteration"));
        assertEquals(original.getRenderWidth(), test.getInt("renderWidth"));
        assertEquals(original.getRenderHeight(), test.getInt("renderHeight"));
        assertEquals(original.getRealStart(), test.getDouble("realStart"));
        assertEquals(original.getRealEnd(), test.getDouble("realEnd"));
        assertEquals(original.getImagStart(), test.getDouble("imagStart"));
        assertEquals(original.getImagEnd(), test.getDouble("imagEnd"));
        assertEquals(original.getZoomScale(), test.getDouble("zoomScale"));
    }
}
