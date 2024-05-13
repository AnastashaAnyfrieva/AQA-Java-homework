package by.Lesson7;

abstract class Animal {
    protected static int count;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

}
