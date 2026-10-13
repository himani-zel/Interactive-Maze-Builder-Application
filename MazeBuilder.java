import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MazeBuilder {
    private JLabel modeLabel;
    /*
     * Constructs the main GUI window
     * Sets up all Swing components (buttons, labels, radio buttons)
     * and connects them to the grid so the user can interact with the maze.
     */
    public MazeBuilder(){
        JFrame frame = new JFrame("Maze Builder");
        frame.setSize(600,700);
        frame.setLayout(null); //no layout manager
        
        JLabel titleLabel = new JLabel("Maze Builder: Build Your Own Maze!");
        titleLabel.setBounds(125,15,400,30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel);
        
        Grid panel = new Grid();
        panel.setMode(0);
        frame.add(panel);

        //clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(20, 70, 80, 30);
        frame.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.clearGrid();
            }
        });

        modeLabel = new JLabel("Mode: Wall");
        modeLabel.setBounds(480, 70, 150, 30);
        frame.add(modeLabel);

        //radio buttons (wall, start, end, erase)
        JRadioButton wallBox = new JRadioButton("Wall");
        wallBox.setBounds(120, 70, 70, 30);
        JRadioButton startBox = new JRadioButton("Start");
        startBox.setBounds(200, 70, 80, 30);
        JRadioButton endBox = new JRadioButton("End");
        endBox.setBounds(280, 70, 80, 30);
        JRadioButton eraseBox = new JRadioButton("Erase");
        eraseBox.setBounds(360, 70, 80, 30);

        //grouping them (so only one selectable)
        ButtonGroup group = new ButtonGroup();
        group.add(wallBox); 
        group.add(startBox);
        group.add(endBox);
        group.add(eraseBox);
        wallBox.setSelected(true); //default or like initial selection (mode =0)
        
        //listeners (wall, start, end, erase)
        wallBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                modeLabel.setText("Mode: Wall");
                panel.setMode(0); //method created in Grid.java
            }
        }); 
        startBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                modeLabel.setText("Mode: Start");
                panel.setMode(1);
            }
        }); 
        endBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                modeLabel.setText("Mode: End");
                panel.setMode(2);
            }
        }); 
        eraseBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                modeLabel.setText("Mode: Erase");
                panel.setMode(3);
            }
        });
        //add all to frame
        frame.add(wallBox);
        frame.add(startBox);
        frame.add(endBox);
        frame.add(eraseBox);

        JLabel sizeLabel = new JLabel("Change Grid Size: ");
        sizeLabel.setBounds(60,600,150,30);
        frame.add(sizeLabel);

        //grid size buttons (to select grid size) 
        JButton size10 = new JButton("10 x 10");
        size10.setBounds(185,600,100,30);
        JButton size20 = new JButton("20 x 20");
        size20.setBounds(305,600,100,30);
        JButton size30 = new JButton("30 x 30");
        size30.setBounds(425,600,100,30);
        //listeners for these buttons
        size10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.setGridSize(10,10);
            }
        });
        size20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.setGridSize(20,20);
            }
        });
        size30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.setGridSize(30,30);
            }
        });
        //adding to frame
        frame.add(size10);
        frame.add(size20);
        frame.add(size30);
        //displaying, setting to be visible
        frame.setVisible(true);
    }
}