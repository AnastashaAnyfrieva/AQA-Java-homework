package by.Lesson7;

class Cat extends Animal {
    private final String name;
    private boolean isHungry;

    public Cat(String name) {
        super();
        this.name = name;
        this.isHungry = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(int distance) {
        int maxRunDistance = 200;
        if (distance <= maxRunDistance) {
            System.out.println("Кот пробежал " + distance + " метров.");
        } else {
            System.out.println("Кот не может пробежать такое расстояние.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать, жаль кота.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= 5) {
            bowl.decreaseFood();
            isHungry = false;
            System.out.println("Кот поел из миски.");
        } else {
            System.out.println("В миске не достаточно еды для кота.");
        }
    }

    public boolean isHungry() {
        return isHungry;
    }
}