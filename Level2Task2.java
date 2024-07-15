import java.util.*;
public class Level2Task2
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        System.out.println("Password Strength Checker");
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }
        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Strong password!");
        } else if (length >= 6 && hasUppercase && hasLowercase && (hasDigit || hasSpecialChar)) {
            System.out.println("Moderate password.");
        } else {
            System.out.println("Weak password. Please consider adding more characters and special symbols.");
        }
        scanner.close();
    }
}
