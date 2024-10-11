package model;

/*
 * Represents the rendering "engine" for the set. 
 * 
 * Takes in the parameters from a Configuration object, and 
 * uses them to generate the set. It saves the data of the set 
 * into a 2D boolean array that are the dimensions of how it 
 * will be printed. 
 */
public class Renderer extends Configuration {
    boolean[][] setData;//remember: the indexes going towards the right are higher order dimensions

    /*
     * REQUIRES: Configuration object
     * EFFECTS: sets the parameters of the Renderer
     */
    public Renderer(Configuration config) {
        super();
        this.configName = config.getConfigName();
        this.iteration = config.getIteration();
        this.renderWidth = config.getRenderWidth();
        this.renderHeight = config.getRenderHeight();
        this.realStart = config.getRealStart();
        this.realEnd = config.getRealEnd();
        this.imagStart = config.getImagStart();
        this.imagEnd = config.getImagEnd();
        this.zoomScale = config.getZoomScale();
        setData = new boolean[config.renderHeight][config.renderWidth];
    }

    /*
     * EFFECTS: default render, renders as soon as program is first open.
     */
    public Renderer() {
        int height = 48;//TODO: remember to change this back to something appropriate like 600 in final phase
        int width = 72;//TODO: remember to change this back to something appropriate like 900 in final phase

        this.configName = "default";//irrelevant default...
        this.iteration = 100;
        this.renderWidth = width;
        this.renderHeight = height;
        this.realStart = -2;
        this.realEnd = 1;
        this.imagStart = -1;
        this.imagEnd = 1;
        this.zoomScale = 1;//irrelevant default
        setData = new boolean[height][width];
    }

    /*
     * REQUIRES: valid data from a Configuration object
     * MODIFIES: setData
     * EFFECTS: 
     *   Generates a 2D boolean array, representing the
     *   graph of the mandelbrot set on a complex plane. For each 
     *  point on the complex plane(or element of the 2D boolean array), 
     *   it plugs in it's coordinates
     *   into the recursive function of z = z^2 + c based
     *   on the number of iterations. If the value of c
     *   ever explodes off to "infinity"(this can be arbitrarily defined, usually 4),
     *   then that point is not in the set, and is set to false. If it 
     *   stays under "infinity", that point is in the set, and is set to 
     *   true.
     *
     *
     *   Significant help of math from the following video source:
     *   https://www.youtube.com/watch?v=QUfFcg0c-9E&list=PLmGXvJnxPKXkUFS6yTp0zEyH1QFjbgjHY&index=2
     *
     */
    public void renderSet() {
        double imagC; // picked based on the pixel currently
        double realC;
        double imagZ; // starts at 0 & changes every time an iteration occurs
        double realZ;

        //outlines the range of the complex plane to be used
        /*NOTE: current aspect ratio works for image of 3:2. 
        //TODO: implement a way to change the aspect ratio of the image, without distorting the image
        */
        // double real_start = -2;
        // double real_end = 1;
        // double imag_start = -1;
        // double imag_end = 1;

        for (int h = 0; h < renderHeight; h++) {
            for (int w = 0; w < renderWidth; w++) {
                //convert from pixel coordinate to complex plane coordinate
                realC = realStart + (1.0 * w / renderWidth) * (realEnd - realStart);
                imagC = imagStart + (1.0 * h / renderHeight) * (imagEnd - imagStart);
                
                realZ = 0;
                imagZ = 0;

                /* Future improvement:
                 * Here, you could track the number of iterations, and map those
                 * to a color value... Or just do a simple greyscale mapping...
                 */
                //If the iteration count stays under the iteration limit, the point is in the set.
                setData[h][w] = isInSet(realC, imagC, realZ, imagZ);
            }
        }
    }

    /* 
     * REQUIRES: realC, imagC, realZ, imagZ
     * EFFECTS: checks whether the given point on the complex plane is in the set.
     * 
     * Future improvement: make the function return an integer; the number of times it took
     * for the point to reach the iteration limit. 
     */
    private boolean isInSet(double realC, double imagC, double realZ, double imagZ) {
        int iter = 0;

        while (iter < iteration) {
            /*
             * iterates Z=Z^2 + c
             * NOTE: reason for making temp variables is to ensure that both parts of
             * the seperated equation get the same value of real_z. 
             */

            double realTemp = (realZ * realZ) - (imagZ * imagZ) + realC;
            double imagTemp = 2 * realZ * imagZ + imagC;
            realZ = realTemp;
            imagZ = imagTemp;

            /*
             * checks if |Z|^2 > 4, if so, the point is not in the set, and stops iterating the equation.
             * 
             * In future revisions, the number of iterations that it took to be greater than 4(or in math 
             * terms, for the complex number orbital to escape) before reaching the iteration limit could be
             * tracked, and a color map could be applied to the number of iterations a given point took.
             */
            if (((realZ * realZ) + (imagZ * imagZ)) > 4) {
                return false;
            }
            iter++;
        }
        //if the loop finishes after iteration times, then the point is considered in the set.
        return true;
    }

    /*
     * REQUIRES: setData
     * EFFECTS: returns the setData pointer
     */
    public boolean[][] getSet() {
        return setData;
    }

    //P.S, I may or may not implement this...
    //EFFECTS:
    /*
     * This method converts a pixel's coordinate in the 2D array into the values
     * on the complex plane, which are what's actually used in the recursive function.
     * 
     */
    // public void coordinateToValue(){

    // }

    public int getWidth() {
        return this.renderWidth;
    }

    public int getHeight() {
        return this.renderHeight;
    }

    /*
     * REQUIRES: A valid copy of all the configuration values
     * EFFECTS: returns the current state of configuration that was just used by the renderer
     *
     *   //@SuppressWarnings("parameterlength") Can I use something like this?
     */
    public Configuration getCurrentConfiguration() {
        Configuration currentState = new Configuration(configName, iteration, renderWidth, renderHeight, 
                                                       realStart, realEnd, imagStart, imagEnd, zoomScale);
        return currentState;
    }
}
