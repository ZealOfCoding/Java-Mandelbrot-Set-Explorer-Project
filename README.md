// MARKDOWN SYNTAX GUIDE  https://www.markdownguide.org/basic-syntax/

# My Personal Project idea 1: Mandelbrot Set Viewer

## Task 1 Motivation & Explanation of project
I'm creating my own implementation of a **Mandelbrot Set Viewer**, which has been implemented as a coding project my many others
on the internet. It's a fractal pattern, that's mapped out onto a complex plane, which is related to the cartesian plane. The Mandelbrot Set is drawn by calculating the color of a pixel on this plane. A specific recursive mathematical formula is used that takes in the coordinates of a pixel as the input. If after X iterations of the formula, it's value explodes to a very large number(after some arbitrary definition of "infinity"), the pixel can be colored white. If it doesn't reach that threshold, it can be colored black. 

My class `X` will be a configuration of values and settings of how to draw the mandelbrot set at a given **iteration**, **window size**, **zooming in/out scale**, and **location on the graph**.(consider color pallete value?)

My class `Y` will be the collection of all the Mandelbrot Set *configurations* that the user can choose from. Each *configuration* will have it's own name. The user could make their own, or select from some presets. 

## Task 2: Proposal

#### 1. What will the application do?
- It will generate a rendering of the Mandelbrot Set in a window. There will be a control panel on the side that allows you to enter in parameters to modify how the
set is generated. It will also have the ability to save the current parameters, and load saved parameters, as well as any presets. 

#### 2. Who will use it?
- Any curious user who is interested in knowing more about how fractals operate, their intricacies in the structure. Perhaps people who are nerdy about fractals, like mathematicians, or people in the Computer Sciences. 

#### 3. Why is this project of interest to you?
- I first stumbled upon the idea on YouTube, and was intrigued by the nature of the complexity of the **Mandelbrot Set**, and how it's pattern recursively appears the deeper you zoom into the image. It was interesting enough that I decided to try coding this project as my high school capstone project. I utilized a simpler programming language called _**Processing**_. Since it was rather simple, I couldn't add that much functionality. Plus, it was rather slow to run. I'd like to improve upon it, and make a higher quality version of that program in Java, with more features to improve the user experience of my previous project. 

## Task 3: User Stories

#### As the user, I want them to be able to:

- Modify the parameters in a side control panel
    - Modify the number of iterations
    - Change the location
    - Zoom in and out of the image at a given scaler value(EX: 2x, 10x, 100, etc)

- Render an image of the set in a window

- Save a copy of the parameters that the user has currently inputed into a configuration.
- Save the list of configurations that have been created by the user in the current session to a file. When the user 
    closes the program, if there are configurations that have been currently created in the session, the
    program will ask the user if they want to save the current configurations in a file. If not, the configurations will be lost. 

- Load a copy of parameters from a list(either user created or presets) and render an image. 
- Load previous configurations from a previous session by prompting the user first when they open the program, if they 
    so choose. Otherwise, the program will just load up a default configuration.

________________________________________________________________________________


## ALL OTHER IDEAS(will stick to the Mandelbrot Set Viewer most likely...)
- Mandelbrot Set Viewer
    - X: A configuration of settings & values
    - Y: A list of configurations, and presets
- Calendar
    - X: Events in a calendar
    - Y: Calendar for person A
- Typing speed logger/accuracy assessment
    - X: A log of a typing record of X minutes
    - Y: List of all logs of typing records for the user A
- drum beat maker
    - X: a recording of a drum beat
    - Y: List of drum beat recordings of user A

__________________________________________________________________________________

# Instructions for End User

1. You can enter parameters in the Manual Inputs Panel's fields of how to generate the image:
    - Iteration
    - Real Start
    - Real End
    - Imaginary Start
    - Imaginary End

    Then, you can click the "GENERATE" button to render the image in the Display Panel on the right(visual component). 

2. To save a configuration, the above mentioned fields must have a valid number for the parameter, and there exists a name entered in the "configuration name..." field. Then, you can press "Add Configuration" at the bottom of the Interface Panel to save it into the scroll pane, as a button, along with the default button that's always there. 

3. To delete a configuration, enter the name of the desired configuration to delete. It must exist in the scroll pane. Press "Delete Configuration" to delete it. 

4. To save the current list of configurations from the scroll pane onto your device, press "Save Current Workspace", which will save it to a json file locally in your device. 

5. To load the saved list of configurations into the scroll pane, click "Load Saved Workspace" to load from the json file. 

6. To zoom into the image manually using the display panel alone, first generate a default image (it can be anything, but i'd suggest using the default configuration as a starter). Then, enter a zoom scale factor in the "Zoom Scale" field. Position your cursor over the point on the image that you want to zoom into. Then, press the up arrow key on your keyboard. It should zoom into the image at a scale determined by the field in "Zoom Scale". 

7. To zoom out of the image, do the same as above, but press the down arrow. 

# Phase 4: Task 2
## An example representative log of typical events in the program:

    --------------------------------
    EVENT LOG:
    --------------------------------
    Mon Nov 25 22:54:37 PST 2024
    Rendered "null" to the DisplayPanel


    Mon Nov 25 22:54:44 PST 2024
    Rendered "" to the DisplayPanel


    Mon Nov 25 22:54:49 PST 2024
    Added new configuration  "zoom1" to ConfigurationList


    Mon Nov 25 22:54:54 PST 2024
    Rendered "" to the DisplayPanel


    Mon Nov 25 22:55:00 PST 2024
    Added new configuration  "zoom2" to ConfigurationList


    Mon Nov 25 22:55:15 PST 2024
    Rendered "zoom1" to the DisplayPanel


    Mon Nov 25 22:55:21 PST 2024
    Removed configuration  "zoom2" from ConfigurationList


    --------------------------------
    END OF LOGGED EVENTS
    --------------------------------

# Phase 4: Task 3
## Ways that Project Could Be Improved

    1. The tasks that each panel does could be redone to be more specific. ManualInputsPanel is currently handling the generate button, setting the zoom scale, and providing the user with information pop ups. I could put the generate button, information pop ups, and setting zoom into their own panels. 
    A similar concern applies for ConfigurationPanel. the ScrollPane of configurations and the buttons & configuration name entry could be seperated into their own panels. 

    2. A different design choice to replace the mediator. Although it makes communication between the classes simpler, the mediator class itself can get a bit messy with dozens of calling methods. 

    3. Improving flexibility to add new changes. Other changes of interest would be to add color rendering. Some changes would have to be made to the math logic that renders the set. It also would require redesigning how the set saves the data, as it's only being saved as a boolean array. That doesn't give much flexiblity to save color values. 

    4. Using the Singleton Pattern for my ConfigurationList class, since I only ever want one instance of the class that always is consistently used among all the other classes. It would simplify the code, decreasing clutter. 
