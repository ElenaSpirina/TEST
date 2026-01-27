public class Car {
    public String getModel() {
        return model;
    }
    // Методы get и set добалены с помощью генерации IDEA
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private String model;
    private int year;

    // Конструктор
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
    // Перегрузка конструктора
    public Car(String model) {
        this.model = model;
        this.year = 2025; // Значение по умолчанию
    }
    // Метод makeBeBe
    public void makeBeBe() {
        System.out.println("Машина " + model + " (" + year + " года), делает: БИ-БИП!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Для использования разных конструкторов
        Car car1 = new Car("Волга", 2007);
        Car car2 = new Car("Москвич");

        // Меняем значения через сеттер
        car1.setModel("BMW");
        car1.setYear(2016);
        car2.setYear(2000);

        // Вызываем метод makeBeBe
        car1.makeBeBe();
        car2.makeBeBe();

        // Выводим данные с помощью геттера
        System.out.println(car2.getModel() + " года " + car1.getYear());
    }
}