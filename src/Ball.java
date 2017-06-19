import java.awt.*;
/**
 * Created by Logan on 6/9/2017.
 */
public class Ball {
    private static double xVel, yVel, x, y;
    public Ball() {
        x = BrickBreaker.getFrameWidth()/2;
        y = BrickBreaker.getFrameHeight()/2;
        xVel = 5;
        yVel = 5;
    }

    public void checkCollision(Paddle p) {

        if(y > p.getY() - 15) {
            if(x >= p.getX() && x <= p.getX() + p.getWidth()) {
                yVel = -yVel;
            } else {
                y = BrickBreaker.getFrameHeight()/2;
            }
        }




    }

    public void move() {
        x += xVel;
        y += yVel;

        if(x < 15 || x > BrickBreaker.getFrameWidth() - 20) {
            xVel = -xVel;
        } else if (y < 15) {
            yVel = -yVel;
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