package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationTest {

    private List<String> list;

    @Test
    void testCalculationAdd() {
        list = new ArrayList<>();
        list.add("6");
        list.add("+");
        list.add("4");
        assertEquals(10, new Calculation().calculation(list));
    }

    @Test
    void testCalculationSubtract() {
        list = new ArrayList<>();
        list.add("6");
        list.add("-");
        list.add("4");
        assertEquals(2, new Calculation().calculation(list));
    }

    @Test
    void testCalculationMultiply() {
        list = new ArrayList<>();
        list.add("6");
        list.add("*");
        list.add("4");
        assertEquals(24, new Calculation().calculation(list));
    }

    @Test
    void testCalculationDivide() {
        list = new ArrayList<>();
        list.add("6");
        list.add("/");
        list.add("4");
        assertEquals(1.5, new Calculation().calculation(list));
    }

    @Test
    void testCalculationException() {
        list = new ArrayList<>();
        list.add("6");
        list.add("/");
        list.add("0");
        assertThrows(IllegalArgumentException.class, () -> new Calculation().calculation(list));
    }
}