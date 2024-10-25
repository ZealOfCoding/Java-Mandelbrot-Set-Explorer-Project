package persistance;



import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Configuration;

public class JsonTest {
    protected void checkConfiguration(Configuration original, Configuration test) {

        assertEquals(original.getConfigName() , test.getConfigName());
        assertEquals(original.getIteration(), test.getIteration());
        assertEquals(original.getRenderWidth() , test.getRenderWidth());
        assertEquals(original.getRenderHeight(), test.getRenderHeight());
        assertEquals(original.getRealStart(), test.getRealStart());
        assertEquals(original.getRealEnd(), test.getRealEnd());
        assertEquals(original.getImagStart(), test.getImagStart());
        assertEquals(original.getImagEnd(), test.getImagEnd());
        assertEquals(original.getZoomScale(), test.getZoomScale());
    }
}
