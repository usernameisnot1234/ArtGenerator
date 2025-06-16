
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
    private ArrayList<Coordinate> coordinates = new ArrayList<>();
    public DrawPanel(MainFrame mainFrame){
        for(int x = 0; x <= mainFrame.getWidth(); x++){
            for(int y = 0; y <= mainFrame.getHeight(); y++){
                coordinates.add(new Coordinate(x, y, Color.BLACK));
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Coordinate c : coordinates){
            c.draw(g);
        }
    }
}
