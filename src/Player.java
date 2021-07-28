import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {

    public static boolean isJump;
    public static boolean J1;
    public static boolean J2;
    public static boolean isRight = true;
    public static boolean isIdle = true;
    public static boolean isFight;
    public boolean isDead;
    public static boolean isUp;
    public static boolean isDown;
    private int width = 20;
    private int height = 20;

    ArrayList<String> listR = new ArrayList<>();
    ArrayList<String> listL = new ArrayList<>();

    private int X = 450;
    private int Y = 560;
    private int time = 10;
    private int speed = 1;
    private String address;
    Monsters monsters;

    static Image jumpR = new ImageIcon("images/cat_jump_r.gif").getImage();
    static Image jumpL = new ImageIcon("images/cat_jump_l.gif").getImage();
    static Image idleR = new ImageIcon("images/cat_idle_r.gif").getImage();
    static Image idleL = new ImageIcon("images/cat_idle_l.gif").getImage();
    static Image fightR = new ImageIcon("images/cat_a5_r.gif").getImage();
    static Image fightL = new ImageIcon("images/cat_a5_l.gif").getImage();
    static Image deadR = new ImageIcon("images/cat_die_r.gif").getImage();
    static Image deadL = new ImageIcon("images/cat_die_l.gif").getImage();

    public int anim;

    public Player(){
        listR.add("images/cat_walk_r.gif");
        listL.add("images/cat_walk_l.gif");
    }

    public void update(){
        anim ++;
        if(anim >= listR.size()){
            anim = 0;
        }
        if(isRight) {
            address = listR.get(anim);
        } else {
            address = listL.get(anim);
        }
    }

    public void jumpUpdate(){
        time++;

        if(isJump == true){
            if(Y >= 450  && J1 == false){
                Y = Y - (time * speed);
            } else if(J2 == false){
                J1 = true;

                Y = Y + (time * speed);

                if(Y >= 560){
                    speed = 1;
                    time = 10;
                    J1 = true;
                    J2 = true;
                    isJump = false;
                    Y = 560;
                }
            }

            if(isJump == false){
                J1 = false;
                J2 = false;
            }
        }
    }

//    public void upToDownUpdate(){
//        if(isUp && !isDown) {
//            if (Y >= 560 && Y <= 670) {
//                Y = Y - (time * speed);
//            }
//        } else if(isDown && !isUp){
//            if (Y >= 560 && Y <= 670) {
//                Y = Y + (time * speed);
//            }
//        }
//    }

    public void jumpDraw(Graphics2D g){
        if(isRight) {
            g.drawImage(jumpR, X, Y, null);
        } else {
            g.drawImage(jumpL, X, Y, null);
        }
    }

    public void idleDraw(Graphics2D g){
        if(isIdle && !isJump) {
            if (isRight) {
                g.drawImage(idleR, X, Y, null);
            } else {
                g.drawImage(idleL, X, Y, null);
            }
        }
    }

    public void fightDraw(Graphics2D g){
        if(isFight && !isJump) {
            if (isRight) {
                g.drawImage(fightR, X, Y, null);
            } else {
                g.drawImage(fightL, X, Y, null);
            }
        }
    }

    public void deadDraw(Graphics2D g){
        if(isRight && isDead){
            g.drawImage(deadR, X, Y, null);
        }
        if(!isRight && isDead){
            g.drawImage(deadL, X, Y, null);
        }
    }

    public void animDraw(Graphics2D g){
        g.drawImage(new ImageIcon(address).getImage(), X, Y, null);
    }

    public Rectangle getRect(){
        return new Rectangle(X, Y, width, height);
    }
}
