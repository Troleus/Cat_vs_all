import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable {

    public enum STATES{PLAY}
    public static STATES states = STATES.PLAY;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    public boolean running;

    private int FPS;
    private double millisToFPS;
    private int timer = FPS;
    private int sleepTime;
    private static Thread thread;

    private BufferedImage image;
    private Graphics2D g;
    private static String text = "Дистанция";

    GameBack gameBack = new GameBack();
    Player player = new Player();
    Listeners listeners = new Listeners();
    Monsters monsters = new Monsters();
    Earth earth = new Earth();
    ArrayList<Image> monsterList;

    public Panel(){
        super();
        setFocusable(true);
        requestFocus();
        monsters.monsterFabric.start();
        addKeyListener(new Listeners());
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        FPS = 30;
        millisToFPS = 1000/FPS;
        sleepTime = 0;

        monsterList = new ArrayList<>();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        monsterList.add(monsters.flower);

        running = true;

        while(running){

            if(states.equals(STATES.PLAY)){
                render();
                gameBack.update();
                update();
                gameDraw();
            }

            double timerFPS = System.nanoTime();
            timerFPS = (System.nanoTime() - timerFPS) / 1000000;
            if(millisToFPS > timerFPS){
                sleepTime = (int)(millisToFPS - timerFPS);
            } else {
                sleepTime = 1;
            }
            try {
                thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS = 0;
            sleepTime = 1;
        }
    }

    public void render() {
        gameBack.gameDraw(g);
        gameBack.textDraw(g);

        if (player.isJump == true) {
            player.jumpDraw(g);
        } else if (Player.isFight ) {
            player.fightDraw(g);
        } else if (player.isIdle){
            player.idleDraw(g);
        } else if(player.isDead){
            player.deadDraw(g);
            JOptionPane.showMessageDialog(null, "Вы проиграли");
            System.exit(1);
        } else {
            player.animDraw(g);
        }

        monsters.monsterDraw(g);

        text = (GameBack.distance + "");
    }

    public void update(){
        for(Image i : monsterList){
                if(player.getRect().intersects(monsters.getRect())){
                    player.isDead = true;
                }
        }
        gameBack.update();
        earth.update();
        player.update();
        if(player.isJump == true){
            player.jumpUpdate();
        } else {
            player.update();
        }
            monsters.monsterUpdate();

//        if(player.isUp == true || player.isDown == true && !player.isJump){
//            player.upToDownUpdate();
//        }
    }

    public void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }


}
