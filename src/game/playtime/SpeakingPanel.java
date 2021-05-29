package game.playtime;

import game.Utility;
import game.Game.Character;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeakingPanel extends JPanel {

    private Character charac;
    private int saying;
    private boolean isEnemy;
    private Timer speakingTime;

    public SpeakingPanel(Character charac, boolean isEnemy) {
        setLayout(null);
        this.charac = charac;
        this.isEnemy = isEnemy;
        saying = 0;
        this.setVisible(false);
        repaint();
    }

    public void showPanel() {
        if (speakingTime != null && speakingTime.isRunning()) {
            speakingTime.stop();
            hidePanel();
        }
        saying = (int) (Math.random() * 3);
        this.setVisible(true);
        repaint();
    }

    public void closePanel() {
        speakingTime = new Timer(1500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speakingTime.stop();
                hidePanel();
            }

        });

        speakingTime.start();
    }

    public void hidePanel() {
        this.setVisible(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        if (!isEnemy) {
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[] { 5, 10, 30 }, new int[] { 106, 80, 100 }, 3);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[] { 90, 100, 90 }, new int[] { 10, 20, 30 }, 3);
        }

        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(10, 0, 80, 100, 10, 10);

        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(10, 0, 80, 100, 16, 16);

        if (!isEnemy) {
            g2d.setColor(Color.WHITE);
            g2d.fillPolygon(new int[] { 7, 12, 28 }, new int[] { 104, 78, 98 }, 3);
        } else {
            g2d.setColor(Color.WHITE);
            g2d.fillPolygon(new int[] { 88, 98, 88 }, new int[] { 10, 20, 30 }, 3);
        }

        g2d.setColor(Color.BLACK);
        g2d.setFont(Utility.font.deriveFont(14f));
        g2d.setStroke(new BasicStroke(1));

        if (charac == Character.NEWTON) {

            switch (saying) {
                case 0:
                    g.drawString("I'll show you", 15, 30);
                    g.drawString("my mass", 25, 45);
                    g.drawString("times", 35, 60);
                    g.drawString("acceleration!", 15, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("Every action", 16, 30);
                    g.drawString("has an equal", 15, 45);
                    g.drawString("and opposite", 15, 60);
                    g.drawString("reaction!", 25, 75);
                    break;
                default:
                    break;
            }

        } else if (charac == Character.LEIBNIZ) {

            switch (saying) {
                case 0:
                    g.drawString("I'll show you", 15, 30);
                    g.drawString("my binary", 20, 45);
                    g.drawString("number", 30, 60);
                    g.drawString("system!", 30, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("Logic", 35, 30);
                    g.drawString("shows that", 20, 45);
                    g.drawString("I will", 37, 60);
                    g.drawString("defeat you!", 20, 75);
                    break;
                default:
                    break;
            }
            //TODO add different character sayings

        }else if (charac == Character.TAYLOR) {

            switch (saying) {
                case 0:
                    g.drawString("I recommend", 15, 30);
                    g.drawString("you to be", 23, 45);
                    g.drawString("schooled by", 17, 60);
                    g.drawString("the masters!", 15, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("It's choice, not", 13, 30);
                    g.drawString(" chance, that", 14, 45);
                    g.drawString(" determines", 17, 60);
                    g.drawString("our destiny!", 18, 75);
                    break;
                default:
                    break;
            }

        }

        else if (charac == Character.EULER) {

            switch (saying) {
                case 0:
                    g.drawString("You're no", 25, 30);
                    g.drawString("match for my", 15, 45);
                    g.drawString("exponential", 20, 60);
                    g.drawString("growth!", 29, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("With my", 28, 30);
                    g.drawString("function ", 27, 45);
                    g.drawString("notation I will", 13, 60);
                    g.drawString("defeat you!", 18, 75);
                    break;
                default:
                    break;
            }

        }else if (charac == Character.GAUSS) {

            switch (saying) {
                case 0:
                    g.drawString("Stand aside,", 15, 30);
                    g.drawString("this field", 21, 45);
                    g.drawString("is only for the", 12, 60);
                    g.drawString("bright-minded!", 12, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("This is the", 20, 30);
                    g.drawString("power of my", 17, 45);
                    g.drawString("gaussian", 25, 60);
                    g.drawString("curvature!", 21, 75);
                    break;
                default:
                    break;
            }

        }else if (charac == Character.RIEMANN) {

            switch (saying) {
                case 0:
                    g.drawString("Your strategy", 12, 30);
                    g.drawString("to defeat", 24, 45);
                    g.drawString("me is doomed", 15, 60);
                    g.drawString("to fail!", 30, 75);
                    break;
                case 1:
                    g.drawString("Take that", 22, 45);
                    g.drawString("scoundrel!", 22, 60);
                    break;
                case 2:
                    g.drawString("With my", 30, 30);
                    g.drawString("arsenal of", 23, 45);
                    g.drawString("proofs I will", 17, 60);
                    g.drawString("be victorious!", 15, 75);
                    break;
                default:
                    break;
            }

        }
    }

}
