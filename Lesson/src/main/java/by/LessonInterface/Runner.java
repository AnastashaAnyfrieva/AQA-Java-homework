package by.LessonInterface;

public class Runner {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Синий", "Красный");
        Rectangle rectangle = new Rectangle(4, 6, "Желтый", "Зелёный");
        Triangle triangle = new Triangle(3, 4, 5, "Фиолетовый", "Черный");

        printShapeDetails(circle);
        printShapeDetails(rectangle);
        printShapeDetails(triangle);

    }
    public static void printShapeDetails(Shape shape) {

        System.out.println("Shape Details:");
        System.out.println("Название: " + shape.getName());
        System.out.println("Периметр: " + shape.getPerimeter());
        System.out.println("Площадь: " + shape.getArea());
        System.out.println("Цвет фона: " + shape.getFillColor());
        System.out.println("Цвет границ: " + shape.getBorderColor());
        System.out.println();
    }
}


