import java.awt.*;
/**
 * Created by Logan on 6/9/2017.
 */
class Ball {
    private static double xVel, yVel, x, y;
    boolean restart = false;
    private int WIDTH = 20, HEIGHT = 20;

    Ball(Paddle p) {
        y = p.getY() - HEIGHT/2;
        x = p.getX();
        xVel = 0;
        yVel = 0;
        restart = true;
    }

    void checkCollision(Paddle p) {
        if(y > p.getY() - HEIGHT/2) {
            if (x >= p.getX() - 2 && x <= p.getX() + p.getWidth() + 2) {
                yVel = -yVel;
            } else {
                y = p.getY() - HEIGHT/2;
                x = p.getX();
                xVel = 0;
                yVel = 0;
                restart = true;
            }
        }
    }

    void launchBall() {
        xVel = -3;
        yVel = -5;
        restart = false;
    }

    void move(Paddle p) {
        x += xVel;
        y += yVel;

        if(x < WIDTH/2 - 5 || x > BrickBreaker.getFrameWidth() - WIDTH/2 - 10) {
            xVel = -xVel;
        } else if (y < HEIGHT/2 + 5) {
            yVel = -yVel;
        }
        if(restart) {
            x = p.getX() + p.getWidth()/2;
        }
    }

    void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)x - WIDTH/2, (int)y - HEIGHT/2, WIDTH, HEIGHT);
    }

    int getWidth() { return WIDTH; }
    int getHeight() { return HEIGHT; }
    double getX() { return x; }
    double getY() { return y; }
    double getxVel() { return xVel; }

    void setxVel(double newXVelocity) { yVel = newXVelocity; }

    double getyVel() { return yVel; }

    void setyVel(double newYVelocity) { yVel = newYVelocity; }
}