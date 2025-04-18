package OnlineExamDashboard;

import javax.swing.*;
//import java.awt.event.*;

public class ProfilePage extends JFrame {
    private final User currentUser;
    private final JTextField nameField;
    private final JPasswordField passwordField;

    public ProfilePage(User user) {
        this.currentUser = user;

        setTitle("Welcome, " + user.getUsername());
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField(user.getFullName());
        nameField.setBounds(140, 30, 200, 25);
        add(nameField);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(30, 70, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField(user.getPassword());
        passwordField.setBounds(140, 70, 200, 25);
        add(passwordField);

        JButton updateButton = new JButton("Update Profile");
        updateButton.setBounds(140, 110, 150, 30);
        add(updateButton);

        JButton startExamButton = new JButton("Start Exam");
        startExamButton.setBounds(140, 160, 150, 30);
        add(startExamButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(140, 210, 150, 30);
        add(logoutButton);

        updateButton.addActionListener(e -> {
            String newName = nameField.getText();
            String newPass = new String(passwordField.getPassword());
            boolean updated = UserDatabase.updateProfile(user.getUsername(), newName, newPass);
            if (updated) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update profile.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        startExamButton.addActionListener(e -> {
            dispose();
            new ExamPage(currentUser);  // Go to exam
        });

        logoutButton.addActionListener(e -> {
            dispose();
            new LoginPage();  // Back to login
        });

        setVisible(true);
    }
}
