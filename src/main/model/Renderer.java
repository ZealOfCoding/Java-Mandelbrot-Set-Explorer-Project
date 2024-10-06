package model;

/*
 * Represents the rendering "engine" for the set. 
 * 
 * Takes in the parameters from a Configuration object, and 
 * uses them to generate the set. It saves the data of the set 
 * into a 2D boolean array that are the dimensions of how it 
 * will be printed. 
 * 
 */
public class Renderer extends Configuration{
    Boolean[][] setData;//remember: the indexes going towards the right are higher order dimensions

    //REQUIRES: Configuration object
    //EFFECTS: sets the parameters of the Renderer
    public Renderer(Configuration config){
        super();
        //TODO: 
        //I think this could probably inherit the behavior of the Configuartion class....
        //I feel like i'm copying and pasting a bunch of code here...
        this.configName = config.getConfigName();
        this.iteration = config.getIteration();
        this.renderWidth = config.getRenderWidth();
        this.renderHeight = config.getRenderHeight();
        this.real_start = config.getRealStart();
        this.real_end = config.getRealEnd();
        this.imag_start = config.getImagStart();
        this.imag_end = config.getImagEnd();
        this.zoomScale = config.getZoomScale();
        setData = new Boolean[config.renderHeight][config.renderWidth];
    }

    //EFFECTS: default render, renders as soon as program is first open.
    public Renderer(){
        this.iteration = 100;
        this.renderWidth = 900;
        this.renderHeight = 600;
        this.real_start = -2;
        this.real_end = 1;
        this.imag_start = -1;
        this.imag_end = 1;
    }

    //REQUIRES: valid data from a Configuration object
    //MODIFIES: setData
    //EFFECTS: 
/*  Generates a 2D boolean array, representing the
    graph of the mandelbrot set on a complex plane. For each 
    point on the complex plane(or element of the 2D boolean array), 
    it plugs in it's coordinates
    into the recursive function of z = z^2 + c based
    on the number of iterations. If the value of c
    ever explodes off to "infinity"(this can be arbitrarily defined, usually 4),
    then that point is not in the set, and is set to false. If it 
    stays under "infinity", that point is in the set, and is set to 
    true.


    Significant help of math from the following video source:
    https://www.youtube.com/watch?v=QUfFcg0c-9E&list=PLmGXvJnxPKXkUFS6yTp0zEyH1QFjbgjHY&index=2

*/

    //@SuppressWarnings
    //Use that supress warning, I have like 50 lines of code here...
    public void renderSet(){
        double imag_c; //picked based on the pixel currently
        double real_c;
        double imag_z; // starts at 0 & changes every time an iteration occurs
        double real_z;

        //outlines the range of the complex plane to be used
        /*NOTE: current aspect ratio works for image of 3:2. 
        //TODO: implement a way to change the aspect ratio of the image, without distorting the image
        */
        // double real_start = -2;
        // double real_end = 1;
        // double imag_start = -1;
        // double imag_end = 1;

        for(int h = 0; h < renderHeight; h++){
            for(int w = 0; w < renderWidth; w++){
                //convert from pixel coordinate to complex plane coordinate
                real_c = real_start + (1.0 * w / renderWidth) * (real_end - real_start);
                imag_c = imag_start + (1.0 * h / renderHeight) * (imag_end - imag_start);
                real_z = 0;
                imag_z = 0;

                int iter = 0;
                while (iter < iteration){
                    //iterates Z=Z^2 + c
                    //NOTE: reason for making temp variable is to ensure that both parts of
                    //the seperated equation get the same value of real_z. 
                    double real_temp = real_z*real_z - imag_z*imag_z + real_c;
                    double imag_temp = 2*real_z*imag_z + imag_c;
                    real_z = real_temp;
                    imag_z = imag_temp;
    
                    //checks if |Z|^2 > 4, if so, it stops iterating the equation
                    if((real_z*real_z + imag_z*imag_z) > 4){
                        break;
                    }
                    iter++;
                }

                /* Future improvement:
                 * Here, you could track the number of iterations, and map those
                 * to a color value... Or just do a simple greyscale mapping...
                 */
                //If the iteration count stays under the iteration limit, the point is in the set.
                if(iter < iteration){
                    setData[h][w] = true;
                //Otherwise, it is out of the set.    
                } else {
                    setData[h][w] = false;
                }
            }
        }
    }

    //P.S, I may or may not implement this...
    //EFFECTS:
    /*
     * This method converts a pixel's coordinate in the 2D array into the values
     * on the complex plane, which are what's actually used in the recursive function.
     * 
     */
    public void coordinateToValue(){

    }

    //REQUIRES: setData
    //EFFECTS: returns the setData pointer
    public Boolean[][] getSet(){
        return setData;
    }
}
