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



    public void checkHealth(Ball b) {
        if(b.getTop() == getTop() || b.getBtm() == getBtm()) {
            if(b.getLeft() > x || b.getLeft() < getWidthArea()) {
                if(b.getRight() > x || b.getRight() < getWidthArea()) {
                    health -= 50;
                    b.setyVel(-(b.getyVel()));
                }
            }
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public void draw(Graphics g) {
        if(health == 100) {
            g.setColor(Color.black);
        } else if (health <= 50) {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getTop() {
        return (int)y + HEIGHT;
    }
    public int getBtm() {
        return (int)y;
    }
    public int getWidthArea() {
        return (int)x + WIDTH;
    }
}
