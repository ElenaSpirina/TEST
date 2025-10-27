public class Array {
    public static void main(String[] args) {
        // Создаем массив из трех строк
        String[] words = {"привет", "ПОКА", "гипербола"};

        // Выводим первую строку в верхнем регистре
        System.out.println(words[0].toUpperCase());

        // Выводим вторую строку в нижнем регистре
        System.out.println(words[1].toLowerCase());

        // Выводим третью строку где третьей буквой будет "О" и между третьей и четвертой буквой пробел
        StringBuilder result = new StringBuilder(words[2]);
        result.replace(2, 2, "О ");

        System.out.println(result);
    }
}