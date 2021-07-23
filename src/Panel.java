import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable {

    public enum STATES{PLAY}
    public static STATES states = STATES.PLAY;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    public boolean flyRun = false;

    private int FPS;
    private double millisToFPS;
    private int timer = FPS;
    private int sleepTime;
    private static Thread thread;

    private BufferedImage image;
    private Graphics2D g;

    GameBack gameBack = new GameBack();
    Listeners listeners = new Listeners();
    Player player = new Player();

    public Panel(){
        super();
        setFocusable(true);
        requestFocus();
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

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        while(true){

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

    public void render(){
        gameBack.gameDraw(g);

        if(player.isJump == true){
            player.jumpDraw(g);
        } else {
            player.animDraw(g);
        }
    }

    public void update(){
        gameBack.update();
        player.update();
        if(player.isJump == true){
            player.jumpUpdate();
        } else {
            player.update();
        }
    }

    public void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}
