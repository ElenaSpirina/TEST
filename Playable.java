// Интерфейс с методом play(), который принимает количество струн
interface Playable {
    void play(int strings);
}

// Класс с вложенным Enum где указано количество струн
class Instruments {

    // Вложенный enum с количеством струн
    enum Strings {
        GUITAR_STRINGS(6),
        PIANO_STRINGS(230);

        private final int numberOfStrings;

        Strings(int numberOfStrings) {
            this.numberOfStrings = numberOfStrings;
        }

        public int getNumberOfStrings() {
            return numberOfStrings;
        }
    }
}

// Класс Guitar реализующий интерфейс Playable
class Guitar implements Playable {
    @Override
    public void play(int strings) {
        System.out.println("Гитара играет используя " + strings + " струн.");
    }
}

// Класс Piano реализующий интерфейс Playable
class Piano implements Playable {
    @Override
    public void play(int strings) {
        System.out.println("Пианино играет используя " + strings + " струн.");
    }
}

// Класс для проверки
public class Main {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        // Передаём количество струн из вложенного enum
        guitar.play(Instruments.Strings.GUITAR_STRINGS.getNumberOfStrings());
        piano.play(Instruments.Strings.PIANO_STRINGS.getNumberOfStrings());
    }
}