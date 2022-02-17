public class Bottle<T extends Drink> {
private T content;
    public Bottle() {
        this.content = null;
    }
    public boolean isEmpty() {
        if (content == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void fill(T con) {
        if (this.isEmpty()) {
            this.content = con;
        } else {
            throw new IllegalStateException("Bottle not empty!");
        }
    }

    public T empty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Bottle must be filled");
        } else {
            T oldcontent = content;
            content = null;
            return oldcontent;
        }
    }
}