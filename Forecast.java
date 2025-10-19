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
        Forecast person = new Forecast();
        person.city = "Москва";
        person.temperature = 5;
        person.Weather();
    }
}