package game;

import javax.swing.*;

import game.Game.Character;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinPanel extends JPanel {

    private Timer initialTimer;
    private Timer creditTimer;
    private Timer buttonTimer;
    private int offset = 0;
    private double opacity = -0.5;
    private JButton exit;
    private JButton playAgain;


    public WinPanel() {
        this.setLayout(null);
        setBackground(Color.BLACK);
        setBounds(0, 0, 900, 600);

        exit = new JButton("Main Menu");
        exit.setBounds(490, 500, 130, 30);
        exit.setFont(Utility.font.deriveFont(18f));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.showMainMenu();
            }
        });
        exit.setVisible(false);

        playAgain = new JButton("Restart");
        playAgain.setBounds(640, 500, 130, 30);
        playAgain.setFont(Utility.font.deriveFont(18f));
        playAgain.setBackground(Color.BLACK);
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.level = 1;
                Game.toSetCharac = true;
                Game.showMainMenu();
            }
        });
        playAgain.setVisible(false);

        this.add(playAgain);
        this.add(exit);

        initialTimer = new Timer(150, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                offset-=3;
                repaint();
                if (offset < -70) {
                    initialTimer.stop();
                    creditTimer.start();
                }
            }

        });

        creditTimer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.05;
                repaint();

                if (opacity >= 0.96) {
                    creditTimer.stop();
                    buttonTimer.start();
                }
            }
        });

        buttonTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonTimer.stop();
                playAgain.setVisible(true);
                exit.setVisible(true);
            }
        });

        initialTimer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(Utility.getImage("town.png"), 0, offset, null);

        if (Game.charac == Character.NEWTON)
            g2d.drawImage(Utility.newton.getScaledInstance(200, 200, Image.SCALE_DEFAULT), 20, 300 - offset, null);
        if (Game.charac == Character.LEIBNIZ)
            g2d.drawImage(Utility.leibniz.getScaledInstance(200, 200, Image.SCALE_DEFAULT), 20, 300 - offset, null);

        if (opacity >= 0) {
            g2d.setColor(Color.WHITE);
            g2d.setComposite(AlphaComposite.SrcOver.derive((float) opacity));
            g2d.setFont(Utility.font);
            g2d.drawString("By Yash Savalia", 420, 390);
            g2d.drawString("and Jason Nguyen", 420, 450);



        }

        g2d.setColor(Color.BLACK);

        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));

        g2d.setStroke(new BasicStroke(20));
        g2d.drawRect(10, 10, 870, 545);
        g2d.setStroke(new BasicStroke(1));

    }
}
