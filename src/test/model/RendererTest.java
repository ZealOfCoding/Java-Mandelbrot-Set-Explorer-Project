package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RendererTest {
    Renderer defaultRenderObj;
    Renderer renderObj;
    Configuration configA;
    boolean[][] setReference = {
        {true, true, true, true, true},
        {true, true, true, false, false},
        {true, true, true, false, false},
    };

    @BeforeEach
    void runBefore(){
        configA = new Configuration("someConfig", 10, 5, 3, -2, 1, -1, 1, 100);
        renderObj = new Renderer(configA);
    }

    @Test
    void testConstructor(){
        assertEquals("someConfig", renderObj.configName);
        assertEquals(10, renderObj.iteration);
        assertEquals(5, renderObj.renderWidth);
        assertEquals(3, renderObj.renderHeight);
        assertEquals(-2, renderObj.realStart);
        assertEquals(1, renderObj.realEnd);
        assertEquals(-1, renderObj.imagStart);
        assertEquals(1, renderObj.imagEnd);
        assertEquals(100, renderObj.zoomScale);
    }

    /*
     * - TODO: change the renderWidth back to 600 in final implementation
     * - TODO: change the renderHeight back to 900 in final implementation
     */
    @Test
    void testDefaultConstructor(){
        defaultRenderObj = new Renderer();
        assertEquals("default", defaultRenderObj.configName);
        assertEquals(100, defaultRenderObj.iteration);
        assertEquals(72, defaultRenderObj.renderWidth);
        assertEquals(48, defaultRenderObj.renderHeight);
        assertEquals(-2, defaultRenderObj.realStart);
        assertEquals(1, defaultRenderObj.realEnd);
        assertEquals(-1, defaultRenderObj.imagStart);
        assertEquals(1, defaultRenderObj.imagEnd);
        assertEquals(1, defaultRenderObj.zoomScale);
    }

    @Test
    void testRenderSet(){
        //NOTE: this test should fail as it is right now...

        renderObj.renderSet();
        int[][] setTest = renderObj.getSet();

            //this set reference test has errors in it... Considering if it's worth making such a large test...

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


        //do for loops to check against a correct boolean grid structure...
        for(int h = 0; h < renderObj.renderHeight; h++){
            for(int w = 0; w < renderObj.renderWidth; w++){
                assertEquals(setReference[h][w], setTest[h][w]);
            }
        }
    }

    @Test
    void testGetSet(){
        renderObj.renderSet();
        int[][] setPointer = renderObj.getSet();
        for(int h = 0; h < renderObj.renderHeight; h++){
            for(int w = 0; w < renderObj.renderWidth; w++){
                assertEquals(setReference[h][w], setPointer[h][w]);
            }
        }
    }

    @Test
    void testGetWidthAndHeight(){
        assertEquals(5, renderObj.getWidth());
        assertEquals(3, renderObj.getHeight());
    }

    @Test
    void testGetCurrentConfigruation(){
        Configuration rendererConfig = renderObj.getCurrentConfiguration();
        assertEquals(rendererConfig.configName, renderObj.configName);
        assertEquals(rendererConfig.iteration, renderObj.iteration);
        assertEquals(rendererConfig.renderWidth, renderObj.renderWidth);
        assertEquals(rendererConfig.renderHeight, renderObj.renderHeight);
        assertEquals(rendererConfig.realStart, renderObj.realStart);
        assertEquals(rendererConfig.realEnd, renderObj.realEnd);
        assertEquals(rendererConfig.imagStart, renderObj.imagStart);
        assertEquals(rendererConfig.imagEnd, renderObj.imagEnd);
        assertEquals(rendererConfig.zoomScale, renderObj.zoomScale);
    }


}
