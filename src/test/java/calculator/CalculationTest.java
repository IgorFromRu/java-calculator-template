package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationTest {

    private List<String> list;
    private Calculation calculation;

    @Test
    void testCalculationAdd() {
        list = new ArrayList<>();
        calculation = new Calculation();
        list.add("6");
        list.add("+");
        list.add("4");
        assertEquals(10, calculation.calculated(list));
    }

    @Test
    void testCalculationSubtract() {
        list = new ArrayList<>();
        calculation = new Calculation();
        list.add("6");
        list.add("-");
        list.add("4");
        assertEquals(2, new Calculation().calculated(list));
    }

    @Test
    void testCalculationMultiply() {
        list = new ArrayList<>();
        calculation = new Calculation();
        list.add("6");
        list.add("*");
        list.add("4");
        assertEquals(24, new Calculation().calculated(list));
    }

    @Test
    void testCalculationDivide() {
        list = new ArrayList<>();
        calculation = new Calculation();
        list.add("6");
        list.add("/");
        list.add("4");
        assertEquals(1.5, new Calculation().calculated(list));
    }

    @Test
    void testCalculationException() {
        list = new ArrayList<>();
        calculation = new Calculation();
        list.add("6");
        list.add("/");
        list.add("0");
        assertThrows(IllegalArgumentException.class, () -> new Calculation().calculated(list));
    }
}