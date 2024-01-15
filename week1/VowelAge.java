import java.util.Scanner;

public class VowelAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        int age = input.nextInt();

        char[] name_chars = name.toLowerCase().toCharArray();
        int counter = 0;
        for (int i = 0; i < name_chars.length; i++) {
            char letter = name_chars[i];
            switch(letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    counter += 1;
                    break;
            }
        }

        String status = null;

        if (age < 18) {
            status = "a minor";
        } else {
            status = "an adult";
        }

        System.out.println("Hello " + name + ", you have " + counter + " vowels, and you are " + status);


    }
}