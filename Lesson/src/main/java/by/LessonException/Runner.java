package by.LessonException;

public class Runner {
    public static void main(String[] args) {
        String[][] array = {
                {"11", "2", "3", "6"},
                {"5", "25", "7", "1"},
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
        int columns = array.length;
            if (array.length != 4)throw new MyArraySizeException();
                for (String[] strings : array) {
                    if (strings.length != 4) throw new MyArraySizeException();
                }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

