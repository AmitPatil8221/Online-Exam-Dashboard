package OnlineExamDashboard;

import java.util.HashMap;

public class UserDatabase {
    private static final HashMap<String, User> users = new HashMap<>();

    // Static block to preload a sample user
    static {
        users.put("AmitPatil", new User("AmitPatil", "Patil@8221", "Amit Vitthal Patil"));
    }

    public static User validateLogin(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static boolean updateProfile(String username, String newName, String newPassword) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.setFullName(newName);
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    public static User getUser(String username) {
        return users.get(username);
    }
}
