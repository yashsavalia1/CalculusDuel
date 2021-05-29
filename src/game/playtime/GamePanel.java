package game.playtime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.Utility;

import static game.Game.Character;
import static game.Game.getEnemy;

import game.bullets.BulletPanel;

import java.awt.*;
import java.awt.image.*;

public class GamePanel extends JPanel {

    private BufferedImage player;
    private BufferedImage enemy;
    private int level;
    private AttackQuestionPanel attackPanel;
    private HealthPanel playerHealthPanel;
    private HealthPanel enemyHealthPanel;
    private HealQuestionPanel healPanel;
    private BulletPanel bulletPanel;
    private GameEndPanel gameOverPanel;
    public ComboPanel comboPanel;
    public SpeakingPanel playerSpeakingPanel;
    public SpeakingPanel enemySpeakingPanel;


    public GamePanel(Character charac, int level) {

        this.level = level;
        if (charac == Character.NEWTON) {
            player = Utility.newton;
            enemy = Utility.getImage(Game.getEnemy(level).toString().toLowerCase() + ".png");
        } else if (charac == Character.LEIBNIZ) {
            player = Utility.leibniz;
            enemy = Utility.getImage(Game.getEnemy(level).toString().toLowerCase() + ".png");
        } else
            System.out.println("Character Error");

        setLayout(null);

        gameOverPanel = new GameEndPanel(level);
        gameOverPanel.setBounds(0, 0, 900, 600);
        this.add(gameOverPanel);
        gameOverPanel.setVisible(false);

        playerSpeakingPanel = new SpeakingPanel(charac, false);
        playerSpeakingPanel.setBounds(460, 260, 300, 300);
        this.add(playerSpeakingPanel);

        enemySpeakingPanel = new SpeakingPanel(Game.getEnemy(level), true);
        enemySpeakingPanel.setBounds(290, 95, 300, 300);
        this.add(enemySpeakingPanel);

        comboPanel = new ComboPanel(charac == Character.NEWTON);
        comboPanel.setBounds(30, 125, 500, 70);
        this.add(comboPanel);

        playerHealthPanel = new HealthPanel(100, Game.PLAYER);
        playerHealthPanel.setBounds(Game.width / 2 - 85, 510, 150, 40);
        this.add(playerHealthPanel);

        enemyHealthPanel = new HealthPanel(100, Game.ENEMY);
        enemyHealthPanel.setBounds(Game.width / 2 - 85, 10, 150, 40);
        this.add(enemyHealthPanel);

        attackPanel = new AttackQuestionPanel(Game.getEnemy(level));
        attackPanel.setBounds(25, 200, 300, 350);
        this.add(attackPanel);

        healPanel = new HealQuestionPanel(getEnemy(level), playerHealthPanel);
        healPanel.setBounds(560, 200, 300, 350);
        this.add(healPanel);

        JLabel playerLabel = new JLabel(Utility.resizeIcon(new ImageIcon(player), 125, 125));
        JLabel enemyLanel = new JLabel(Utility.resizeIcon(new ImageIcon(enemy), 125, 125));

        playerLabel.setBounds(Game.width / 2 - 75, 370, 125, 125);
        this.add(playerLabel);

        enemyLanel.setBounds(Game.width / 2 - 75, 70, 125, 125);
        this.add(enemyLanel);

        bulletPanel = new BulletPanel(charac, Game.getEnemy(level));
        bulletPanel.setBounds(Game.width / 2 - 85, 50, 150, 450);
        bulletPanel.setOpaque(false);
        this.add(bulletPanel);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Character enem = Game.getEnemy(level);
        if (enem == Character.EULER)
            g.drawImage(Utility.getImage("background.png"), 0, 0, null);
        else if (enem == Character.RIEMANN)
            g.drawImage(Utility.getImage("night-castle.png"), -175, 0, this);
        else if (enem == Character.GAUSS)
            g.drawImage(Utility.getImage("trees.png").getScaledInstance(900,600, Image.SCALE_SMOOTH), 0, 0, null);
        else if (enem == Character.TAYLOR)
            g.drawImage(Utility.getImage("landscape.png").getScaledInstance(900,600,Image.SCALE_SMOOTH), 0, 0, null);
        else if (enem == Character.LEIBNIZ || enem == Character.NEWTON)
            g.drawImage(Utility.getImage("castle.png").getScaledInstance(900,600, Image.SCALE_SMOOTH), 0, 0, null);

        g.setColor( Color.getHSBColor(0, 0, (float) 0.8));
        g.fillRect(25, 140, 132, 50);
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        g.drawRect(25, 140, 132, 50);
        g2d.setStroke(new BasicStroke(1));
    }

    public void gameOver(int loser) {
        comboPanel.setEnabled(false);
        comboPanel.close();
        bulletPanel.setVisible(false);
        bulletPanel.validate();
        bulletPanel.killThread();
        attackPanel.disablePanel();
        healPanel.disablePanel();
        attackPanel.setEnabled(false);
        healPanel.setEnabled(false);

        if (loser == Game.PLAYER) {
            Game.mainClipThread.changeClip("over.wav");

            gameOverPanel.initiateOver(false);
        }

        if (loser == Game.ENEMY) {
            Game.mainClipThread.changeClip("win.wav");
            gameOverPanel.initiateOver(true);
        }

    }

    public void shootBullet(int playerOrEnemy) {
        bulletPanel.addBullet(playerOrEnemy);
    }

    public void shootUltimate(int playerOrEnemy) {
        if (playerOrEnemy == Game.PLAYER) {
            if (playerSpeakingPanel.isVisible())
                playerSpeakingPanel.setVisible(false);

            playerSpeakingPanel.showPanel();
        } else if (playerOrEnemy == Game.ENEMY) {
            if (enemySpeakingPanel.isVisible())
                enemySpeakingPanel.setVisible(false);

            enemySpeakingPanel.showPanel();
        }
        bulletPanel.addUltimate(playerOrEnemy);
    }

    public void decreaseEnemyHealth(int hp) {
        enemyHealthPanel.addHP(hp);

    }

    public void decreasePlayerHealth(int hp) {
        playerHealthPanel.addHP(hp);
    }

}
