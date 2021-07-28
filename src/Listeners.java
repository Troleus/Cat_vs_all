import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener {

    Player player = new Player();
    Earth earth = new Earth();
    Monsters monster;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        double keySPACE = e.getKeyCode();
        if(keySPACE == KeyEvent.VK_SPACE && !player.isDead){
            player.isJump = true;
        }

        double keyD = e.getKeyCode();
        if(keyD == KeyEvent.VK_D && !player.isDead){
            player.isRight = true;
            player.isIdle = false;
            GameBack.setSpeed(5);
            Monsters.speed = 5;
        }

        double keyA = e.getKeyCode();
        if(keyA == KeyEvent.VK_A && !player.isDead){
            player.isRight = false;
            player.isIdle = false;
            if(GameBack.distance <= 130){
                GameBack.setSpeed(0);
            } else {
                GameBack.setSpeed(-5);
                Monsters.speed = 5;
            }
        }

        double keySHIFT = e.getKeyCode();
        if(keySHIFT == KeyEvent.VK_SHIFT && !player.isDead){
            Player.isFight = true;
        }

//        double keyW = e.getKeyCode();
//        if(keyW == KeyEvent.VK_W){
//            Player.isUp = true;
//        }
//
//        double keyS = e.getKeyCode();
//        if(keyS == KeyEvent.VK_S){
//            Player.isDown = true;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        double keyD = e.getKeyCode();
        if(keyD == KeyEvent.VK_D && !player.isDead){
            player.isIdle = true;
            GameBack.setSpeed(0);
            Monsters.speed = 0;
            Earth.speed = 0;
        }

        double keyA = e.getKeyCode();
        if(keyA == KeyEvent.VK_A && !player.isDead){
            player.isIdle = true;
            GameBack.setSpeed(0);
        }

        double keySHIFT = e.getKeyCode();
        if(keySHIFT == KeyEvent.VK_SHIFT && !player.isDead){
            Player.isFight = false;
        }

//        double keyW = e.getKeyCode();
//        if(keyW == KeyEvent.VK_W){
//            Player.isUp = false;
//        }
//
//        double keyS = e.getKeyCode();
//        if(keyS == KeyEvent.VK_S){
//            Player.isDown = false;
//        }
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
