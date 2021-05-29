package game;

import game.playtime.GamePanel;
import questions.QuestionBank;

public class Game {

    public enum Character {
        NEWTON, LEIBNIZ, EULER, RIEMANN, GAUSS, TAYLOR
    }

    public static final int width = 900;
    public static final int height = 600;
    public static final int PLAYER = 0;
    public static final int ENEMY = 1;

    public static MainMenuPanel mainMenuPanel;
    public static HelpPanel helpPanel;
    public static GamePanel gamePanel;
    public static LevelPanel levelPanel;
    public static WinPanel winPanel;
    public static MainFrame frame;
    public static MainClipThread mainClipThread;
    public static boolean muted;
    public static int level = 5;
    public static Character charac;
    public static boolean toSetCharac;

    public static void main(String[] args) {

        frame = new MainFrame(width, height);

        QuestionBank.setQuestions();

        toSetCharac = true;

        mainClipThread = new MainClipThread();

        init();
        showMainMenu();

        frame.setVisible(true);

    }

    public static void init() {
        mainMenuPanel = new MainMenuPanel();
        mainMenuPanel.setVisible(false);
        frame.add(mainMenuPanel);

        levelPanel = new LevelPanel();
        levelPanel.setVisible(false);
        frame.add(levelPanel);

        helpPanel = new HelpPanel();
        helpPanel.setVisible(false);
        frame.add(helpPanel);


    }

    public static void showMainMenu() {
        if (winPanel != null && winPanel.isVisible()) {
            winPanel.setVisible(false);
        }

        if (gamePanel != null && gamePanel.isVisible()) {
            gamePanel.setVisible(false);
        }

        if (levelPanel != null && levelPanel.isVisible()) {
            levelPanel.setVisible(false);

        } else if (helpPanel != null && helpPanel.isVisible()) {
            helpPanel.setVisible(false);

        } else {
            if (!mainMenuPanel.isVisible())
                mainClipThread.changeClip("menu.wav");
        }

        mainMenuPanel.setVisible(true);
        frame.validate();
    }

    public static void play() {
        if (toSetCharac) {
            charac = frame.showOptionPane();
            toSetCharac = false;
        }
        if (charac == null) {
            toSetCharac = true;
            showMainMenu();
            return;
        }

        showLevelPanel();
    }

    public static void showHelpMenu() {
        if (mainMenuPanel != null && mainMenuPanel.isVisible()) {
            mainMenuPanel.setVisible(false);
        }

        helpPanel.setVisible(true);
        frame.validate();

    }

    public static void showLevelPanel() {
        if (gamePanel != null && gamePanel.isVisible()) {
            gamePanel.setVisible(false);
            frame.remove(gamePanel);
            mainClipThread.changeClip("menu.wav");
        }

        if (mainMenuPanel != null && mainMenuPanel.isValid()) {
            mainMenuPanel.setVisible(false);
        }

        levelPanel.setCharacter(charac);
        levelPanel.setVisible(true);
        frame.validate();
    }

    public static void showGamePanel(int level) {
        if (gamePanel != null && gamePanel.isVisible()) {
            gamePanel.setVisible(false);
            frame.remove(gamePanel);
        }

        mainClipThread.changeClip("music.wav");

        levelPanel.setVisible(false);
        mainMenuPanel.setVisible(false);

        gamePanel = new GamePanel(charac, level);
        frame.add(gamePanel);
        gamePanel.setVisible(true);

    }

    public static void showWinPanel() {
        if (gamePanel != null && gamePanel.isVisible()) {
            gamePanel.setVisible(false);
            frame.remove(gamePanel);
        }

        mainClipThread.changeClip("end.wav");

        winPanel = new WinPanel();
        frame.add(winPanel);
        winPanel.setVisible(true);

    }

    public static Character getEnemy(int level) {
        {
            if (level == 1)
                return Character.EULER;
            else if (level == 2)
                return Character.RIEMANN;
            else if (level == 3)
                return Character.GAUSS;
            else if (level == 4)
                return Character.TAYLOR;
            else if (level == 5) {
                if (charac == Character.NEWTON)
                    return Character.LEIBNIZ;
                else if (charac == Character.LEIBNIZ)
                    return Character.NEWTON;
            }
        }
        return null;

    }

}