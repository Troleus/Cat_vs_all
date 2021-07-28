import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Earth {

    private int X = 0;
    private int Y = 590;

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    static Image back = new ImageIcon("images/Tile.png").getImage();

    public static int speed = 0;

    ArrayList<Image> img = new ArrayList<>();

    {
        for(int i = 0; i < 8; i++) {
            img.add(back);
        }
    }

    public void earthDraw(Graphics2D g){
        for (Image i : img) {
            g.drawImage(i, X, Y, null);
        }
//            g.drawImage(back, X, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 171, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 342, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 513, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 684, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 855, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 1026, Y, null);
//            g.drawImage(new ImageIcon("images/Tile.png").getImage(), X + 1197, Y, null);
    }

    public void update(){
        X -= speed;
    }
}
