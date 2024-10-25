/*
 * TO DO LIST:
 * - add all the tests...
 */

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {
    
    Configuration config;
    @BeforeEach
    void runBefore() {
        config = new Configuration("config1", 40, 1920, 1080, -2, 1, -1, 1, 10.0);
    }

    //check that it can set the values correctly and get them
    //Why are some of the methods ambiguous?
    @Test
    void testConstructor() {

        assertEquals("config1", config.getConfigName());
        assertEquals(40, config.getIteration());
        assertEquals(1920, config.getRenderWidth());
        assertEquals(1080, config.getRenderHeight());
        assertEquals(-2, config.getRealStart());
        assertEquals(1, config.getRealEnd());
        assertEquals(-1, config.getImagStart());
        assertEquals(1, config.getImagEnd());
        assertEquals(10.0, config.getZoomScale());
    }

    @Test
    void testToJsonObject() {
        JSONObject jsonObject = config.toJsonObject();
        
        assertEquals("config1", jsonObject.getString("configName"));
        assertEquals(40, jsonObject.getInt("iteration"));
        assertEquals(1920, jsonObject.getInt("renderWidth"));
        assertEquals(1080, jsonObject.getInt("renderHeight"));
        assertEquals(-2, jsonObject.getDouble("realStart"));
        assertEquals(1, jsonObject.getDouble("realEnd"));
        assertEquals(-1, jsonObject.getDouble("imagStart"));
        assertEquals(1, jsonObject.getDouble("imagEnd"));
        assertEquals(10.0, jsonObject.getDouble("zoomScale"));

    }
}
