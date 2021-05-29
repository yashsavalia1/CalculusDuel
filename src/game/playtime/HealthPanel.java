package game.playtime;

import game.Utility;

import javax.swing.JPanel;
import java.awt.*;

public class HealthPanel extends JPanel {

    private int health;
    private int owner;

    public HealthPanel(int hp, int owner) {
        health = hp;
        this.owner = owner;
        setOpaque(false);
    }

    public void addHP(int hp) {

        health += hp;

        if (health > 100) {
            health = 100;
        }

        if (health < 0) {
            health = 0;
        }

        repaint();

        if (health <= 0) {
            ((GamePanel) this.getParent()).gameOver(owner);

        }
    }

    public int getHealth() {
        return health;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(1, 1, (int) (this.getWidth() * (health / 100.0)), this.getHeight() - 20);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth(), this.getHeight() - 20);

        g.setColor(Color.white);
        g.setFont(Utility.font.deriveFont(18f));
        g.drawString("HP: " + health + " / 100", 0, 35);
    }

}
