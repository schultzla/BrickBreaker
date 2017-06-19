import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Logan on 6/9/2017.
 */
class BrickBreakerPanel extends JPanel implements Runnable, KeyListener {
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;

    BrickBreakerPanel() {
        paddle = new Paddle();
        ball = new Ball(paddle);
        bricks = new Brick[15];
        int y = 20, x = 38;
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            x = 38;
            for(int j = 0; j < 5; j++) {
                bricks[counter] = new Brick(x, y);
                counter++;
                x += 65;
            }
            y += 25;
        }
        setFocusable(true);
        addKeyListener(this);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void update(Graphics g) {
        paint(g);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        ball.draw(g);
        paddle.draw(g);
        for(int i = 0; i < bricks.length; i++) {
            bricks[i].draw(g);
        }
    }


    @Override
    public void run() {
        while(true) {
            paddle.move();
            ball.move(paddle);
            ball.checkCollision(paddle);
            for(Brick brick : bricks) {
                ball.checkBrickCollis(brick);
            }


            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.setRightAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.setLeftAccel(true);
        }

        if(ball.restart) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                ball.launchBall();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.setRightAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.setLeftAccel(false);
        }
    }

}
