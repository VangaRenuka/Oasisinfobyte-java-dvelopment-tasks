import java.util.Scanner;

public class OnlineReservationSystem {
    private static final int MAX_USERS = 100; // Maximum number of users
    private static final int MAX_RESERVATIONS = 50; // Maximum number of reservations

    private String[] usernames; // Array to store usernames
    private String[] passwords; // Array to store passwords
    private int userCount; // Counter for the number of registered users

    private String[] reservations; // Array to store reservations
    private int reservationCount; // Counter for the number of reservations

    public OnlineReservationSystem() {
        usernames = new String[MAX_USERS];
        passwords = new String[MAX_USERS];
        userCount = 0;

        reservations = new String[MAX_RESERVATIONS];
        reservationCount = 0;
    }

    public void registerUser(String username, String password) {
        if (userCount < MAX_USERS) {
            usernames[userCount] = username;
            passwords[userCount] = password;
            userCount++;
            System.out.println("Registration successful!");
        } else {
            System.out.println("Sorry, the registration is full.");
        }
    }

    public boolean loginUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void makeReservation(String reservation) {
        if (reservationCount < MAX_RESERVATIONS) {
            reservations[reservationCount] = reservation;
            reservationCount++;
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Sorry, all reservations are booked.");
        }
    }

    public void cancelReservation(String reservation) {
        boolean found = false;
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].equals(reservation)) {
                // Shift the remaining reservations to fill the gap
                for (int j = i; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservationCount--;
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Reservation canceled successfully!");
        } else {
            System.out.println("No matching reservation found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineReservationSystem reservationSystem = new OnlineReservationSystem();
        boolean isLoggedIn = false;

        while (true) {
            if (!isLoggedIn) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        reservationSystem.registerUser(username, password);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();
                        isLoggedIn = reservationSystem.loginUser(loginUsername, loginPassword);
                        if (isLoggedIn) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter reservation details: ");
                        String reservation = scanner.nextLine();
                        reservationSystem.makeReservation(reservation);
                        break;
                    case 2:
                        System.out.print("Enter reservation details: ");
                        String cancelReservation = scanner.nextLine();
                        reservationSystem.cancelReservation(cancelReservation);
                        break;
                    case 3:
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            System.out.println();
        }
    }
}
