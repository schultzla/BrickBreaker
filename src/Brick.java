import java.awt.*;

/**
 * Created by Logan on 6/9/2017.
 */
class Brick {
    private static final int WIDTH = 60, HEIGHT = 20;
    private int x, y;
    private int health;

    Brick(int x, int y) {
        this.x = x;
        this.y = y;
        health = 100;
    }



    void updateHealth() {
        health -= 50;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getWidth() {
        return WIDTH;
    }

    int getHeight() { return HEIGHT; }

    int getHealth() { return health; }

    void draw(Graphics g) {
        if(health == 100) {
            g.setColor(Color.black);
            g.fillRect(x, y, WIDTH, HEIGHT);
        } else if (health <= 50) {
            g.setColor(Color.red);
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }
}
