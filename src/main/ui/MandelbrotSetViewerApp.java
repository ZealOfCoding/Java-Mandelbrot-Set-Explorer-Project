package ui;

import model.Configuration;
import model.ConfigurationList;
import model.Renderer;
import java.util.Scanner;

/*
 * A Mandelbrot Set Viewer app. It allows for the user to enter 
 * in parameters that modify how the Mandelbrot Set will be generated.
 * These parameters can be saved into a configuration that can be loaded
 * and used to render from. 
 */
public class MandelbrotSetViewerApp {
    private Renderer renderer;
    private ConfigurationList configList;
    private Scanner scanner;
    private String userInput;

    /*
     * EFFECTS: instanciates and runs the Mandelbrot Set viewer
     */

    public MandelbrotSetViewerApp() {
        runMandelbrotSetViewer();
    }

    /*
     * EFFECTS: runs the program. Data from the configuration is sent to the renderer,
     *          which takes a copy of the configuration. The displaySet() method then uses the
     *          values from the renderer object.
     */
    private void runMandelbrotSetViewer() {
        scanner = new Scanner(System.in);
        configList = new ConfigurationList();
        renderer = new Renderer();
        renderer.renderSet();
        displaySet(renderer.getSet());

        System.out.println("Welcome to the interactive Mandelbrot Set viewer App. ");
        System.out.println("Please select one of the following options:");

        // make a while loop that keeps asking for another input!!
        interfacePanelInput();
    }

    /*
     * MODIFIES: renderer, scanner
     * EFFECTS: displays the user console menu, and takes the inputs, and will do one of 5 operations:
     *          Make a new configuration
     *          Save the current sate of configuration in the renderer
     *          Generate a configuration from list of configs, based on the name
     *          Delete a configuration from list based on it's name
     *          Exit the app
     */

    //Approved use of warning supression by the professor October 10th, 2024 during office hour
    @SuppressWarnings("methodlength")
    private void interfacePanelInput() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            userInput = scanner.nextLine();
            switch (userInput) {
                case "m":
                    makeNewConfiguration();
                    break;
                case "l":
                    listConfigurations();
                case "s":
                    saveCurrentConfiguration();
                    break;
                case "g":
                    generateFromExistingConfiguration(); 
                    break;
                case "d":
                    deleteExistingConfiguration();
                    break;
                case "e":
                    exit = true;
                    break;
                default:
                    invalidCommandPrompt();
            }
        }
    }
    
    private void listConfigurations() {
        System.out.println("Current List of Configurations:");
        // while () {

        // }
    }

    /*
     * EFFECTS: displays the menu to the console
     */
    private void displayMenu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("m: make     a new configuration.");
        System.out.println("s: save     current state of render and make it into a configuration.");
        System.out.println("g: generate from an existing configuration.");
        System.out.println("d: delete   an existing configuration.");
        System.out.println("e: exit     the app.");
        System.out.println("-------------------------------------------------------------------------");

    }


    /*
     * REQUIRES: configName == String
     *           iterations == int
     *           renderWidth == int
     *           renderHeight == int
     *           real_start == double
     *           real_end == double
     *           imag_start == double
     *           imag_end == double
     *           zoomScale == double
               
     * MODIFIES: configList
     * EFFECTS: checks if configuration with given input name exists, otherwise, it creates
     *          a new Configuration object and puts it into configList. If name exists, 
     *          it prints an error message.
     */

    private void makeNewConfiguration() {

        System.out.println("Enter the name of the new configuration(string):");

        userInput = scanner.nextLine();

        if (configList.doesConfigExist(userInput)) {
            System.out.println("Error, configuration name already exists.");
        } else {
            System.out.println("██ NOTE: render width and render height must be of the same ratio");
            System.out.println("██ as the real and imaginary start and ends in order for");
            System.out.println("██ the image to not look warped.\n");
            String configName = userInput;

            // Make this into a helper method call, so this can turn into one line
            int iteration = getNextInt("Enter the number of iterations(int):");
            int renderWidth = getNextInt("Enter the render width(int):");
            int renderHeight = getNextInt("Enter the render height(int):");
            double realStart = getNextDouble("Enter the real start(double):");
            double realEnd = getNextDouble("Enter the real end(double):");
            double imagStart = getNextDouble("Enter the imaginary start(double):");
            double imagEnd = getNextDouble("Enter the imaginary end(double):");
            double zoomScale = getNextDouble("Enter the zoom scale(double):");
            scanner.nextLine();

            Configuration newConfig = new Configuration(configName, iteration, renderWidth, renderHeight, 
                                                        realStart, realEnd, imagStart, imagEnd, zoomScale);
            configList.addConfiguration(newConfig);
        }
    }

    /*
    * REQUIRES: scanner be instantiated
     * MODIFIES: scanner
     * EFFECTS: prints out the next prompt, and get the user input as an integer.
     */
    private int getNextInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    /*
    * REQUIRES: scanner be instantiated
     * MODIFIES: scanner
     * EFFECTS: prints out the next prompt, and gets the user input as a double.
     */
    private double getNextDouble(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    /*
     * EFFECTS: saves the configurations of the current state from the renderer as a config.
     */
    private void saveCurrentConfiguration() {
        System.out.println("What do you want to save this configuration as? :");
        userInput = scanner.nextLine();

        if (configList.doesConfigExist(userInput)) {
            System.out.println("This configuration name already exists.");
        } else {
            configList.addConfiguration(renderer.getCurrentConfiguration());
            System.out.println("Sucessfully added current state as an entry.");
        }
    }
    
    /*
     * MODIFIES: renderer
     * EFFECTS: finds the configuration name, if it exists, and generates the set from that configuration.
     */
    private void generateFromExistingConfiguration() {
        System.out.println("Enter configuration name:");
        userInput = scanner.nextLine();

        if (configList.doesConfigExist(userInput)) {
            renderer = new Renderer(configList.getConfiguration(userInput));
            renderer.renderSet();
            displaySet(renderer.getSet());
            System.out.println("Sucessfully rendered selected configuration.");
        } else {
            System.out.println("This configuration name doesn't exist.");
        }
    }

    /*
     * MODIFIES: configList
     * EFFECTS: deletes a configuration if it matches the given input string.
     */
    private void deleteExistingConfiguration() {
        System.out.println("Enter the name of the configuration to be deleted: ");
        userInput = scanner.nextLine();

        if (configList.doesConfigExist(userInput)) {
            configList.removeConfiguration(userInput);
            System.out.println("Sucessfully removed configuration.");
        } else {
            System.out.println("Configuration does not exist.");
        }
    }

    /*
     * EFFECTS: prints an invalid command statement.
     */
    private void invalidCommandPrompt() {
        System.out.println("Invalid command. Try again.");
    }

    /*
     * Make a method that effectively takes the current parameter, takes a copy of it, 
     * and zooms the complex plane coordinates, and gives that to the renderer to re-render.
     * It should take a parameter of how much to zoom by.
     */

    //  public void zoom(double zoomScale){

    //  }

    /*
     * REQUIRES: renderer be set
     * EFFECTS: displays the set, using the data from the rederObj in a 2D boolean array.
     * In Phase 1, I'm printing out the set using symbols. 
     */
    private void displaySet(boolean[][] renderObj) {

        for (int h = 0; h < renderer.getHeight(); h++) {
            String currentRow = "";
            for (int w = 0; w < renderer.getWidth(); w++) {
                if (renderObj[h][w]) {
                    currentRow = currentRow + "██";
                } else {
                    currentRow = currentRow + " `";
                }  
            }
            System.out.println(currentRow);
        }
    }
}
