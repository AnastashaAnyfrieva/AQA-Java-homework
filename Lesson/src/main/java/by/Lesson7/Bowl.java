package by.Lesson7;

class Bowl {
    private int food;
    // private final int minAmountOfFood = 5;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood() {
        if (food > 0) {
            food--;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлена еда.");
        }
    }
}
