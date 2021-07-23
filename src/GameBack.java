import javax.swing.*;
import java.awt.*;

public class GameBack {

    static Image back1 = new ImageIcon("images/background.png").getImage();
    static Image back2 = new ImageIcon("images/background.png").getImage();

    private static int XMove1;
    private static int XMove2 = 1200;
    private static int speed = 0;

    public static void setSpeed(int speed) {
        GameBack.speed = speed;
    }

    Image [] imageAdress = {back1, back2};

    public void gameDraw(Graphics2D g){
        g.drawImage(imageAdress[0], XMove1, 0, null);
        g.drawImage(imageAdress[1], XMove2, 0, null);
    }

    public void update(){

        XMove1 -= speed;
        XMove2 -= speed;

        if(XMove1 == -1200){
            XMove1 = 0;
        }

        if(XMove2 == 0){
            XMove2 = 1200;
        }
    }
}
