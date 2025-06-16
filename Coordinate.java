
import java.awt.Color;
import java.awt.Graphics;

public class Coordinate {
    private int x;
    private int y;
    private Color color;
    public Coordinate(int x, int y, Color c){
         this.x = x;
         this.y = y;
         this.color = c;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}
