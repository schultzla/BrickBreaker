import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Logan on 6/9/2017.
 */
public class BrickBreakerPanel extends JPanel implements Runnable, KeyListener {
    private BrickBreaker game;
    private Thread thread;
    private Ball ball;
    private Paddle paddle;

    public BrickBreakerPanel(BrickBreaker game) {
        this.game = game;
        ball = new Ball();
        paddle = new Paddle();

        setFocusable(true);
        addKeyListener(this);
        thread = new Thread(this);
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
    }

    @Override
    public void run() {
        while(true) {
            paddle.move();
            ball.move();
            ball.checkCollision(paddle);

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
