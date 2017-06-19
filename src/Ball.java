import java.awt.*;
import java.util.Random;
/**
 * Created by Logan on 6/9/2017.
 */
public class Ball {
    private static double xVel, yVel, x, y;
    private Random r = new Random();
    public boolean restart = false;

    public Ball(Paddle p) {
        y = p.getY() - 10;
        x = p.getX();
        xVel = 0;
        yVel = 0;
        restart = true;
    }

    public void checkCollision(Paddle p) {
        if(y > p.getY() - 10) {
            if (x >= p.getX() && x <= p.getX() + p.getWidth()) {
                yVel = -yVel;
            } else {
                y = p.getY() - 10;
                x = p.getX();
                xVel = 0;
                yVel = 0;
                restart = true;
            }
        }
    }

    public void launchBall() {
        xVel = 5;
        yVel = -5;
        restart = false;
    }

    public void move(Paddle p) {
        if(restart) {
            checkCollision(p);
        } else {
            x += xVel;
            y += yVel;
        }

        if(x < 15 || x > BrickBreaker.getFrameWidth() - 20) {
            xVel = -xVel;
        } else if (y < 15) {
            yVel = -yVel;
        }
        if(restart) {
            x = p.getX() + p.getWidth()/2;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}