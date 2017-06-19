import java.awt.*;
/**
 * Created by Logan on 6/9/2017.
 */
class Ball {
    private static double xVel, yVel, x, y;
    boolean restart = false;

    Ball(Paddle p) {
        y = p.getY() - 10;
        x = p.getX();
        xVel = 0;
        yVel = 0;
        restart = true;
    }

    void checkCollision(Paddle p) {
        if(y > p.getY() - 10) {
            if (x >= p.getX() - 2 && x <= p.getX() + p.getWidth() + 2) {
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

    void checkBrickCollis(Brick b) {
        if(y < b.getY() + b.getHeight() + 15) {
            if(x >= b.getX() - 15 && x <= b.getX() + b.getWidth() + 15) {
                yVel = -yVel;
                if(b.getHealth() > 0) {
                    b.updateHealth();
                }
            }
        }
    }

    void launchBall() {
        xVel = -4;
        yVel = -5;
        restart = false;
    }

    void move(Paddle p) {
        x += xVel;
        y += yVel;

        if(x < 15 || x > BrickBreaker.getFrameWidth() - 20) {
            xVel = -xVel;
        } else if (y < 15) {
            yVel = -yVel;
        }
        if(restart) {
            x = p.getX() + p.getWidth()/2;
        }
    }

    void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }
}