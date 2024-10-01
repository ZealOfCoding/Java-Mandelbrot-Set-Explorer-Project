package model;

/*Represents a configuration of values of how to generate the set. */
public class Configuration {
    protected String configName;
    protected int iteration;
    protected int renderWidth;
    protected int renderHeight;
    protected double XCoord; // X coordinate for where the center of the image will be on the set
    protected double YCoord; // Y coordinate for where the center of the image will be on the set
    protected double zoomScale; 

    //EFFECTS: sets the following parameters.
    public Configuration(String configName,
                        int iteration,
                        int renderWidth,
                        int renderHeight,
                        double XCoord,
                        double YCoord,
                        double zoomScale) {
        //this.configitem = configItem....
    }

    //name must be under 20 characters...
    public String getConfigName(){
        return "";//TODO
    }

    //iteration must be under (idk, figure out what the maximum iterations should be. Idk, 10000?)
    //EFFECTS: returns the iteration
    public int getIteration(){
        return 0;//TODO
    }

    //if width is greater than 1920, either give out error message or cap it at 1920
    public int getRenderWidth(){
        return 0;//TODO
    }

    //if width is greater than 1080, either give out error message or cap it at 1080
    public int getRenderHeight(){
        return 0;//TODO
    }

    public double getXCoord(){
        return 0.1;
    }

    public double getYCoord(){
        return 0.1;
    }

    public double getZoomScale(){
        return 0.1;//TODO
    }



}
