package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import game.Game.Character;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LevelPanel extends JPanel {

    private JButton backButton;
    private static int x = 80;
    private static int y = 50;
    private static Polygon level1 = new Polygon(new int[] { 100 - x, 160 - x, 300 - x, 240 - x },
            new int[] { 550 - y, 150 - y, 150 - y, 550 - y }, 4);
    private static Polygon level2 = new Polygon(new int[] { 260 - x, 320 - x, 460 - x, 400 - x },
            new int[] { 550 - y, 150 - y, 150 - y, 550 - y }, 4);
    private static Polygon level3 = new Polygon(new int[] { 420 - x, 480 - x, 620 - x, 560 - x },
            new int[] { 550 - y, 150 - y, 150 - y, 550 - y }, 4);
    private static Polygon level4 = new Polygon(new int[] { 580 - x, 640 - x, 780 - x, 720 - x },
            new int[] { 550 - y, 150 - y, 150 - y, 550 - y }, 4);
    private static Polygon level5 = new Polygon(new int[] { 740 - x, 800 - x, 940 - x, 880 - x },
            new int[] { 550 - y, 150 - y, 150 - y, 550 - y }, 4);

    private static Color normal = Color.getHSBColor(0, 0, (float) 0.7);
    private static Color highlight = Color.getHSBColor(0, 0, (float) 0.9);
    private static Color dark = Color.getHSBColor(0, 0, (float) 0.4);
    private static int isHighlighted = -1;
    private Character charac;

    public LevelPanel() {


        setLayout(null);

        backButton = new JButton();
        backButton.setBounds(20, 20, 60, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setIcon(Utility.resizeIcon(new ImageIcon(Utility.getImage("arrow.png")), 50, 30));

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game.showMainMenu();
            }

        });

        this.add(backButton);

        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (level1.contains(e.getX(), e.getY())) {

                    if (isHighlighted != 1) {
                        changeCursor(Cursor.HAND_CURSOR);
                        isHighlighted = 1;
                        repaint();
                    }
                } else if (level2.contains(e.getX(), e.getY())) {

                    if (isHighlighted != 2) {
                        if (Game.level >= 2)
                            changeCursor(Cursor.HAND_CURSOR);

                        isHighlighted = 2;
                        repaint();
                    }
                } else if (level3.contains(e.getX(), e.getY())) {

                    if (isHighlighted != 3) {
                        if (Game.level >= 3)
                            changeCursor(Cursor.HAND_CURSOR);

                        isHighlighted = 3;
                        repaint();
                    }
                } else if (level4.contains(e.getX(), e.getY())) {
                    if (isHighlighted != 4) {
                        if (Game.level >= 4)
                            changeCursor(Cursor.HAND_CURSOR);

                        isHighlighted = 4;
                        repaint();
                    }
                } else if (level5.contains(e.getX(), e.getY())) {
                    if (isHighlighted != 5) {
                        if (Game.level >= 5)
                            changeCursor(Cursor.HAND_CURSOR);

                        isHighlighted = 5;
                        repaint();
                    }
                } else {
                    if (isHighlighted != -1) {
                        changeCursor(Cursor.DEFAULT_CURSOR);
                        isHighlighted = -1;
                        repaint();
                    }
                }
            }
        });

        this.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (level1.contains(e.getX(), e.getY())) {
                    Game.showGamePanel(1);
                } else if (level2.contains(e.getX(), e.getY())) {
                    if (Game.level >= 2)
                        Game.showGamePanel(2);
                } else if (level3.contains(e.getX(), e.getY())) {
                    if (Game.level >= 3)
                        Game.showGamePanel(3);
                } else if (level4.contains(e.getX(), e.getY())) {
                    if (Game.level >= 4)
                        Game.showGamePanel(4);
                } else if (level5.contains(e.getX(), e.getY())) {
                    if (Game.level >= 5)
                        Game.showGamePanel(5);
                }

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

        });

        setVisible(true);

    }

    private void changeCursor(int cursor) {
        if (this.getCursor().getType() != cursor)
            this.setCursor(Cursor.getPredefinedCursor(cursor));
    }

    public void setCharacter(Character charac) {
        this.charac = charac;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Utility.startingBackgroundImage, 0, 0, null);
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        g2d.drawPolygon(level1);
        g2d.drawPolygon(level2);
        g2d.drawPolygon(level3);
        g2d.drawPolygon(level4);
        g2d.drawPolygon(level5);
        g2d.setStroke(new BasicStroke(1));

        if (isHighlighted == 1) {
            g.setColor(highlight);
        } else {
            g.setColor(normal);
        }
        g.fillPolygon(level1);

        if (isHighlighted == 2) {
            if (Game.level >= 2)
                g.setColor(highlight);
            else
                g.setColor(dark);
        } else {
            g.setColor(normal);
        }
        g.fillPolygon(level2);

        if (isHighlighted == 3) {
            if (Game.level >= 3)
                g.setColor(highlight);
            else
                g.setColor(dark);
        } else {
            g.setColor(normal);
        }
        g.fillPolygon(level3);

        if (isHighlighted == 4) {
            if (Game.level >= 4)
                g.setColor(highlight);
            else
                g.setColor(dark);
        } else {
            g.setColor(normal);
        }
        g.fillPolygon(level4);

        if (isHighlighted == 5) {
            if (Game.level >= 5)
                g.setColor(highlight);
            else
                g.setColor(dark);
        } else {
            g.setColor(normal);
        }
        g.fillPolygon(level5);

        g.drawImage(Utility.getImage("euler.png"), 80, 160, 100, 100, null);
        g.drawImage(Utility.getImage("riemann.png"), 240, 160, 100, 100, null);
        g.drawImage(Utility.getImage("gauss.png"), 400, 160, 100, 100, null);
        g.drawImage(Utility.getImage("taylor.png"), 560, 160, 100, 100, null);

        if (charac != null) {
            if (charac == Character.NEWTON) {
                g.drawImage(Utility.getImage("leibniz.png"), 720, 160, 100, 100, null);
            } else if (charac == Character.LEIBNIZ) {
                g.drawImage(Utility.getImage("newton.png"), 720, 160, 110, 110, null);
            }
        }

        g.setColor(Color.BLACK);
        g.setFont(Utility.font.deriveFont(32f));

        g.drawString("Level 1", 105, 135);
        g.drawString("Level 2", 265, 135);
        g.drawString("Level 3", 425, 135);
        g.drawString("Level 4", 585, 135);
        g.drawString("Level 5", 745, 135);

        g.drawString("Euler", 75, 420);
        g.drawString("Riemann", 215, 420);
        g.drawString("Gauss", 388, 420);
        g.drawString("Taylor", 543, 420);

        if (charac != null) {
            if (charac == Character.NEWTON) {
                g.drawString("Leibniz", 700, 420);
            } else if (charac == Character.LEIBNIZ) {
                g.drawString("Newton", 700, 420);
            }
        }

        for (int i = Game.level + 1; i <= 5; i++) {
            g.drawImage(Utility.getImage("lock.png"), i * 160 - 100, 430, 70, 70, null);
        }

    }

}
