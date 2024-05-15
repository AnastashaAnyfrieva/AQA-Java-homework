package by.LessonException;

class MyArrayDataException extends Exception {

    public MyArrayDataException(int rowIndex, int columnIndex) {
        super(String.format("Неверные данные в ячейке [%d, %d]", rowIndex, columnIndex));
    }

}


