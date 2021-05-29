package game.bullets;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.*;
import game.Game.Character;
import game.playtime.GamePanel;

public class BulletPanel extends JPanel {

    private List<Bullet> playerBullets;
    private List<Bullet> enemyBullets;
    private Thread bulletThread;
    private boolean active;
    private Character charac;
    private Character enemy;
    private int fired;
    private boolean paintInProgress;

    public BulletPanel(Character charac, Character enemy) {

        paintInProgress = false;
        playerBullets = new ArrayList<Bullet>();
        enemyBullets = new ArrayList<Bullet>();

        active = true;
        this.charac = charac;
        this.enemy = enemy;


        bulletThread = createShootingThread();
        bulletThread.start();
    }

    public void addBullet(int playerOrEnemy) {
        Clip clip = null;
        try {
            clip = Utility.addVolume(Utility.makeClip("shoot.wav"), -5);
            clip.loop(0);
            clip.start();
        } catch (Exception e) {
            System.out.println("Shoot sfx error");
        }

        if (playerOrEnemy == 0) {
            playerBullets.add(new Bullet(350));
        }

        if (playerOrEnemy == 1) {
            enemyBullets.add(new Bullet(100));
        }
    }

    public void addUltimate(int playerOrEnemy) {
        Clip clip;
        try {
            clip = Utility.addVolume(Utility.makeClip("shoot.wav"), -5);
            clip.loop(0);
            clip.start();

        } catch (Exception e) {
            System.out.println("Shoot sfx error");
        }

        if (playerOrEnemy == 0) {

            Bullet b = new Bullet(350);
            b.setUltimate();
            playerBullets.add(b);
        }

        if (playerOrEnemy == 1) {
            Bullet b = new Bullet(100);
            b.setUltimate();
            enemyBullets.add(b);
        }
    }

    public void removeBullet(Bullet b, int playerOrEnemy) {

        if (!active)
            return;

        Clip clip = null;

        String clipName = "";

        if (playerOrEnemy == Game.PLAYER) {
            playerBullets.remove(b);
            if (this.getParent() != null) {
                if (b.ultimate) {
                    clipName = "hurt2.wav";
                    ((GamePanel) this.getParent()).playerSpeakingPanel.closePanel();
                    ((GamePanel) this.getParent()).decreaseEnemyHealth(-30);
                } else {
                    clipName = "hurt.wav";
                    ((GamePanel) this.getParent()).decreaseEnemyHealth(-10);
                }
            }
        }

        if (playerOrEnemy == Game.ENEMY) {
            enemyBullets.remove(b);
            if (this.getParent() != null) {
                if (b.ultimate) {
                    clipName = "hurt2.wav";
                    ((GamePanel) this.getParent()).enemySpeakingPanel.closePanel();
                    ((GamePanel) this.getParent()).decreasePlayerHealth(-30);
                } else {
                    clipName = "hurt.wav";
                    ((GamePanel) this.getParent()).decreasePlayerHealth(-10);
                }
            }
        }

        try {
            clip = Utility.addVolume(Utility.makeClip(clipName), -5);
            clip.loop(0);
            clip.start();
        } catch (Exception e) {
            System.out.println("Shoot sfx error");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintInProgress = true;
        try {

            if (playerBullets != null) {
                g.setColor(Color.red);
                for (int i = 0; i < playerBullets.size(); i++) {

                    Bullet bullet = playerBullets.get(i);

                    if (bullet.ultimate) {
                        if (charac == Character.NEWTON)
                            g.drawImage(Utility.getImage("force.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (charac == Character.LEIBNIZ)
                            g.drawImage(Utility.getImage("bin.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);

                        continue;
                    }
                    g.fillRoundRect(this.getWidth() / 2 + 10, (int) bullet.y, 5, 20, 5, 5);
                }
            }

            if (enemyBullets != null) {
                g.setColor(Color.BLUE);
                for (int i = 0; i < enemyBullets.size(); i++) {
                    Bullet bullet = enemyBullets.get(i);
                    if (bullet.ultimate) {
                        if (enemy == Character.LEIBNIZ)
                            g.drawImage(Utility.getImage("bin.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (enemy == Character.NEWTON)
                            g.drawImage(Utility.getImage("force.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (enemy == Character.EULER)
                            g.drawImage(Utility.getImage("e.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (enemy == Character.GAUSS)
                            g.drawImage(Utility.getImage("geom.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (enemy == Character.RIEMANN)
                            g.drawImage(Utility.getImage("sum.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        else if (enemy == Character.TAYLOR) {
                            g.drawImage(Utility.getImage("sigma.png"), this.getWidth() / 2 - 25, (int) bullet.y, 50, 50,
                                    null);
                        }

                        continue;
                    }
                    g.fillRoundRect(this.getWidth() / 2 - 10, (int) bullet.y, 5, 20, 5, 5);
                }
            }
        } catch (Exception e) {
            System.out.println("Bullet Exception");
            e.printStackTrace();
        }
        paintInProgress = false;

    }

    private GamePanel getGamePanel() {
        return (GamePanel) this.getParent();
    }

    private Thread createShootingThread() {
        return new Thread(new Runnable() {


            private Timer bulletThreadTimer = new Timer(5, new ActionListener() {

                private Timer enemyShootTimer = new Timer(20000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enemyShootTimer.stop();
                    }

                });
                private boolean toStartTimer = true;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!paintInProgress) {

                        if (toStartTimer) {
                            toStartTimer = false;
                            enemyShootTimer.start();
                        }

                        //Adds enemy bullets
                        if (!enemyShootTimer.isRunning() && active) {
                            if (enemyBullets.size() == 0 && (Math.random() * 500) < 1) {
                                if (fired >= 3 && Math.random() <= 0.75) {
                                    fired = 0;
                                    getGamePanel().shootUltimate(Game.ENEMY);
                                } else {
                                    fired++;
                                    getGamePanel().shootBullet(Game.ENEMY);
                                }
                                enemyShootTimer.start();
                            }
                        }

                        //Removes player and enemy bullets
                        for (int i = playerBullets.size() - 1; i >= 0; i--) {
                            if (playerBullets.get(i).dead) {
                                removeBullet(playerBullets.get(i), Game.PLAYER);
                            }
                        }

                        for (int i = enemyBullets.size() - 1; i >= 0; i--) {
                            if (enemyBullets.get(i).dead) {
                                removeBullet(enemyBullets.get(i), Game.ENEMY);
                            }
                        }


                        //marks bullets as dead and increment y
                        for (Bullet playerBullet : playerBullets) {
                            if (playerBullet.y <= 70) {
                                playerBullet.dead = true;
                            } else {
                                if (playerBullet.ultimate)
                                    playerBullet.y -= 2;
                                else
                                    playerBullet.y -= 4;
                            }
                        }

                        for (Bullet bullet : enemyBullets) {
                            if (bullet.y >= 350) {
                                bullet.dead = true;
                            } else {
                                if (bullet.ultimate)
                                    bullet.y += 2;
                                else
                                    bullet.y += 4;
                            }
                        }
                    }

                    repaint();
                }
            });

            @Override
            public void run() {
                bulletThreadTimer.start();
            }

        });

    }

    public void killThread() {
        active = false;
        bulletThread.interrupt();
    }
}
