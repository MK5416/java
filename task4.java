package intern;

import java.util.*;
public class task4 {

    public static void main(String[] args) {
    	System.out.println("Enter the size of the passsword:" );
    	Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        String characters = uppercaseLetters + lowercaseLetters + digits;

        String generatedPassword = generatePassword(length, characters);
        System.out.println("Generated Password: " + generatedPassword);
    }

    private static String generatePassword(int length, String characters) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i <length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}
