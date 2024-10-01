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
public class Renderer {
    Boolean[][] setData;//figure out direction of dimension... Is 1st dimension the leftmost brackets?...
    protected String configName;
    protected int iteration;
    protected int renderWidth;
    protected int renderHeight;
    protected double XCoord; // X coordinate for where the center of the image will be on the set
    protected double YCoord; // Y coordinate for where the center of the image will be on the set
    protected double zoomScale;

    //REQUIRES: Configuration object
    //EFFECTS: sets the parameters of the Renderer
    public Renderer(Configuration config){

    }

    //REQUIRES: valid data from a Configuration object
    //MODIFIES: setData
    //EFFECTS: 
    /*
    Generates a 2D boolean array, representing the
    graph of the mandelbrot set on a complex plane. For each 
    point on the complex plane, it plugs in it's coordinates
    into the recursive function of z = z^2 + c based
    on the number of iterations. If the value of the equation
    ever explodes off to "infinity"(this can be arbitrarily defined),
    then that point is not in the set, and is set to false. If it 
    stays under "infinity", that point is in the set, and is set to 
    true.
    */
    public void renderSet(){
        // render the mandelbrot set...
    }

    public Boolean[][] getSet(){
        return setData;
    }
}
