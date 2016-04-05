import javax.swing.*;
import java.awt.*;

/**
 * Created by Jakub Tomczuk on 02.04.2016.
 */
public class Cube extends JPanel{

    Cube(){
        super();
        JFrame frame = new JFrame("Cube");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(440, 420));
        frame.add(this);
        frame.setVisible(true);
        frame.pack();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int flip = 280;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                Color c = new Color(255, j, i);
                g.setColor(c);
                // r
                g.fillRect(j + 25, getHeight() - (i + 25), 1, 1);
                c = new Color(i, j, 255);
                g.setColor(c);
                //g
                g.fillRect(j + 13 + flip / 2, getHeight() - (408 - i / 2), 1, 1);
                c = new Color(255 - j, 255, i);
                g.setColor(c);
                //b
                g.fillRect(j / 2 + 280, getHeight() - (i + j / 2 + 25), 1, 1);
            }
            flip--;
        }
        g.setColor(Color.WHITE);
    }
}
