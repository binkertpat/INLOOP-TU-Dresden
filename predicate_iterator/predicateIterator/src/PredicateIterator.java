import java.util.*;

public class PredicateIterator<T> implements Iterator<T>{
    private final Iterator<T> iter;
    private final Predicate<T> predicate;

    private T nextEl;
    private T remindOfLastHandledElement;

    public PredicateIterator(Iterator<T> iter, Predicate<T> predicate){
        if(iter == null){
            throw new NullPointerException("Iter should not be null.");
        }
        if(predicate == null){
            throw new NullPointerException("Predicate should not be null.");
        }
        this.iter = iter;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while(iter.hasNext()){
            T tempEl = iter.next();
            if(predicate.test(tempEl)){
                nextEl = tempEl;
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        if(remindOfLastHandledElement != null && remindOfLastHandledElement.equals(nextEl)){
            nextEl = iter.next();
        }
        while(!predicate.test(nextEl)){
            nextEl = iter.next();
        }
        remindOfLastHandledElement = nextEl;
        return nextEl;
    }
}