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
    private Brick[][] brick;

    public BrickBreakerPanel(BrickBreaker game) {
        this.game = game;
        brick = new Brick[3][5];
        paddle = new Paddle();
        ball = new Ball(paddle);
        int x = 38, y = 20;
        for(int i = 0; i < 3; i++) {
            x = 38;
            int spacing = 0;
            switch(i) {
                case 0:
                    spacing = 20;
                    break;
                case 1:
                    spacing = 45;
                    break;
                case 2:
                    spacing = 70;
                    break;
                default:
                    spacing = 0;
            }
            y = spacing;
            for(int j = 0; j < 5; j++) {
                brick[i][j] = new Brick(x, y);
                x += brick[i][j].getWidth() + 5;
            }
        }

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
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                brick[i][j].draw(g);
            }
        }
    }

    @Override
    public void run() {
        while(true) {
            paddle.move();
            ball.move(paddle);
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
