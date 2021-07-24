import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {

    public static boolean isJump;
    public static boolean J1;
    public static boolean J2;
    public static boolean isRight;
    public static boolean isIdle;

    ArrayList<String> listR = new ArrayList<>();
    ArrayList<String> listL = new ArrayList<>();

    private int XJump = 450;
    private int YJump = 560;
    private int time = 10;
//    private int Ptime = 10;
    private int speed = 1;
//    private int Pspeed = 1;
    public int distance = 0;
    private String address;

    static Image jumpR = new ImageIcon("images/cat_jump_r.gif").getImage();
    static Image jumpL = new ImageIcon("images/cat_jump_l.gif").getImage();
    static Image idleR = new ImageIcon("images/cat_idle_r.gif").getImage();
    static Image idleL = new ImageIcon("images/cat_idle_l.gif").getImage();

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
//        Ptime++;

        if(isJump == true){
            if(YJump >= 450 && J1 == false){
                YJump = YJump - (time * speed);
            } else if(J2 == false){
                J1 = true;

                YJump = YJump + (time * speed);

                if(YJump >= 550){
                    speed = 1;
//                    Pspeed = 1;
                    time = 10;
//                    Ptime = 10;
                    J1 = true;
                    J2 = true;

                    isJump = false;
                }
            }

            if(isJump == false){
                J1 = false;
                J2 = false;
            }
        }
    }

    public void jumpDraw(Graphics2D g){
        if(isRight) {
            g.drawImage(jumpR, XJump, YJump, null);
        } else {
            g.drawImage(jumpL, XJump, YJump, null);
        }
    }

    public void idleDraw(Graphics2D g){
        if(isIdle && !isJump) {
            if (isRight) {
                g.drawImage(idleR, XJump, YJump, null);
            } else {
                g.drawImage(idleL, XJump, YJump, null);
            }
        }
    }

    public void animDraw(Graphics2D g){
        g.drawImage(new ImageIcon(address).getImage(), XJump, YJump, null);

    }
}
