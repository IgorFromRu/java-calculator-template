package validation;

import exceptions.InvalidRecordingFormatException;

import java.util.List;

public class Validation {

    public static void duplicationCheck(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                if (list.get(i).matches("^(\\()*(-)?\\d+(\\.\\d+)?(\\))*$") //  ^\d+(\.\d+)? любое число с точкой или без
                        || list.get(i).matches("^[\\+\\-\\*\\/]$")) {       // [\+\-\*\/] только знаки +,-,*,/
                } else {
                    throw new InvalidRecordingFormatException
                            ("Не верный формат ввода. Проверьте запись: " + list.get(i));
                }
            } catch (InvalidRecordingFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
