/*TO DO LIST:
 * - finalize the method signatures. 
 * - consider if I need a class dedicated for the user panel...
 */

package ui;

import model.Configuration;
import model.ConfigurationList;
import model.Renderer;

/*
 * A Mandelbrot Set Viewer app. It allows for the user to enter 
 * in parameters that modify how the Mandelbrot Set will be generated.
 * These parameters can be saved into a configuration that can be loaded
 * and used to render from. 
 */

public class MandelbrotSetViewerApp {
    private Renderer renderer;
    private ConfigurationList configList;
    private Configuration A;
    
    //Hmm, should configurationsList be it's own class?

    //EFFECTS: instanciates and runs the Mandelbrot Set viewer
    public MandelbrotSetViewerApp(){
        runMandelbrotSetViewer();
    }

    //EFFECTS: handles the user's inputs
    private void runMandelbrotSetViewer(){

        displayMenu();
        //get user input based on letters...
        A = new Configuration("A", 100, 72, 48, -2, 1, -1, 1, 10);
        renderer = new Renderer(A);
        renderer.renderSet();
        displaySet(renderer.getSet());
    }

    private void displayMenu(){
        System.out.println("Welcome to the interactive Mandelbrot Set viewer App. Please select one of the following options:");
        System.out.println("g: generate a new set");
        System.out.println("l: load from an existing configuration");
    }

    //REQUIRES:
    //EFFECTS: displays the set, using the data from the rederObj in a 2D boolean array.
    //In Phase 1, I'm printing out the set using symbols. 
    private void displaySet(Boolean[][] renderObj){
        //TODO
        //replace height and width with getRenderWidth and getRenderHeight

        for(int h = 0; h < A.getRenderHeight(); h++){
            String currentRow = "";
            for(int w = 0; w < A.getRenderWidth(); w++){
                if(renderObj[h][w]){
                    currentRow = currentRow + " `";
                }
                else{
                    currentRow = currentRow + "██";
                }
                
            }
            System.out.println(currentRow);
        }
    }
}
