import java.util.*;

public class MyMatrix<T> extends HashMap<MatrixIndex,T> implements Matrix<T>{
    static final long serialVersionUID = 42L;
    private Map<MatrixIndex, T> myMatrix = new HashMap<>();
    int RowCount = 0;
    int ColumnCount = 0;

    @Override
    public int getRowCount() {
        return this.RowCount;
    }

    @Override
    public int getColumnCount() {
        return this.ColumnCount;
    }

    @Override
    public int getObjectCount() {
        return this.myMatrix.size();
    }

    @Override
    public int getDistinctObjectCount() {
        return new HashSet<>(this.myMatrix.values()).size();
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    public class DepthFirstIterator implements Iterator<T>{
        private int actualRow = 0;
        private int actualColumn = 0;

        @Override
        public boolean hasNext() {
            if(actualColumn < ColumnCount - 1) return true;
            if(actualColumn >= ColumnCount) return false;
            if(actualRow >= RowCount - 1) return false;

            for(int i = actualRow + 1; i < RowCount; i++){
                if(get(i, actualColumn) != null) return true;
            }

            return false;
        }

        @Override
        public T next() {

            if (!hasNext()) throw new NoSuchElementException();

            for(int i = actualColumn; i < ColumnCount; i++){
                int startRow = 0;
                if(i == actualColumn){startRow = actualRow + 1;}
                else {startRow = 0;}

                for(int j = startRow; j < RowCount; j++){
                    T value = get(j, i);
                    if(value != null){
                        actualRow = j;
                        actualColumn = i;
                        return value;
                    }
                }
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public T get(int row, int column) {

        myMatrix.forEach((key, value) -> System.out.println(key.getRow() + " " + key.getColumn() + " "+ value));

        T foundedValue = null;

        if(row < 0 || column < 0 || row >= RowCount || column >= ColumnCount) throw new IllegalArgumentException();
        MatrixIndex keyMatrix = new MatrixIndex(row, column);

        for(Map.Entry<MatrixIndex, T> mi : myMatrix.entrySet()) {
            if(mi.getKey().getRow() == row && mi.getKey().getColumn() == column){
                foundedValue = mi.getValue();
            }
        }

        return foundedValue;
    }

    @Override
    public T put(int row, int column, T value) {
        if(row < 0 || column < 0) throw new IllegalArgumentException();
        if(value == null) return null;

        T existingValue = null;

        for(Map.Entry<MatrixIndex, T> mi : myMatrix.entrySet()) {
            if(mi.getKey().getRow() == row && mi.getKey().getColumn() == column){
                existingValue = mi.getValue();
            }
        }

        checkMaxBounds(row, column);
        MatrixIndex keyMatrix = new MatrixIndex(row, column);

        this.myMatrix.put(keyMatrix, value);
        return existingValue;


    }

    public void checkMaxBounds(int row, int column){
        Set<MatrixIndex> keySet = this.myMatrix.keySet();
        int maxColumn = 0;
        int maxRow = 0;

        for(MatrixIndex mi : keySet){
            if(mi.getColumn() > maxColumn){
                maxColumn = mi.getColumn();
            }
            if(mi.getRow() > maxRow){
                maxRow = mi.getRow();
            }
        }

        if(row > maxRow) this.RowCount = row + 1;
        if(column > maxColumn) this.ColumnCount = column + 1;

    }

    @Override
    public boolean contains(T value) {
        return this.myMatrix.containsValue(value);
    }
}
