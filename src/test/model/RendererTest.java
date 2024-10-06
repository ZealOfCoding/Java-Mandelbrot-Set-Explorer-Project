package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RendererTest {
    Renderer renderObj;
    Configuration configA;

    @BeforeEach
    void runBefore(){
        configA = new Configuration("someConfig", 10, 5, 3, -2, 1, -1, -1, 100);
        renderObj = new Renderer(configA);
    }

    @Test
    void testConstructor(){
        assertEquals("someConfig", renderObj.configName);
        assertEquals(10, renderObj.iteration);
        assertEquals(5, renderObj.renderWidth);
        assertEquals(3, renderObj.renderHeight);
        assertEquals(-2, renderObj.real_start);
        assertEquals(1, renderObj.real_end);
        assertEquals(-1, renderObj.imag_start);
        assertEquals(1, renderObj.imag_end);
        assertEquals(100, renderObj.zoomScale);
    }

    @Test
    void testRenderSet(){
        //NOTE: this test should fail as it is right now...

        renderObj.renderSet();
        Boolean[][] setTest = renderObj.getSet();

        Boolean[][] setReference = {
            //this set reference has errors in it... Idk if it's worth making such a test....


            // {true,true,true,true,true,true,true,true,false,true,true,true,true,true},
            // {true,true,true,true,true,true,true,true,false,true,true,true,true},
            // {true,true,true,true,true,true,true,false,false,false,true,true,true},
            // {true,true,true,true,true,true,false,false,false,false,false,true,true},
            // {true,true,true,true,false,false,false,false,false,false,false,true,true},
            // {false,false,false,false,false,false,false,false,false,false,true,true,true},
            // {true,true,true,true,false,false,false,false,false,false,false,true,true},
            // {true,true,true,true,true,true,false,false,false,false,false,true,true},
            // {true,true,true,true,true,true,true,true,false,false,true,true,true},
            // {true,true,true,true,true,true,true,true,false,true,true,true,true},
            {true, true, true, true, true},
            {true, true, true, false, false},
            {true, true, true, false, false},
        };

        //do for loops to check against a correct boolean grid structure...
        for(int h = 0; h < renderObj.renderHeight; h++){
            for(int w = 0; w < renderObj.renderWidth; w++){
                assertEquals(setReference[h][w], setTest[h][w]);
            }
        }
    }
}
