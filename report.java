class Forecast {
    public String city;
    public int temperature;
    public static String gradus = "градусов по цельсию";

    public void Weather() {
        System.out.println("Погода в городе " + city + " " + temperature + " " + gradus);
    }
}

public class Main {
    public static void main(String[] args) {
        Forecast report = new Forecast();
        report.city = "Москва";
        report.temperature = 5;
        report.Weather();
    }
}