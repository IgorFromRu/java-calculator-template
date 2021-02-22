package parsing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ParsingTest {

    private Parsing parsing;

    @Test
    void parseString() {

        parsing = new Parsing();
        String s = "432 / 412 * 652 / 156 + 142 - 16";
        List<String> list = Arrays.asList(s.split(" "));
        Assert.assertArrayEquals(list.toArray(), new Parsing().parseString(s).toArray());
    }
}