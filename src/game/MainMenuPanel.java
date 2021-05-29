package game;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    private JLabel title;
    public JButton muteButton;
    public JButton playButton;
    public JButton helpButton;

    public MainMenuPanel() {
        this.setLayout(null);

        title = new JLabel(
                "<html><font color='#000050'>&#160;&#160;WELCOME TO <br><font color='red'>CALCULUS <font color='#0a50ff'> DUEL!</html>",
                JLabel.CENTER);
        title.setFont(Utility.font.deriveFont(100f));
        title.setBounds(75, 40, 700, 450);
        this.add(title);

        playButton = new JButton("Play");
        playButton.setFont(Utility.font.deriveFont(18f));
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setBounds(450 + 10, 400, 130, 30);
        this.add(playButton);

        muteButton = new JButton("Mute");
        if (Game.muted) {
            muteButton.setText("Unmute");
        }
        muteButton.setFont(Utility.font.deriveFont(18f));
        muteButton.setBackground(Color.BLACK);
        muteButton.setForeground(Color.WHITE);
        muteButton.setBounds(450 - 160, 400, 130, 30);
        this.add(muteButton);

        helpButton = new JButton("Help");
        helpButton.setFont(Utility.font.deriveFont(18f));
        helpButton.setBackground(Color.BLACK);
        helpButton.setForeground(Color.WHITE);
        helpButton.setBounds(450 - 75, 500, 130, 30);
        this.add(helpButton);

        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game.play();
            }

        });

        muteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game.muted = !Game.muted;

                if (muteButton.getText().equals("Mute")) {
                    Utility.setVolume(Game.mainClipThread.currentClip, -80);
                    muteButton.setText("Unmute");
                } else if (muteButton.getText().equals("Unmute")) {
                    Utility.setVolume(Game.mainClipThread.currentClip, -21);
                    muteButton.setText("Mute");
                }
            }

        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.showHelpMenu();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(Utility.startingBackgroundImage, 0, 0, null);

    }

}
