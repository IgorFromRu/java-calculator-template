package parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parsing {

    public List<String> parseString(String s) {
        List<String> list = new ArrayList<String>();
        String[] strings = s.split("\\s+");
        Collections.addAll(list, strings);
        return list;
    }
}
