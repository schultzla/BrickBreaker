import javax.swing.*;

/**
 * Created by Logan on 6/9/2017.
 */
public class BrickBreaker extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 700;

    public BrickBreaker() {
        BrickBreakerPanel panel = new BrickBreakerPanel(this);
        getContentPane().add(panel);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Brick Breaker");
    }

    public static void main(String[] args) {
        new BrickBreaker();
    }

    public static int getFrameWidth() { return WIDTH; }
    public static int getFrameHeight() { return HEIGHT; }

}
