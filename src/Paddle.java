import java.awt.*;

/**
 * Created by Logan on 6/9/2017.
 */
class Paddle {
    private double x, xVel;
    private boolean rightAccel, leftAccel;
    private int y;
    private static final int PADDLE_WIDTH = 70, PADDLE_HEIGHT = 15;

    Paddle() {
        rightAccel = false; leftAccel = false;
        y = BrickBreaker.getFrameHeight() - 75;
        x = BrickBreaker.getFrameWidth()/2;
        xVel = 0;
    }

    int getWidth() {
        return PADDLE_WIDTH;
    }

    int getY() {
        return y;
    }

    void move() {
        if(rightAccel) {
            xVel += 2;
        } else if (leftAccel) {
            xVel -= 2;
        } else {
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

    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    void setRightAccel(boolean input) {
        rightAccel = input;
    }

    void setLeftAccel(boolean input) {
        leftAccel = input;
    }

    int getX() {
        return (int)x;
    }
}
