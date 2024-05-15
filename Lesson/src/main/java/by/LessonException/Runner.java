package by.LessonException;

public class Runner {

    public static void main(String[] args) {
        String[][] array = {
                {"11", "2", "3", "6"},
                {"5", "25", "7", "8"},
                {"9", "10", "1", "2"},
                {"13", "14", "1", "6"}
        };

        try {
            int sum = convertedArray(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }
    }

    public static int convertedArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int rows = array.length;
        int columns = array[0].length;

        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int x = Integer.parseInt(array[i][j]);
                    sum += x;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
