import javax.swing.*;
import java.awt.*;

public class
Main {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame("SuperCat_vs_all");

        int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10);
        int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 5);

        Panel panel = new Panel();

        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setContentPane(panel);
        startFrame.setLocationRelativeTo(null);
        startFrame.pack();
        startFrame.setLocation(centerX, centerY);

        panel.start();

        startFrame.add(new Panel());
        startFrame.setVisible(true);

        startFrame.setSize(1000, 770);
    }
}
