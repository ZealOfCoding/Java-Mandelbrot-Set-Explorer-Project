/*
 * TO DO LIST:
 * - add all the tests...
 */

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {
    
    Configuration config;
    @BeforeEach
    void runBefore() {
        config = new Configuration("config1", 40, 1920, 1080, 2.435, 1.345, 10);
    }

    //check that it can set the values correctly and get them
    //Why are some of the methods ambiguous?
    @Test
    void testConstructor() {

        assertEquals("config1", config.getConfigName());
        assertEquals(40, config.getIteration());
        assertEquals(1920, config.getRenderWidth());
        assertEquals(1080, config.getRenderHeight());
        assertEquals(2.435, config.getXCoord());
        assertEquals(1.45, config.getYCoord());
        assertEquals(10.0, config.getZoomScale());
    }


}
