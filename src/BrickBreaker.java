import javax.swing.*;
/**
 * Created by Logan on 6/9/2017.
 */
public class BrickBreaker extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 500;

    private BrickBreaker() {
        BrickBreakerPanel panel = new BrickBreakerPanel();
        getContentPane().add(panel);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Brick Breaker");
    }

    public static void main(String[] args) {
        new BrickBreaker();
    }

    static int getFrameWidth() { return WIDTH; }
    static int getFrameHeight() { return HEIGHT; }

}
