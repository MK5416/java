import java.io.*;
import java.util.*;
public class Level2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Encryption/Decryption Program");
        System.out.println("Choose an operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter the file name or path: ");
        String fileName = scanner.nextLine();
        switch (choice) {
            case 1:
                encryptFile(fileName);
                System.out.println("File encrypted successfully!");
                break;
            case 2:
                decryptFile(fileName);
                System.out.println("File decrypted successfully!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
        scanner.close();
    }
    private static void encryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void decryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char encryptedChar = (char) (text.charAt(i) + 1); 
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }
    private static String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char decryptedChar = (char) (text.charAt(i) - 1); 
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}
