package exercise.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    private static final String PHONE_NUMBER_REGEX = "^[(][1-9]{2}[)][-][(][0][1-9]{9}[)]$";

    public PhoneNumberExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
