# Online Exam Dashboard

A comprehensive online examination system with timer-based MCQ tests and user profile management.

## Features

### Core Functionalities
- Secure user authentication
- Profile management (name/password updates)
- MCQ examination interface
- Per-question timer with auto-submission
- Instant score calculation
- Session management

### Exam Features
- Multiple-choice questions with single selection
- Question navigation
- Time-bound questions (60 seconds each)
- Automatic answer saving
- Immediate results after submission

## Technologies Used
- Java 17
- Java Swing for GUI
- Object-oriented design principles
- Event-driven programming

## Installation

1. **Prerequisites**:
   - Java JDK 17 or later

2. **Run the application**:
   ```bash
   java -cp "target/classes" Online-Exam-Dashboard.Main

## Usage

### Login Credentials
- **Default User Account**:
  - Username: `AmitPatil`
  - Password: `Patil@8221`

### Profile Management
- Update your full name
- Change account password
- Click "Start Exam" to begin test

### Examination
- 5 multiple-choice questions
- 60 seconds per question
- Auto-saves selected answers
- Manual navigation between questions
- Submit anytime or at final question

## Workflow

1. **Authentication**:
   - Launch application → Login screen appears
   - Enter valid credentials → Profile page loads

2. **Pre-Exam**:
   - Optionally update profile information
   - Click "Start Exam" button

3. **Examination**:
   - System displays first question with timer
   - Select answer (radio buttons)
   - Use "Next" or wait for auto-advance
   - Repeat for all questions

4. **Submission**:
   - Manual submission via "Submit" button
   - Auto-submission when time expires
   - Instant score calculation appears

5. **Session End**:
   - System displays score
   - Automatically returns to login screen

## Project Structure
src/
└── OnlineExamDashboard/
    ├── ExamPage.java          # MCQ examination interface
    ├── LoginPage.java         # Authentication screen
    ├── Main.java              # Application entry point
    ├── ProfilePage.java       # User profile management
    ├── ResultPage.java        # Score display (future implementation)
    ├── User.java              # User data model
    └── UserDatabase.java      # User storage and validation

## 🧑‍💻 Author

Amit Patil  
amitvpatil8221@gmail.com  
https://github.com/AmitPatil8221  

## 📄 License

This project is licensed under the MIT License. You are free to use, modify, and share it for learning or development purposes.
    
