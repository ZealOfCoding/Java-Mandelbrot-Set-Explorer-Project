package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RendererTest {
    Renderer renderObj;
    Configuration configA;

    @BeforeEach
    void runBefore(){
        configA = new Configuration("someConfig", 5, 7, 7, 0, 0, 1);
        renderObj = new Renderer(configA);
    }

    @Test
    void testConstructor(){
        assertEquals("someConfig", renderObj.configName);
        assertEquals(10, renderObj.iteration);
        assertEquals(1980, renderObj.renderWidth);
        assertEquals(1080, renderObj.renderHeight);
        assertEquals(0.123, renderObj.XCoord);
        assertEquals(0.456, renderObj.YCoord);
        assertEquals(100, renderObj.zoomScale);
    }

    @Test
    void testRenderSet(){
        renderObj.renderSet();
        //Boolean[][] setTest = renderObj.getSet();

        Boolean[][] setTest = {
            {true, true, true, true, true},
            {false, false, false, false, false},
            {true, true, true, true, true},
            {false, false, false, false, false},
            {true, true, true, true, true}
        };

        Boolean[][] setReference = {
            {true, true, true, true, true},
            {false, true, false, false, false},
            {true, true, true, true, true},
            {false, false, false, false, false},
            {true, true, true, true, true}
        };


        //do for loops to check against a correct boolean grid structure...
        for(int h = 0; h < renderObj.renderHeight; h++){
            for(int w = 0; w < renderObj.renderWidth; w++){
                assertEquals(setReference[h][w], setTest[h][w]);
            }
        }
    }
}
