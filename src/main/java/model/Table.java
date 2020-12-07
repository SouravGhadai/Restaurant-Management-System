package model;

import java.util.Objects;

public class Table {
    private int tableNumber;
    private boolean isAvailable;

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Table(int tableNumber, boolean isAvailable){
        this.tableNumber = tableNumber;
        this.isAvailable = isAvailable;
    }

    public Table(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return tableNumber == table.tableNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber);
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
