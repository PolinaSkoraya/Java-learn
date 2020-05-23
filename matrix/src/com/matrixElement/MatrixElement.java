package com.matrixElement;

public class MatrixElement {

    private int i;
    private int j;
    private int value;

    public MatrixElement(int rowIndex, int colIndex, int elementValue) {
        i = rowIndex;
        j = colIndex;
        value = elementValue;
    }

    public MatrixElement(MatrixElement element) {
        i = element.getRowIndex();
        j = element.getColIndex();
        value = element.getValue();
    }

    @Override
    public String toString() {
        return "MatrixElement{" +
                "i=" + i +
                ", j=" + j +
                ", value=" + value +
                '}';
    }

    public int getRowIndex() {
        return i;
    }

    public int getColIndex() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(MatrixElement element) {
        return (i == element.getRowIndex ()) && (j == element.getColIndex ()) && (value == element.getValue ());
    }
}
