package by.Lesson7;

class Dog extends Animal {

    public Dog() {
        super();
    }

    @Override
    public void run(int distance) {
        int maxRunDistance = 500;
        if (distance <= maxRunDistance) {
            System.out.println("Собака пробежала " + distance + " метров.");
        } else {
            System.out.println("Собака не может пробежать такое расстояние.");
        }
    }

    @Override
    public void swim(int distance) {
        int maxSwimDistance = 10;
        if (distance <= maxSwimDistance) {
            System.out.println("Собака проплыла " + distance + " метров.");
        } else {
            System.out.println("Собака не может проплыть такое расстояние.");
        }
    }
}
