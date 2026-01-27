import java.util.SplittableRandom;
// Родительский класс
class Employee {
    String name;
    double salary;

// Конструктор
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    // Метод work()
    public void work() {
        System.out.println(name + " работает как сотрудник и получает " + salary);
    }
}

// Подскласс Manager
class Manager extends Employee {
    // Вызов конструктора родительского класса
    public Manager(String name, double salary) {
    super(name, salary);
}
    // Перопределение метода work()
    public void work() {
        System.out.println(name + " работает менеджером и получает " + salary);
    }
}

// Подскласс Developer
class Developer extends Employee {
    // Вызов конструктора родительского класса
    public Developer(String name, double salary) {
        super(name, salary);
    }
    // Перопределение метода work()
    public void work() {
        System.out.println(name + " работает разработчиком и получает " + salary);
    }
}

// Класс для проверки
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Петр", 50000);
        Manager mgr = new Manager("Анна", 60000);
        Developer dev = new Developer("Иван", 70000);

        emp.work();
        mgr.work();
        dev.work();
    }
}




// Абстрактный класс
abstract class Shape {
    // Абстрактный метод (без реализации)
    abstract void draw();
}

// Подкласс Circle
class Circle extends Shape {
    void draw() {
        System.out.println("Рисуется фигура круг");
    }
}

// Подкласс Rectangle
class Rectangle extends Shape {
    void draw() {
        System.out.println("Рисуется фигура прямоугольник");
    }
}

// Основной класс для проверки
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();
    }
}