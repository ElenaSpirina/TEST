import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box {
    private int width;
    private int height;
    private int depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}


public class BoxService {

    public static List<Box> moveBigWidthBoxes(List<Box> boxes) {
        List<Box> bigBoxes = new ArrayList<>();

        Iterator<Box> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();

            if (box.getWidth() > 30) {
                bigBoxes.add(box);
                iterator.remove();
            }
        }

        return bigBoxes;
    }

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(20, 10, 15));
        boxes.add(new Box(35, 20, 25));
        boxes.add(new Box(40, 30, 30));
        boxes.add(new Box(25, 15, 10));

        List<Box> bigBoxes = moveBigWidthBoxes(boxes);

        System.out.println("Коробки с шириной <= 30:");
        boxes.forEach(System.out::println);

        System.out.println("\nКоробки с шириной > 30:");
        bigBoxes.forEach(System.out::println);
    }
}