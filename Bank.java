import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        // Создаем класс scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        float summa = scanner.nextFloat();

        System.out.print("Введите срок вклада в месяцах: ");
        int months = scanner.nextInt();

        // Создаем цикл while
        int x = 1;
        while (x <= months) {
            summa += summa * 0.07f;
            x++;
        }
        System.out.printf("После %d месяцев сумма вклада составит %.2f%n", months, summa);
    }

}



public class Bank {
    public static void main(String[] args) {
        // Создаем класс scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        float summa = scanner.nextFloat();

        System.out.print("Введите срок вклада в месяцах: ");
        int months = scanner.nextInt();

        // Создаем цикл for
        for (int x = 1; x <= months; x++) {
            summa += summa * 0.07f;
        }
        System.out.printf("После %d месяцев сумма вклада составит %.2f%n", months, summa);
    }

}