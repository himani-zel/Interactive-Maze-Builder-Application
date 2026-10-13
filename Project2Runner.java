public class Project2Runner {
    /*
     * Name: Himani Patel <name>
     * Student ID: 501368425 <id>
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * This program is an interactive Maze Builder that lets the user design a maze on a given (change-able) grid. This grid
     * is displayed visually and the user can place different elements such as wall, a start point, and an end point by selecting 
     * a mode and clicking on cells (the mode is also displayed so the user is aware). Also, the user may erase certain cells 
     * if wanted with also the option to completely clear the whole grid. The interface is built using Swing components including 
     * buttons, labels, and radio buttons. A JPanel is used as a drawing canvas where the grid and all maze elements given 
     * by 2D graphics. The grid updates whenever the user interacts with it.
     * 
     * User interaction is handled through event listeners. Action listeners are used for buttons and radio buttons to change modes, 
     * clear the grid, and adjust grid sizes. A mouse listener is used to detect clicks on the grid and update the selected cell. These
     * interactions cause immediate updates to the JPanel.
     * 
     * Instructions for use:
     * - Select a mode (wall, start point, end point, or erase) using the radio buttons
     * - Then click on the grid to place or remove elements
     * - Use the clear button to reset the grid whenever you want
     * - Use the grid size buttons (10x10, 20x20, 30x30) to change the grid size which can change complexity 
     * This will let you create your own maze, which can even be solved later by others.
     *
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * This program uses Swing components to build the graphical user interface. A JFrame is created in MazeBuilder.java (line 18)
     * as the main window. Other components are also added to this frame. First, JLabels in MazeBuilder.java is for the title (line 22) 
     * to be displayed and mode (line 41) to be shown so user can clearly see which mode they are using at the moment. Also, the program 
     * includes JButtons in MazeBuilder.java for the "clear" button (line 32) to clear elements placed on the grid as a reset and 
     * grid sizes buttons (line 99) to change the grid based on preference for different complexities. Also, JRadioButtons are 
     * added in MazeBuilder.java for selecting one element such as wall (line 46), start (line 48), end (line 50), erase (line 52). 
     * These components let the user interact with the program by selecting modes, clearing the grid, keeping track of which mode is 
     * on, and changing the grid size. Each being meaningful in designing and controlling the process for maze building.
     *  
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * The program uses a custom JPanel for drawing, it is in Grid.java starting at line 7, where the Grid class extends JPanel. This panel
     * is added to the JFrame in MazeBuilder.java (line 27) and is for the canvas when making the maze. The paintComponent method is overriden to
     * draw the grid and fill each cell with different colors depending on the type (wall, start point, end point, etc.). Rectangles are drawn 
     * using the Graphics object to visually show each cell. This allows the user to see and interact with the maze in real time. 
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * The program includes both action listeners and a mouse listener. Action listeners are in MazeBuilder.java for all the radio buttons (starting
     * at line 64) and for the general size buttons (starting at line 106). These listeners let the user to clear the grid, change grid size, and 
     * switch modes. A mouse listener is applied in Grid.java inside the constructor (line 32) to detect mouse clicks on the grid. When the user 
     * clicks on a cell, the program updates the grid data and repaints the panel to show the change. These listeners make sure that user actions 
     * can be properly and meaningfully update te graphic display.
     * 
     * 
     */

    public static void main(String[] args) {
        new MazeBuilder();
    }
}
