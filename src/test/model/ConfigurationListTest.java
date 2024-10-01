/*
 * PROBLEMS: I have a null pointer issue. It would seem that my runBefore() method isn't
 * executing, and setting my attributes. Why isn't it? 
 */




package model;//does this give scope visibility into the model package?...

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationListTest {
    ConfigurationList tester; //= new ConfigurationList();
    Configuration config1; //= new Configuration("someConfig", 10, 1980, 1080, 0.123, 0.456, 100);
    Configuration config2;// = new Configuration("anotherConfig", 20, 1080, 720, 0.111, 0.222, 200);


    @BeforeEach
    void runBefore(){
        tester = new ConfigurationList();
        config1 = new Configuration("someConfig", 10, 1980, 1080, 0.123, 0.456, 100);
        config2 = new Configuration("anotherConfig", 20, 1080, 720, 0.111, 0.222, 200);
    }

    @Test
    void testConstructor(){
        assertEquals(0, tester.getSize());
    }

    @Test
    public void testAddConfiguration(){
        tester.addConfiguration(config1);
        assertEquals("someConfig", tester.getConfiguration("someConfig"));
        assertEquals(10, tester.getConfiguration("someConfig").getIteration());
        assertEquals(1920, tester.getConfiguration("someConfig").getRenderWidth());
        assertEquals(1080, tester.getConfiguration("someConfig").getRenderHeight());
        assertEquals(0.123, tester.getConfiguration("someConfig").getXCoord());
        assertEquals(0.456, tester.getConfiguration("someConfig").getYCoord());
        assertEquals(100, tester.getConfiguration("someConfig").getZoomScale());
    }

    @Test
    public void testAddMultipleConfigurations(){
        testAddConfiguration();
        tester.addConfiguration(config2);
        assertEquals("anotherConfig", tester.getConfiguration("anotherConfig"));
        assertEquals(20, tester.getConfiguration("anotherConfig").getIteration());
        assertEquals(1080, tester.getConfiguration("anotherConfig").getRenderWidth());
        assertEquals(720, tester.getConfiguration("anotherConfig").getRenderHeight());
        assertEquals(0.111, tester.getConfiguration("anotherConfig").getXCoord());
        assertEquals(0.222, tester.getConfiguration("anotherConfig").getYCoord());
        assertEquals(200, tester.getConfiguration("anotherConfig").getZoomScale());

    }

    @Test
    public void testRemoveConfiguration(){
        tester.addConfiguration(config1);
        tester.addConfiguration(config2);

        assertNotNull(tester.getConfiguration("someConfig"));
        tester.removeConfiguration("someConfig");
        assertNull(tester.getConfiguration("someConfig"));

    }


}
