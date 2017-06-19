import java.awt.*;

/**
 * Created by Logan on 6/9/2017.
 */
public class Paddle {
    private double x, xVel;
    private boolean rightAccel, leftAccel;
    private int player, y;
    private final double FRICTION = 0.94;
    private final int PADDLE_WIDTH = 80, PADDLE_HEIGHT = 20;

    public Paddle() {
        rightAccel = false; leftAccel = false;
        y = BrickBreaker.getFrameHeight() - 75;
        x = BrickBreaker.getFrameWidth()/2;
        xVel = 0;
    }

    public int getWidth() {
        return PADDLE_WIDTH;
    }

    public int getY() {
        return y;
    }

    public void move() {
        if(rightAccel) {
            xVel += 2;
        } else if (leftAccel) {
            xVel -= 2;
        } else if (!leftAccel && !rightAccel) {
            xVel = 0;
        }

        if(xVel > 4) {
            xVel = 4;
        } else if (xVel < -4) {
            xVel = -4;
        }

        x += xVel;

        if(x < 0) {
            x = 0;
        } else if (x > BrickBreaker.getFrameWidth() - PADDLE_WIDTH - 5) {
            x = BrickBreaker.getFrameWidth() - PADDLE_WIDTH - 5;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void setRightAccel(boolean input) {
        rightAccel = input;
    }

    public void setLeftAccel(boolean input) {
        leftAccel = input;
    }

    public int getX() {
        return (int)x;
    }

    public static void log(Double d) {
        System.out.println(d);
    }

}
