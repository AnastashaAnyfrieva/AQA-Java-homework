package by.Lesson;

public class Park {
    private final String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        private final String name;
        private final String workingHours;
        private final double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Park park = new Park("Парк Фрунзе");

        Park.Attraction attraction1 = park.new Attraction("Качели", "10:00 - 20:00", 10.0);
        Park.Attraction attraction2 = park.new Attraction("Автодром", "10:00 - 22:00", 15.0);
        Park.Attraction attraction3 = park.new Attraction("Карусель", "11:00 - 19:00", 5.0);

        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();
    }
}