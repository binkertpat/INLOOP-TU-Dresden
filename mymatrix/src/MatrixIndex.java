import java.util.Random;

public class MatrixIndex {
    private int row;
    private int column;

    public MatrixIndex(int row, int column){
        if(row < 0 || column < 0) throw new IllegalArgumentException();

        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

    public int hashCode(){
        return new Random().nextInt(10000);
    }
}
