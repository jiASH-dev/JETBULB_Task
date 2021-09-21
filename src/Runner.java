import MyConverter.NotationConverter;
import MyExceptions.InvalidValueException;

public class Runner {
    public static void main(String[] args) {
        NotationConverter notationConverter = new NotationConverter();
        String Meaning = "MCMXI";
        try {
            System.out.println("Значение: " + Meaning);
            System.out.println("Результат: " + notationConverter.toArabic(Meaning));
        }
        catch (InvalidValueException e) {
            e.printStackTrace();
        }
    }
}
