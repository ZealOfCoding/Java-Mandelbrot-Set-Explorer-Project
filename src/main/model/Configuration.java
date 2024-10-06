package model;

/*Represents a configuration of values of how to generate the set. */
public class Configuration {
    protected String configName;
    protected int iteration;
    protected int renderWidth;
    protected int renderHeight;
    protected double real_start;// start of the real axis
    protected double real_end;// end of the real axis
    protected double imag_start;// start of imaginary axis
    protected double imag_end;// end of imginary axis
    protected double zoomScale; 

    //EFFECTS: sets the following parameters.
    public Configuration(String configName,
                        int iteration,
                        int renderWidth,
                        int renderHeight,
                        double real_start,
                        double real_end,
                        double imag_start,
                        double imag_end,
                        double zoomScale) {

        this.configName = configName;
        this.iteration = iteration;
        this.renderWidth = renderWidth;
        this.renderHeight = renderHeight;
        this.real_start = real_start;
        this.real_end = real_end;
        this.imag_start = imag_start;
        this.imag_end = imag_end;
        this.zoomScale = zoomScale;
    }

    public Configuration(){

    }

    //name must be under 20 characters...
    public String getConfigName(){
        return this.configName;
    }

    //iteration must be under (idk, figure out what the maximum iterations should be. Idk, 10000?)
    //EFFECTS: returns the iteration
    public int getIteration(){
        return this.iteration;
    }

    //if width is greater than 1920, either give out error message or cap it at 1920
    public int getRenderWidth(){
        return this.renderWidth;
    }

    //if width is greater than 1080, either give out error message or cap it at 1080
    public int getRenderHeight(){
        return this.renderHeight;
    }
    public double getRealStart(){
        return this.real_start;
    }

    public double getRealEnd(){
        return this.real_end;
    }

    public double getImagStart(){
        return this.imag_start;
    }

    public double getImagEnd(){
        return this.imag_end;
    }

    public double getZoomScale(){
        return this.zoomScale;
    }



}
