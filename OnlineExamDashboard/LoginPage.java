package OnlineExamDashboard;

import javax.swing.*;
//import java.awt.event.*;

public class LoginPage extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginPage() {
        setTitle("Online Exam - Login");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            User loggedUser = UserDatabase.validateLogin(user, pass);
            if (loggedUser != null) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new ProfilePage(loggedUser);  // Go to the next step
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
