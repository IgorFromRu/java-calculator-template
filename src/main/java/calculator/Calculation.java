package calculator;

import java.util.List;
import java.util.Stack;

public class Calculation {

    public static Double calculation(List<String> equation) {
        Stack<String> operation = new Stack<String>();
        Stack<Double> numbers = new Stack<Double>();
        Double number;

        for (String s : equation) {
            if (isNumber(s)) {
                numbers.push(Double.parseDouble(s));
            } else {
                if (operation.empty()) operation.push(s);
                else if (priority(s) > priority(operation.peek())) operation.push(s);
                else if (priority(s) <= priority(operation.peek())) {
                    while (priority(s) <= priority(operation.peek())) {
                        if (operation.size() == 1) break;
                        numbers.push(count(numbers.pop(), numbers.pop(), operation.pop()));
                    }
                    operation.push(s);
                }
            }
        }
        while (!operation.empty()) {
            numbers.push(count(numbers.pop(), numbers.pop(), operation.pop()));
        }
        number = numbers.pop();

        return number;
    }

    private static boolean isNumber(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int priority(String s) {
        if (s.equals("+") || s.equals("-")) {
            return 1;
        } else if (s.equals("*") || s.equals("/")) {
            return 2;
        }
        return 0;
    }

    private static Double count(Double d1, Double d2, String op) {
        if (op.equals("+")) return d1 + d2;
        else if (op.equals("-")) return d2 - d1;
        else if (op.equals("*")) return d1 * d2;
        else if (op.equals("/")) return d2 / d1;
        else return null;
    }
}