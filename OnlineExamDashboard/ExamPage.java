package OnlineExamDashboard;

import javax.swing.*;
import java.awt.event.*;

public class ExamPage extends JFrame {
    private final JLabel questionLabel;
    private final JLabel timerLabel;
    private final JRadioButton[] options;
    private final ButtonGroup optionGroup;
    private final JButton nextButton;
    private javax.swing.Timer examTimer;
    private int timeRemaining = 60; // seconds

    private int currentQuestion = 0;

    private final String[] questions = {
            "Q1. Which is a valid keyword in java?",
            "Q2. Which one of the following will declare an array and initialize it with five numbers?",
            "Q3. Which is the valid declarations within an interface definition?",
            "Q4. Who developed Java?",
            "Q5. Which one is a valid declaration of a boolean?"
    };

    private final String[][] optionsList = {
            {"interface", "string", "Float", "unsigned"},
            {"Array a = new Array(5);", "int [] a = {23,22,21,20,19};", "int a [] = new int[5];", "int [5] array;"},
            {"public double methoda();", "public final double methoda();", "static void methoda(double d1);", "protected void methoda(double d1);"},
            {"James Gosling", "Dennis Richie", "Guido van Rossum", "Bjarne Stroustrup"},
            {"boolean b1 = 0;", "boolean b2 = 'false';", "boolean b3 = false;", "boolean b4 = Boolean.false();"}
    };

    private final String[] correctAnswers = {
            "interface", "int [] a = {23,22,21,20,19};", "public double methoda();", "James Gosling", "boolean b3 = false;"
    };

    private final String[] selectedAnswers = new String[questions.length];

    public ExamPage(User user) {
        setTitle("Online Examination - Welcome " + user.getFullName());
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 30, 500, 25);
        add(questionLabel);

        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        int y = 70;
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(50, y, 400, 25);
            optionGroup.add(options[i]);
            add(options[i]);
            y += 30;
        }

        nextButton = new JButton("Next");
        nextButton.setBounds(100, 250, 100, 30);
        add(nextButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 250, 100, 30);
        add(submitButton);

        timerLabel = new JLabel("Time left: 60 sec");
        timerLabel.setBounds(400, 10, 150, 30);
        add(timerLabel);

        // Next Question
        nextButton.addActionListener(e -> {
            saveSelectedAnswer();
            currentQuestion++;
            if (currentQuestion < questions.length) {
                displayQuestion(currentQuestion);
            } else {
                nextButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "This was the last question. Please submit.");
            }
        });

        // Submit button
        submitButton.addActionListener(e -> {
            if (examTimer != null) examTimer.stop();
            saveSelectedAnswer(); // Save the last answer
            showResult();
        });

        startTimer(); // Start the countdown
        displayQuestion(currentQuestion);
        setVisible(true);
    }

    private void displayQuestion(int index) {
        questionLabel.setText(questions[index]);
        optionGroup.clearSelection();
        for (int i = 0; i < 4; i++) {
            options[i].setText(optionsList[index][i]);
        }

        // Restore previously selected answer (if any)
        if (selectedAnswers[index] != null) {
            for (int i = 0; i < 4; i++) {
                if (options[i].getText().equals(selectedAnswers[index])) {
                    options[i].setSelected(true);
                    break;
                }
            }
        }
    }

    private void saveSelectedAnswer() {
        // ✅ FIX: Only save if currentQuestion is valid
        if (currentQuestion >= 0 && currentQuestion < selectedAnswers.length) {
            for (JRadioButton option : options) {
                if (option.isSelected()) {
                    selectedAnswers[currentQuestion] = option.getText();
                    break;
                }
            }
        }
    }

    private void startTimer() {
        timeRemaining = 60; // Reset time remaining for the new question
        timerLabel.setText("Time left: " + timeRemaining + " sec");

        if (examTimer != null) {
            examTimer.stop(); // Stop the previous timer if it exists
        }

        examTimer = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time left: " + timeRemaining + " sec");
                if (timeRemaining == 0) {
                    examTimer.stop();
                    if (currentQuestion < questions.length - 1) {
                        // Move to the next question
                        saveSelectedAnswer(); // Save the answer for the current question
                        currentQuestion++;
                        displayQuestion(currentQuestion);
                        startTimer(); // Start timer for the next question
                    } else {
                        // If it's the last question, submit the exam
                        JOptionPane.showMessageDialog(null, "Time's up! Submitting your exam.");
                        saveSelectedAnswer(); // Save the last answer
                        showResult();
                    }
                }
            }
        });
        examTimer.start();
    }

    private void showResult() {
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equals(selectedAnswers[i])) {
                score++;
            }
        }

        JOptionPane.showMessageDialog(this,
                "Exam submitted!\nYour Score: " + score + "/" + questions.length,
                "Result", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new LoginPage(); // Back to login
    }
}