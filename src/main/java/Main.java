import calculator.Calculation;
import console.Console;
import parsing.Parsing;
import validation.Validation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите числа и операторы через пробел в формате: 4.2 + 2 * 3 / 3 - 6.1");
        String stringIn = new Console().input();   //          4.2 + 2 * 3 / 3 - 6.1       168 / 12 * 2 / 15 + 15542 - 1546
        List<String> list = new Parsing().parseString(stringIn);
        new Validation().duplicationCheck(list);
        new Console().output(new Calculation().calculated(list));
    }
}
