package game.playtime;

import game.Game;
import game.Utility;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ComboPanel extends JPanel {

    private int filled;
    private boolean charged;
    private JLabel ultimate;
    private MouseInputListener listener;

    public ComboPanel(boolean charac) {
        this.setOpaque(false);
        this.setLayout(null);
        filled = 0;
        if (charac)
            ultimate = new JLabel(Utility.resizeIcon(new ImageIcon(Utility.getImage("force.png")), 60, 60));
        else {
            ultimate = new JLabel(Utility.resizeIcon(new ImageIcon(Utility.getImage("bin.png")), 60, 60));
        }
        ultimate.setBounds(130, 7, 60, 60);
        ultimate.setVisible(false);
        this.add(ultimate);
        
        listener = new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                shootUltimate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        };

        ultimate.addMouseListener(listener);
    }

    public void shootUltimate() {
        fire();
        ((GamePanel) this.getParent()).shootUltimate(Game.PLAYER);
    }

    public void addFill() {
        if (filled < 3) {
            filled++;
            if (filled >= 3) {
                charged = true;
                ultimate.setVisible(true);
            }
            repaint();
        }
    }

    public void breakStreak() {
        if (!charged) {
            filled = 0;
            repaint();
        }
    }

    public void fire() {
        ultimate.setVisible(false);
        charged = false;
        filled = 0;
        repaint();
    }

    public void close() {
        ultimate.removeMouseListener(listener);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 40, (int) (120 * (filled / 3.0)), 20);
        g.setColor(Color.BLACK);
        g.drawRect(0, 40, 120, 20);
        g.drawLine(40, 40, 40, 60);
        g.drawLine(80, 40, 80, 60);

        g.setColor(Color.BLACK);
        g.setFont(Utility.font.deriveFont(18f));
        g.drawString("Charge: " + filled + " / 3", 1, 30);
    }

}
