import calculator.Calculation;
import console.Console;
import parsing.Parsing;
import validation.Validation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String stringIn = Console.input();   //          4.2 + 2 * 3 / 3 - 6.1
        List<String> list = Parsing.parseString(stringIn);
        Validation.duplicationCheck(list);
        Console.output(Calculation.calculation(list));
    }
}
