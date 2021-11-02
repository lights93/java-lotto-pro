import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String COMMA_OR_COLON = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        return sum(parseToIntArray(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(COMMA_OR_COLON);
    }

    private static int[] parseToIntArray(String[] textNumbers) {
        int[] numbers = new int[textNumbers.length];

        for (int i = 0; i < textNumbers.length; i++) {
            numbers[i] = parseToInt(textNumbers[i]);
        }

        return numbers;
    }

    private static int parseToInt(String textNumber) {
        int number = Integer.parseInt(textNumber);

        if (number < 0) {
            throw new IllegalArgumentException("음수 입력 불가능 number: " + number);
        }

        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
