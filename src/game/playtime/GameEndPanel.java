package game.playtime;

import game.Game;
import game.Utility;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameEndPanel extends JPanel implements ActionListener {

    private float alpha;
    private Timer timer;
    private Timer timer2;
    private JButton nextLevel;
    private JButton quit;
    private boolean win;
    private int level;

    public GameEndPanel(int level) {
        this.level = level;
        win = false;
        alpha = 0f;
        timer = new Timer(40, this);
        timer2 = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showButtons();
                timer2.stop();
            }

        });

        nextLevel = new JButton("Next Level");
        nextLevel.setFont(Utility.font.deriveFont(18f));
        nextLevel.setBackground(Color.BLACK);
        nextLevel.setForeground(Color.WHITE);
        nextLevel.setBounds(450 + 10, 350, 130, 30);

        quit = new JButton("Quit");
        quit.setFont(Utility.font.deriveFont(18f));
        quit.setBackground(Color.BLACK);
        quit.setForeground(Color.WHITE);
        quit.setBounds(450 - 160, 350, 130, 30);

        addButtonListeners();

        setLayout(null);

        setOpaque(false);
    }

    public void initiateOver(boolean win) {
        this.win = win;
        if (win && level == Game.level) {
            Game.level++;
        }

        setVisible(true);
        timer.start();

    }

    public void showButtons() {
        this.add(nextLevel);
        this.add(quit);

        if (!win) {
            nextLevel.setText("Play Again");
            nextLevel.setVisible(true);
        } else if (level >= 5) {
            nextLevel.setVisible(false);
            quit.setBounds(450 - 70, 350, 130, 30);
            quit.setText("Continue");
        }
        quit.setVisible(true);
        repaint();
    }

    private void addButtonListeners() {
        nextLevel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (win)
                    Game.showGamePanel(level + 1);
                else
                    Game.showGamePanel(level);
            }

        });

        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (level >= 5) {
                    Game.showWinPanel();
                } else
                    Game.showLevelPanel();
            }

        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (alpha) * 0.85f));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (alpha) * 0.99f));
        g2d.setColor(Color.white);
        g2d.setFont(Utility.font.deriveFont(100f));
        if (win) {
            g2d.setColor(Color.CYAN);
            g2d.drawString("YOU WIN!", this.getWidth() / 2 - 185, this.getHeight() / 2);
        } else {
            g2d.drawString("GAME OVER", this.getWidth() / 2 - 250, this.getHeight() / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

        if (alpha >= 1f) {
            timer.stop();
            timer2.start();
        }
        if (alpha < 1f) {
            alpha += 0.05;
        }

    }
}
