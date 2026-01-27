import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExceptionTest {
    @Test
    void exception() {

        try {
            System.out.println((String) null); // вызовет NullPointerException
        } catch (Exception e) {
            System.out.println("Поймано исключение при выводе: " + e);
        } finally {
            System.out.println("finally для блока System.out.println");
        }

        try {
            Assertions.assertTrue(false); // вызовет AssertionError
        } catch (AssertionError e) {
            System.out.println("Поймана ошибка проверки: " + e);
        } finally {
            System.out.println("finally для блока Assertions.assertTrue");
        }
    }
}

    