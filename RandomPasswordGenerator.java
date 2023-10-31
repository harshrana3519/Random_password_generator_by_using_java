import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random Password Generator");

        // Get user-defined criteria
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("Y");

        // Check if at least one type of character is selected
        if (!(includeUppercase || includeLowercase || includeNumbers || includeSpecialChars)) {
            System.out.println("Error: You must include at least one type of character.");
            System.exit(1);
        }

        // Generate and display the random password
        String password = generateRandomPassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("Your random password: " + password);

        scanner.close();
    }

    private static String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase,
                                                 boolean includeNumbers, boolean includeSpecialChars) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        StringBuilder validChars = new StringBuilder();
        if (includeUppercase) validChars.append(uppercaseChars);
        if (includeLowercase) validChars.append(lowercaseChars);
        if (includeNumbers) validChars.append(numberChars);
        if (includeSpecialChars) validChars.append(specialChars);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
