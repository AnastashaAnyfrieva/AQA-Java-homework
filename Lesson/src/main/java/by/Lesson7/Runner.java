package by.Lesson7;

public class Runner {
    public static void main(String[] args) {

        Dog dog = new Dog();

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Барсик");
        cats[2] = new Cat("Васька");

        dog.run(400);
        dog.swim(5);

        cats[0].run(50);
        cats[0].swim(0);

        cats[1].run(150);
        cats[1].swim(10);

        cats[2].run(250);
        cats[2].swim(3);

        System.out.println("Количество созданных собак: " + Animal.getCount());
        System.out.println("Количество созданных котов: " + Cat.getCount());

        Bowl bowl = new Bowl(0);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        System.out.println();


        System.out.println();

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " голоден: " + cat.isHungry());
        }

        System.out.println();

        bowl.addFood(5);
        cats[0].eat(bowl);

        System.out.println(cats[0].getName() + " голоден: " + cats[0].isHungry());

        bowl.addFood(0);
        cats[1].eat(bowl);

        System.out.println(cats[1].getName() + " голоден: " + cats[1].isHungry());

        bowl.addFood(5);
        cats[2].eat(bowl);

        System.out.println(cats[2].getName() + " голоден: " + cats[2].isHungry());
    }
}

