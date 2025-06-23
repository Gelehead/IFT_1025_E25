public class ChainedList<T> {

    class Cell {
        private T value;
        private Cell nextCell;

        public Cell(T value, Cell nextCell) {
            this.value = value;
            this.nextCell = nextCell;
        }

        public Cell getNext() {
            return nextCell;
        }

        public void setNextCell(Cell nextCell) {
            this.nextCell = nextCell;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private Cell firstCell;

    public ChainedList() {
        this.firstCell = null;
    }

    public Cell getLastCell() {
        if (firstCell == null) return null;

        Cell current = firstCell;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current;
    }

    public void addFirst(T value){
        Cell newCell = new Cell(value, this.firstCell);
        this.firstCell = newCell;
    }

    public void addLast(T value) {
        Cell newCell = new Cell(value, null);
        if (firstCell == null) {
            firstCell = newCell;
        } else {
            getLastCell().setNextCell(newCell);
        }
    }

    public T getCell(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Negative index");

        Cell current = firstCell;
        int i = 0;
        while (current != null && i < index) {
            current = current.getNext();
            i++;
        }

        if (current == null) throw new IndexOutOfBoundsException("Index exceeds list size");

        return current.getValue();
    }

    public Cell getFirstCell() {
        return firstCell;
    }

    public void setFirstCell(Cell firstCell) {
        this.firstCell = firstCell;
    }
}
