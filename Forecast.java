class Forecast {
    // Две публичные переменные
    public String city;
    public int temperature;
    // Статическая переменная
    public static String gradus = "градусов по цельсию";

    // Метод, использующий статическую переменную
    public void Weather() {
        System.out.println("Погода в городе " + city + " " + temperature + " " + gradus);
    }
}
// Главный метод
public class Main {
    public static void main(String[] args) {
        Forecast moscow = new Forecast();
        Forecast volgograd = new Forecast();

        // Значение переменных
        moscow.city = "Москва";
        moscow.temperature = 5;

        volgograd.city = "Волгоград";
        volgograd.temperature = 10;

        // Выводим погоду в по цельсию
        moscow.Weather();
        volgograd.Weather();

        // Меняем статическую переменную на фарингейт
        Forecast.gradus = "градусов по фарингейту";

        System.out.println("Данные поменялись");

        // Выводим погоду по фарингейту
        moscow.Weather();
        volgograd.Weather();
    }
}