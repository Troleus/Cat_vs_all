import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener {

    Player player = new Player();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        double keySPACE = e.getKeyCode();
        if(keySPACE == KeyEvent.VK_SPACE){
            player.isJump = true;
        }

        double keyD = e.getKeyCode();
        if(keyD == KeyEvent.VK_D){
            Player.isRight = true;
            Player.isIdle = false;
            GameBack.setSpeed(5);
        }

        double keyA = e.getKeyCode();
        if(keyA == KeyEvent.VK_A){
            Player.isRight = false;
            Player.isIdle = false;
            GameBack.setSpeed(-5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        double keyD = e.getKeyCode();
        if(keyD == KeyEvent.VK_D){
            Player.isIdle = true;
            GameBack.setSpeed(0);
        }

        double keyA = e.getKeyCode();
        if(keyA == KeyEvent.VK_A){
            Player.isIdle = true;
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
