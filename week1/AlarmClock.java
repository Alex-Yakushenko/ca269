import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String alarm = input.nextLine();
        String current = input.nextLine();
        int counter = 0;
        while (true) {
            if (alarm.compareTo(current) < 0) {
                break;
            } else {
                current = input.nextLine();
                counter += 1;
            }
        }
        System.out.println("false alarms: " + counter);

    }
}
