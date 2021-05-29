package game.playtime;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit;

import game.Game;
import game.Utility;
import game.Game.Character;
import questions.Question;
import questions.QuestionBank;

public class AttackQuestionPanel extends JPanel {

    private Question currentQuestion;
    private JLabel currentLabel;
    private JLabel wrongLabel;
    private JTextField field;
    private JButton submitButton;
    private Timer timer;
    private JLabel timerLabel;
    private int counter;
    private Character enemy;

    public AttackQuestionPanel(Character enemy) {
        this.enemy = enemy;

        LineBorder lineBorder = new LineBorder(Color.black, 2);
        TitledBorder b = new TitledBorder(lineBorder, "Attack:");
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

                if(field.getText().contains("inf")) {
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

    ;

    public void correctAnswer() {
        ((GamePanel) this.getParent()).comboPanel.addFill();

        field.setText("");
        changeQuestion();
        ((GamePanel) this.getParent()).shootBullet(Game.PLAYER);
        resetTimer();
        repaint();
    }

    public void breakStreak() {
        ((GamePanel) this.getParent()).comboPanel.breakStreak();
    }

    public void timeout() {
        field.setText("");
        breakStreak();
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
        timer.removeActionListener(timer.getActionListeners()[0]);
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
                    // COMBO ADD

                } else {
                    if (!wrongLabel.isVisible()) {
                        wrongLabel.setVisible(true);
                    }

                    // COMBO RESET
                    breakStreak();
                }

            }

        });
    }

    private void addKeyListener(JTextField field, JButton button) {
        field.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }
        });
    }
}
