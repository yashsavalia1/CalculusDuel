package game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(int width, int height) {
        this.setTitle("Calculus Duel");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new CardLayout());
    }

    public Game.Character showOptionPane() {
        JLabel label = new JLabel("Would you like to play as Newton or Leibniz?");
        label.setFont(Utility.font.deriveFont(20f));

        int n = JOptionPane.showOptionDialog(this, label, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Newton", "Leibniz"}, "Newton");

        if (n == 0)
            return Game.Character.NEWTON;
        if (n == 1)
            return Game.Character.LEIBNIZ;

        return null;
    }

    public void setCursor(int cursorType) {
        this.setCursor(new Cursor(cursorType));
    }
}
