import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {

    public static boolean isJump;
    public static boolean J1;
    public static boolean J2;

    ArrayList<String> list = new ArrayList<>();

    public int XJump = 250;
    public int YJump = 550;
    public int time = 10;
    public int Ptime = 10;
    public int speed = 1;
    public int Pspeed = 1;
    public String adress;

    static Image jump = new ImageIcon("images/cat_jump.gif").getImage();

    public int anim;

    public Player(){
        list.add("images/cat_walk.gif");
    }

    public void update(){
        anim ++;
        if(anim >= list.size()){
            anim = 0;
        }
        adress = list.get(anim);
    }

    public void jumpUpdate(){
        time++;
        Ptime++;

        if(isJump == true){
            if(YJump >= 450 && J1 == false){
                YJump = YJump - (time * speed);
            } else if(J2 == false){
                J1 = true;

                YJump = YJump + (time * speed);

                if(YJump >= 550){
                    speed = 1;
                    Pspeed = 1;
                    time = 10;
                    Ptime = 10;
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
        g.drawImage(jump, XJump, YJump, null);
    }

    public void animDraw(Graphics2D g){
        g.drawImage(new ImageIcon(adress).getImage(), XJump, YJump, null);

    }
}
