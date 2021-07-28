import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.util.ArrayList;

public class GameBack{

    static Image back1 = new ImageIcon("images/background.png").getImage();
    static Image back2 = new ImageIcon("images/background.png").getImage();

    private static int XMove1;
    private static int XMove2 = 1200;

    private static int speed = 0;
    public static int distance = 0;

    Player player;

    public static void setSpeed(int speed) {
        GameBack.speed = speed;
    }

    public static int getSpeed() {
        return speed;
    }

    Image [] imageAddress = {back1, back2};

    public void gameDraw(Graphics2D g){
        g.drawImage(imageAddress[0], XMove1, 0, null);
        g.drawImage(imageAddress[1], XMove2, 0, null);
    }

    public void textDraw(Graphics2D g){
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.ITALIC, 50);
        g.setFont(font);
        g.drawString(String.valueOf("Дистанция = " + (GameBack.distance + GameBack.getSpeed())), 10, 130);
    }

    public void update(){
        XMove1 -= speed;
        XMove2 -= speed;
        distance += speed;

            if (XMove1 == -1200) {
                XMove1 = 0;
            }

            if (XMove2 == 0) {
                XMove2 = 1200;
            }
    }
}
