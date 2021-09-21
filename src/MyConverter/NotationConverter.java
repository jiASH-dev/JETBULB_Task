package MyConverter;

import MyExceptions.InvalidValueException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        final String PATH = "src/MyProperties/Meaning";
        Properties properties = new Properties();
        ArrayList<Integer> integers = new ArrayList<>();
        char[] symbolsArray = romanNotation.toCharArray();
        int iterator = 0;
        int result = 0;

        try {
            properties.load(new FileReader(PATH));
            for (char c : symbolsArray) {
                String arabicNumber = properties.getProperty(String.valueOf(c));
                if (arabicNumber == null) {
                    throw new InvalidValueException("String must contain only valid romans numerals [I, V, X, L, C, D, M]");
                } else {
                    integers.add(Integer.parseInt(arabicNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (iterator < integers.size()) {
            try {
                if (integers.get(iterator) < integers.get(iterator + 1)) {
                    result += integers.get(iterator + 1) - integers.get(iterator);
                    iterator += 2;
                } else {
                    result += integers.get(iterator);
                    iterator++;
                }
            } catch (IndexOutOfBoundsException e) {
                result += integers.get(iterator);
                break;
            }
        }

        return result;
    }
}
