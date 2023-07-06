import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineExamination {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> userProfile = new HashMap<>();
    private static Map<String, String> answers = new HashMap<>();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        // Add sample users
        users.put("user1", "password1");
        users.put("user2", "password2");

        // Add sample user profiles
        userProfile.put("user1", "John Doe");
        userProfile.put("user2", "Jane Smith");

        // Add sample answers
        answers.put("Question 1", "Option A");
        answers.put("Question 2", "Option C");
        answers.put("Question 3", "Option B");

        showLoginScreen();
    }

    private static void showLoginScreen() {
        System.out.println("Welcome to the Online Examination System");
        System.out.println("----------------------------------------");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            isLoggedIn = true;
            System.out.println("Login successful!");

            showMainMenu();
        } else {
            System.out.println("Invalid username or password. Exiting...");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    private static void showMainMenu() {
        while (isLoggedIn) {
            System.out.println("\nMain Menu");
            System.out.println("------------------");
            System.out.println("1. Update Profile and Password");
            System.out.println("2. Select Answers for MCQs");
            System.out.println("3. Timer and Auto Submit");
            System.out.println("4. Closing Session and Logout");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    updateProfileAndPassword();
                    break;
                case 2:
                    selectAnswersForMCQs();
                    break;
                case 3:
                    startTimerAndAutoSubmit();
                    break;
                case 4:
                    closeSessionAndLogout();
                    break;
                case 5:
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Online Examination System. Goodbye!");
    }

    private static void updateProfileAndPassword() {
        System.out.println("\nUpdate Profile and Password");
        System.out.println("------------------");

        if (!isLoggedIn) {
            System.out.println("You are not logged in. Please login first.");
            return;
        }

        System.out.println("Current Profile: " + userProfile.get(getLoggedInUsername()));
        System.out.print("Enter new profile: ");
        String newProfile = scanner.nextLine();
        userProfile.put(getLoggedInUsername(), newProfile);

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        users.put(getLoggedInUsername(), newPassword);

        System.out.println("Profile and password updated successfully.");
    }

    private static void selectAnswersForMCQs() {
        System.out.println("\nSelect Answers for MCQs");
        System.out.println("------------------");

        if (!isLoggedIn) {
            System.out.println("You are not logged in. Please login first.");
            return;
        }

        for (String question : answers.keySet()) {
            System.out.println(question);
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            answers.put(question, answer);
        }

        System.out.println("Answers submitted successfully.");
    }

    private static void startTimerAndAutoSubmit() {
        System.out.println("\nTimer and Auto Submit");
        System.out.println("------------------");

        if (!isLoggedIn) {
            System.out.println("You are not logged in. Please login first.");
            return;
        }

        // Timer logic and auto submission

        System.out.println("Time's up! Your answers have been automatically submitted.");
    }

    private static void closeSessionAndLogout() {
        System.out.println("\nClosing Session and Logout");
        System.out.println("------------------");

        if (!isLoggedIn) {
            System.out.println("You are not logged in. Please login first.");
            return;
        }

        isLoggedIn = false;
        System.out.println("Session closed and logged out successfully.");
    }

    private static String getLoggedInUsername() {
        // Assuming only one user can be logged in at a time in this example
        for (String username : users.keySet()) {
            if (isLoggedIn) {
                return username;
            }
        }
        return null;
    }
}
