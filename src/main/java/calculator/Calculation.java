package calculator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class Calculation {

    public Double calculated(List<String> equation) {
        Stack<String> operation = new Stack<String>();
        Stack<Double> numbers = new Stack<Double>();
        Double number;

        for (String s : equation) {
            if (isNumber(s)) {
                numbers.push(Double.parseDouble(s));
            } else {
                if (operation.empty()) {
                    operation.push(s);
                }
                else if (priority(operation.peek()) >= priority(s)) {
                    numbers.push(count(numbers.pop(),numbers.pop(),operation.pop()));
                    operation.push(s);
                }else if (priority(operation.peek()) < priority(s)) {
                    operation.push(s);
                }
            }
        }
        while (!operation.empty()){
            numbers.push(count(numbers.pop(), numbers.pop(), operation.pop()));
        }
        number = numbers.pop();

        return number;
    }

    private boolean isNumber(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int priority(String s) {
        if (s.equals("+") || s.equals("-")) {
            return 1;
        } else if (s.equals("*") || s.equals("/")) {
            return 2;
        }
        return 0;
    }

    private Double count(Double dob1, Double dob2, String op) {
        BigDecimal d1 = BigDecimal.valueOf(dob1);
        BigDecimal d2 = BigDecimal.valueOf(dob2);
        try {
            if (op.equals("+")) {
                return d1.add(d2).doubleValue();
            }
            else if (op.equals("-")) {
                return d2.subtract(d1).doubleValue();
            }
            else if (op.equals("*")) {
                return d1.multiply(d2).doubleValue();
            }
            else if (op.equals("/")) {
                return d2.divide(d1, 6).doubleValue();
            }
            else return null;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("Не верный формат.");
        }
    }
}