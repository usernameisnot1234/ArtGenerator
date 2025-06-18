import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private ArrayList<Coordinate> coordinates = new ArrayList<>();

    public DrawPanel(MainFrame mainFrame) {
        int width = mainFrame.getWidth();
        int height = mainFrame.getHeight();
        
        // Mandelbrot set ranges()
        double minReal = -2.5;
        double maxReal = 1;
        double minImag = -1;
        //Proper scaling(mainly for the y)
        double aspectRatio = (double) height / width;
        double maxImag = minImag + (maxReal - minReal) * aspectRatio;
        
        int maxIterations = 1000;

        //Calculating for each pixel
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                //Making pixel/coordinate into complex number
                double real = minReal + x * (maxReal - minReal) / (width - 1);
                double imaginary = minImag + y * (maxImag - minImag) / (height - 1);
                
                double zx = 0.0;
                double zy = 0.0;
                int count = 0;
                //Performing z = z^2+c(or z = (zx^2-zy^2+2*zx*zy*i) + c)
                while (zx * zx + zy * zy <= 4 && count < maxIterations) {
                    double xtemp = zx * zx - zy * zy + real; //Real part
                    zy = 2 * zx * zy + imaginary; //Imaginary part
                    zx = xtemp;
                    count++;
                }

                //Color based on iterations
                Color color;
                if (count == maxIterations) {
                    color = Color.BLACK; 
                } else {
                    color = Color.getHSBColor((float) count / maxIterations, 1f, 1f);
                }
                coordinates.add(new Coordinate(x, y, color));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Drawing each coordinate
        for (Coordinate c : coordinates) {
            c.draw(g);
        }
    }
}