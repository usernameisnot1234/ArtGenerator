
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
    private ArrayList<Coordinate> coordinates = new ArrayList<>();
    public DrawPanel(MainFrame mainFrame){
        int width = mainFrame.getWidth();
        int height = mainFrame.getHeight();
        //Mandelbrot set ranges
        double minReal = -2.5;
        double maxReal = 1;
        double minImag = -1;
        double maxImag = 1;
        for(int x = 0; x <= mainFrame.getWidth(); x++){
            for(int y = 0; y <= mainFrame.getHeight(); y++){
                double real = minReal + x * (maxReal - minReal)/(width -1);
                double imaginary = minImag + y * (maxImag - minImag)/(height -1);
                double baseX = 0.0;
                double baseY = 0.0;
                int count = 0;
                int maxIterations = 1000;
                while((real*real + imaginary * imaginary) <= 4 && count <= maxIterations){
                    double xtemp = baseX*baseX + baseY * baseY;
                    baseY = 2*baseX*baseY + imaginary;
                    baseX = xtemp;
                    maxIterations++;
                }
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
