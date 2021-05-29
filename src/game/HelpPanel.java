package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPanel extends JPanel {

    public HelpPanel() {
        this.setLayout(null);

        JButton backButton = new JButton();
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

        JButton openButton = new JButton("Open Help Page");
        openButton.setBounds(450-100, 300-40, 160, 40);
        openButton.setBackground(Color.BLACK);
        openButton.setForeground(Color.white);
        openButton.setFont(Utility.font.deriveFont(20f));
        openButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://yashsavalia1.github.io/Website/other-projects/calculus-duel/help");
            }

        });

        this.add(openButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Utility.startingBackgroundImage, 0, 0, null);

    }

    public void openWebPage(String url){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
