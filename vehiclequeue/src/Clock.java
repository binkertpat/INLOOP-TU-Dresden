import java.util.*;

public class Clock{
    private int currentTime = 0;
    public final int endOfTime;
    public List<ClockObserver> savedObserver;

    public Clock(int endOfTime){
        savedObserver = new ArrayList<>();
        if(endOfTime < 0) throw new IllegalArgumentException();
        this.endOfTime = endOfTime;
    }

    public void addObserver(ClockObserver observer){
        savedObserver.add(observer);
    }

    public void removeObserver(ClockObserver observer){
        savedObserver.remove(observer);
    }

    public int getCurrentTime(){
        return this.currentTime;
    }

    public void run(){
        this.currentTime = 0;
        while(this.getCurrentTime() < this.endOfTime){
            this.currentTime += 1;
            this.tick(this.currentTime);
        }
    }

    public void tick(int currentTime){
        for (ClockObserver clockobserver : savedObserver) {
            clockobserver.tick(currentTime);
        }
    }
}