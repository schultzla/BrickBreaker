import java.awt.*;

/**
 * Created by Logan on 6/9/2017.
 */
public class Brick {
    private static final int WIDTH = 60, HEIGHT = 20;
    private int x, y;
    private int health;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        health = 100;
    }

    public void checkHealth() {

    }

    public int getWidth() {
        return WIDTH;
    }

    public void draw(Graphics g) {
        if(health == 100) {
            g.setColor(Color.black);
        } else if (health == 50) {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
