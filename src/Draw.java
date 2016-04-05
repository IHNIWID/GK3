import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;

/**
 * Created by Jakub Tomczuk on 02.04.2016.
 */
public class Draw extends JPanel {
    private boolean RGB;
    private boolean CMYK;
    private double R = 0;
    private double G = 0;
    private double B = 0;
    private double C = 0;
    private double M = 0;
    private double Y = 0;
    private double K = 1;
    private JTextField r;
    private JTextField g;
    private JTextField b;
    private JTextField c;
    private JTextField m;
    private JTextField y;
    private JTextField k;
    private Color color;

    Draw() {
        super();

        color = new Color((int) R, (int) G, (int) B);
        JFrame window = new JFrame("Converter");
        JPanel main = new JPanel();
        JPanel convertRGB = new JPanel(new GridLayout(3,2,40,20));
        JPanel convertCMYK = new JPanel(new GridLayout(4,2,40,20));
         r = new JTextField("0");
         g = new JTextField("0");
         b = new JTextField("0");
         c = new JTextField("0");
         m = new JTextField("0");
         y = new JTextField("0");
         k = new JTextField("1");
        //JButton torgb = new JButton();
        //JButton tocmyk = new JButton();

        Dimension standard = new Dimension(40,40);
        main.setPreferredSize(new Dimension(300,200));
        convertRGB.setPreferredSize(new Dimension (150,150));
        convertCMYK.setPreferredSize(new Dimension (150,150));
        r.setPreferredSize(standard);
        g.setPreferredSize(standard);
        b.setPreferredSize(standard);
        c.setPreferredSize(standard);
        m.setPreferredSize(standard);
        y.setPreferredSize(standard);
        k.setPreferredSize(standard);

        convertRGB.add(new JLabel("R: "));
        convertRGB.add(r);
        convertRGB.add(new JLabel("G: "));
        convertRGB.add(g);
        convertRGB.add(new JLabel("B: "));
        convertRGB.add(b);
        convertCMYK.add(new JLabel("C: "));
        convertCMYK.add(c);
        convertCMYK.add(new JLabel("M: "));
        convertCMYK.add(m);
        convertCMYK.add(new JLabel("Y: "));
        convertCMYK.add(y);
        convertCMYK.add(new JLabel("K: "));
        convertCMYK.add(k);

        r.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (tryParseInt(r.getText())) {
                    if (Integer.parseInt(r.getText()) >= 0 && Integer.parseInt(r.getText()) < 256) {
                        R = Integer.parseInt(r.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (tryParseInt(r.getText())) {
                    if (Integer.parseInt(r.getText()) >= 0 && Integer.parseInt(r.getText()) < 256) {
                        R = Integer.parseInt(r.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        g.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (tryParseInt(g.getText())) {
                    if (Integer.parseInt(g.getText()) >= 0 && Integer.parseInt(g.getText()) < 256) {
                        G = Integer.parseInt(g.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (tryParseInt(g.getText())) {
                    if (Integer.parseInt(g.getText()) >= 0 && Integer.parseInt(g.getText()) < 256) {
                        G = Integer.parseInt(g.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        b.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (tryParseInt(b.getText())) {
                    if (Integer.parseInt(b.getText()) >= 0 && Integer.parseInt(b.getText()) < 256) {
                        B = Integer.parseInt(b.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (tryParseInt(b.getText())) {
                    if (Integer.parseInt(b.getText()) >= 0 && Integer.parseInt(b.getText()) < 256) {
                        B = Integer.parseInt(b.getText());
                        toCMYK();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        c.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = (c.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        C = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String value = (c.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        C = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        m.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = (m.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        M = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String value = (m.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        M = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        y.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = (y.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        Y = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String value = (y.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        Y = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        k.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = (k.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        K = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String value = (k.getText()).replace(',', '.');
                if (tryParseDouble(value)) {
                    if (Double.parseDouble(value) >= 0 && Double.parseDouble(value) <= 1) {
                        K = Double.parseDouble(value);
                        toRGB();
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });


        main.add(this);
        main.add(convertRGB);
        main.add(convertCMYK);
        window.add(main);
        window.setPreferredSize(new Dimension(400, 300));
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();


    }
    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0,0,100,100);
    }

    private void toCMYK(){
        if (!CMYK) {
            RGB = true;
            color = new Color((int) R, (int) G, (int) B);
            K =1 - Math.max(R/255, Math.max(G/255, B/255));
            if (K != 1) {
                C = (1.0 - (R / 255) - K) / (1 - K);
                M = (1.0 - (G / 255) - K) / (1 - K);
                Y = (1.0 - (B / 255) - K) / (1 - K);
            } else {
                C = 0;
                M = 0;
                Y = 0;
            }
            c.setText((double) Math.round(C * 1000d) / 1000d + "");
            m.setText((double) Math.round(M * 1000d) / 1000d + "");
            y.setText((double) Math.round(Y * 1000d) / 1000d + "");
            k.setText((double) Math.round(K * 1000d) / 1000d + "");
            RGB = false;
            repaint();
        }
    }
    private void toRGB(){
        if (!RGB) {
            CMYK = true;
            R = 255.0 * (1 - C) * (1 - K);
            G = 255.0 * (1 - M) * (1 - K);
            B = 255.0 * (1 - Y) * (1 - K);
            color = new Color((int) R, (int) G, (int) B);
            r.setText((double) Math.round(R) + "");
            g.setText((double) Math.round(G) + "");
            b.setText((double) Math.round(B) + "");
            CMYK = false;
            repaint();
        }
    }
}
