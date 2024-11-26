package model;

import org.json.JSONObject;

/*Represents a configuration of values of how to generate the set.
 * This is my X.
 */
public class Configuration {
    protected String configName;
    protected int iteration;
    protected int renderWidth; 
    protected int renderHeight;
    protected double realStart;
    protected double realEnd;
    protected double imagStart;
    protected double imagEnd;
    protected double zoomScale; // TODO: i'll probably depricate this...
    
    /* 
     * REQUIRES: configName has non-zero length
     * EFFECTS: sets the following parameters.
     */
    public Configuration(String configName,
                        int iteration,
                        int renderWidth,
                        int renderHeight,
                        double realStart,
                        double realEnd,
                        double imagStart,
                        double imagEnd,
                        double zoomScale) {

        this.configName = configName;
        this.iteration = iteration;
        this.renderWidth = renderWidth;
        this.renderHeight = renderHeight;
        this.realStart = realStart;
        this.realEnd = realEnd;
        this.imagStart = imagStart;
        this.imagEnd = imagEnd;
        this.zoomScale = zoomScale;
    }

    /*
     *EFFECTS: serves as a blank constructor
     */
    public Configuration() {

    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    //name must be under 20 characters...
    public String getConfigName() {
        return this.configName;
    }

    //iteration must be under (idk, figure out what the maximum iterations should be. Idk, 10000?)
    //EFFECTS: returns the iteration
    public int getIteration() {
        return this.iteration;
    }

    public int getRenderWidth() {
        return this.renderWidth;
    }

    public int getRenderHeight() {
        return this.renderHeight;
    }
    
    public double getRealStart() {
        return this.realStart;
    }

    public double getRealEnd() {
        return this.realEnd;
    }

    public double getImagStart() {
        return this.imagStart;
    }

    public double getImagEnd() {
        return this.imagEnd;
    }

    public double getZoomScale() {
        return this.zoomScale;
    }

    /*
     * EFFECTS: returns a JSONOjbect representation
     *          of the current configuration.
     */
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("configName", configName);
        json.put("iteration", iteration);
        json.put("renderWidth", renderWidth);
        json.put("renderHeight", renderHeight);
        json.put("realStart", realStart);
        json.put("realEnd", realEnd);
        json.put("imagStart", imagStart);
        json.put("imagEnd", imagEnd);
        json.put("zoomScale", zoomScale);
        return json;

    }
}