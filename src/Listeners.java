import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener {

    Player player = new Player();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        double key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE){
            player.isJump = true;
        }

        double key1 = e.getKeyCode();
        if(key == KeyEvent.VK_D){
            GameBack.setSpeed(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        double key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            player.isJump = false;
        }

        double key1 = e.getKeyCode();
        if(key == KeyEvent.VK_D){
            GameBack.setSpeed(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
