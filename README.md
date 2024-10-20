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


# ALL OTHER IDEAS(will stick to the Mandelbrot Set Viewer most likely...)
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

