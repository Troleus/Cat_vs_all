import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Monsters implements Runnable{

    public boolean isDead;
    public boolean isFight;

    private int X = 1300;
    private int Y = 575;
    public static int speed = 0;
    private int width = 20;
    private int height = 20;
    private int monsterDist = 0;

    Thread monsterFabric = new Thread(this);
    ArrayList<Monsters> enemy = new ArrayList<>();
    Player player;

    Image flower = new ImageIcon("images/flower.gif").getImage();

    public void monsterUpdate(){
        if(Player.isRight == true && GameBack.getSpeed() > 0) {
            X -= speed;
        } else if(Player.isRight == false && GameBack.getSpeed() < 0) {
            X += speed;
        }
    }

    public void monsterDraw(Graphics2D g){
        g.drawImage(flower, X, Y, null);
    }

    public Rectangle getRect(){
        return new Rectangle(X, Y, width, height);
    }

    @Override
    public void run() {
        if(GameBack.distance - monsterDist == 1000) {
            enemy.add(new Monsters());
            monsterDist += 1000;
        }
        if(X < 0){
            enemy.remove(this);
        }
    }

    public  void testCollisionWithMonster(){
        for (Monsters monster: enemy){
            if(player.getRect().intersects(monster.getRect())){
                player.isDead = true;
            }
        }
    }
}
