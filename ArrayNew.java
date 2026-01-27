import java.util.Random;

public class ArrayNew {
    // Массив из трёх строк из задания с массивами
    public static String[] words = {"привет", "ПОКА", "гипербола"};

    public static void main(String[] args) {
        printWord();
    }

    // Метод который случайным образом выводит в консоль одну из трех строк
    public static void printWord() {
        Random random = new Random();
        int index = random.nextInt(3);
        System.out.println(words[index]);
    }
}