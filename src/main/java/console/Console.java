package console;

import java.util.Scanner;

public class Console {

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        return expression;
    }

    public static void output(Double s) {
        System.out.println(s);
    }
}
