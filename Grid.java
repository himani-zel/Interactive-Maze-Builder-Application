import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grid extends JPanel{
    private int rows = 20;
    private int cols = 20;
    private int[][] grid = new int[rows][cols]; //store cells
    private int mode = 0; //0=wall, 1=start, 2=end, erase=3
    /*
     * Sets the current drawing mode (wall, start, end, or erase).
     * This determines what happens when the user clicks on the grid.
     */
    public void setMode(int m){ //setter for mode
        mode = m;
    }
    /*
     * Returns the current drawing mode.
     * Used to check what type of object should be placed on the grid
     */
    public int getMode(){ //getter for mode
        return mode;
    }
    /*
     * Initializes the grid panel and attaches a mouse listener.
     * The mouse listener allows the user to click on cells to modify them.
     */
    public Grid(){
        setBounds(50,130,500,450); 
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                int cellWidth = getWidth()/cols;
                int cellHeight = getHeight()/ rows;
                int c = e.getX()/cellWidth;
                int r = e.getY()/cellHeight;
                if(r>=0 && r<rows && c>=0 && c<cols){ //to make sure in bound (just in case)
                    //setting value based on mode (0=empty, 1=wall, 2=start, 3=end)
                    if(getMode() == 0){
                        grid[r][c] = 1; //which is wall
                    }
                    else if(getMode() == 1){
                        clearType(2); //removes old start (if there was one)
                        grid[r][c] = 2; //which is start
                    }
                    else if(getMode() == 2){
                        clearType(3); //removes old end (if there was one)
                        grid[r][c] = 3; //which is end
                    }
                    else if(getMode() == 3){
                        grid[r][c] = 0; //which is earse (white: background color)
                    }
                    repaint();
                }
            }
        });
    }
    /*
     * Updates the grid size and resets all cells.
     * This allows the user to switch between different grid dimensions.
     */
    public void setGridSize(int newRows, int newCols){
        rows= newRows;
        cols = newCols;
        grid = new int[rows][cols];
        repaint();
    }
    /*
     * Draws the grid and all maze elements.
     * Each cell is rendered using 2D graphics based on its type.
     * Rectangles drawn, filling in grid.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //draw grid
        int cellWidth = getWidth()/cols;
        int cellHeight = getHeight()/ rows;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                //drawing/filling cells
                if(grid[r][c] == 1){ //wall
                    g.setColor(Color.BLACK);
                    g.fillRect(c*cellWidth, r*cellHeight, cellWidth, cellHeight);
                }
                else if(grid[r][c] == 2){ //start
                    g.setColor(Color.GREEN);
                    g.fillRect(c*cellWidth, r*cellHeight, cellWidth, cellHeight);
                }
                else if(grid[r][c] == 3){ //end
                    g.setColor(Color.RED);
                    g.fillRect(c*cellWidth, r*cellHeight, cellWidth, cellHeight);
                }
                //grid lines
                g.setColor(Color.GRAY);
                g.drawRect(c*cellWidth, r*cellHeight, cellWidth, cellHeight);
            }
        }
    }
    /*
     * Removes all cells of a specific type (used for start and end points).
     * Ensures only one start and one end exist at a time.
     */
    private void clearType(int type){
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == type){
                    grid[r][c] = 0; //empty
                }
            }
        }
    }
    /*
     * Clears the entire grid by resetting all cells to empty.
     * Used when the user presses the clear button.
     */    public void clearGrid(){
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                grid[r][c] = 0; //empty
                
            }
        }
        repaint();
    }
}