package game.playtime;

import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit;

import game.Utility;
import game.Game.Character;
import questions.Question;
import questions.QuestionBank;

public class HealQuestionPanel extends JPanel {

    private Question currentQuestion;
    private JLabel currentLabel;
    private JLabel wrongLabel;
    private JTextField field;
    private HealthPanel playerHealthPanel;
    private JButton submitButton;
    private Timer timer;
    private JLabel timerLabel;
    private int counter;
    private Character enemy;

    public HealQuestionPanel(Character enemy, HealthPanel playerHealth) {

        playerHealthPanel = playerHealth;
        this.enemy = enemy;

        LineBorder lineBorder = new LineBorder(Color.black, 2);
        TitledBorder b = new TitledBorder(lineBorder, "Heal:");
        b.setTitleFont(Utility.font.deriveFont(20f));
        this.setBorder(b);
        setLayout(null);

        this.setBackground(Color.getHSBColor(0, 0, (float) 0.8));

        currentQuestion = QuestionBank.nextQuestion(enemy);

        currentLabel = new JLabel(
                Utility.resizeIcon(new ImageIcon(currentQuestion.question), 250,
                        (int) (currentQuestion.question.getHeight() * (250.0 / currentQuestion.question.getWidth()))));

        currentLabel.setBounds(20, 30, 270, 250);
        currentLabel.setVerticalAlignment(JLabel.TOP);
        currentLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(currentLabel);

        field = new JTextField();
        field.setFont(Utility.typeFont.deriveFont(20f));
        field.setBounds(10, 250, 250, 30);
        field.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {

            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub
                if (field.getText().contains("pi")) {
                    field.setText(field.getText().replaceAll("pi", "π"));
                }

                if (field.getText().contains("sqrt")) {
                    field.setText(field.getText().replaceAll("sqrt", "√"));
                }
                if (field.getText().contains("inf")) {
                    field.setText(field.getText().replaceAll("inf", "∞"));
                }

            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
        this.add(field);

        submitButton = new JButton("Submit");
        submitButton.setFont(Utility.font.deriveFont(24f));
        submitButton.setBackground(new Color(60, 213, 25));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(190, 300, 100, 40);
        this.add(submitButton);

        addKeyListener(field, submitButton);

        wrongLabel = new JLabel("Wrong Answer!");
        wrongLabel.setFont(Utility.font.deriveFont(30f));
        wrongLabel.setForeground(Color.RED);
        wrongLabel.setBounds(10, 290, 170, 50);
        wrongLabel.setVisible(false);
        this.add(wrongLabel);

        addActionListener(field, submitButton, wrongLabel);

        counter = 60;

        timerLabel = new JLabel("Time Left: " + counter);
        timerLabel.setFont(Utility.font.deriveFont(20f));
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setBounds(10, 210, 170, 50);
        this.add(timerLabel);

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;

                setTimer();

                if (counter <= 0) {
                    resetTimer();
                    timeout();
                }
            }

        });

        timer.start();

    }

    public void correctAnswer() {
        playerHealthPanel.addHP(10);
        try {
            Clip clip = Utility.addVolume(Utility.makeClip("heal.wav"), -14);
            clip.loop(0);
            clip.start();
        } catch (Exception e) {
            System.out.println("Heal sound error");
        }
        field.setText("");

        changeQuestion();
        resetTimer();
        repaint();
    }

    public void timeout() {
        field.setText("");
        changeQuestion();
        repaint();
    }

    public void changeQuestion() {
        currentQuestion = QuestionBank.nextQuestion(enemy);

        currentLabel.setIcon(
                Utility.resizeIcon(new ImageIcon(currentQuestion.question), 250,
                        (int) (currentQuestion.question.getHeight() * (250.0 / currentQuestion.question.getWidth()))));

    }

    public void setTimer() {
        timerLabel.setText("Time Left: " + counter);
        repaint();
    }

    public void resetTimer() {
        timer.restart();
        counter = 60;
        timerLabel.setText("Time Left: " + counter);
        repaint();
    }

    public void disablePanel() {
        field.setEnabled(false);
        field.setEditable(false);
        submitButton.setEnabled(false);
        timer.stop();
    }

    private void addActionListener(JTextField field, JButton button, JLabel wrongLabel) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = field.getText().toLowerCase().replaceAll(" ", "");
                answer = answer.replaceAll("y=", "");
                answer = answer.replaceAll("[()]", "");
                answer = answer.replaceAll("underestimate", "under");
                answer = answer.replaceAll("overestimate", "over");

                if (currentQuestion.answer.equals(answer)) {
                    wrongLabel.setVisible(false);
                    correctAnswer();

                } else {
                    wrongLabel.setVisible(true);
                }

            }

        });
    }

    private void addKeyListener(JTextField field, JButton button) {
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }
        });
    }
}
