
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
    public DrawPanel d;
    public static void run() throws InterruptedException{
        MainFrame gui = new MainFrame();
        SwingUtilities.invokeLater(() -> gui.createFrame(gui));
        synchronized (gui) {
            gui.wait();
        }
    }
    public void createFrame(Object semaphore){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d = new DrawPanel(this);
        d.setVisible(true);
        this.setVisible(true);
        synchronized (semaphore) {
            semaphore.notify();
        }
    }
}
