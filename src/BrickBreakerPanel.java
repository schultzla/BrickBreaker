import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Logan on 6/9/2017.
 */
class BrickBreakerPanel extends JPanel implements Runnable, KeyListener {
    private Ball ball;
    private Paddle paddle;
    private int lives;
    private ArrayList<Brick> bricks;

    BrickBreakerPanel() {
        lives = 3;
        paddle = new Paddle();
        ball = new Ball(paddle);
        bricks = new ArrayList<Brick>();
        int y = 20, x = 38;
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            x = 38;
            for (int j = 0; j < 5; j++) {
                bricks.add(new Brick(x, y));
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
        if(bricks.size() == 0) {
            g.setColor(Color.red);
            g.drawString("You Won!", 10, 460);
        } else if (lives < 0) {
            g.setColor(Color.red);
            g.drawString("Out Of Lives!", 10, 460);
        } else {
            g.setColor(Color.black);
            ball.draw(g);
            paddle.draw(g);
            g.drawString("Lives: " + lives, 10, 460);
            for(Brick brick : bricks) {
                brick.draw(g);
            }
        }
    }

    @Override
    public void run() {
        while(true) {
            paddle.move();
            ball.move(paddle);
            ball.checkCollision(paddle);
            Iterator<Brick> it = bricks.iterator();
            while(it.hasNext()) {
                Brick brick = it.next();
                if (brick.getHealth() == 0) {
                    it.remove();
                } else {
                    brick.checkHit(ball);
                }
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
                lives--;
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
