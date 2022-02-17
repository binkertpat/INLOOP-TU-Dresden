import java.util.*;

public class VehicleQueue implements ClockObserver {
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private int givenTime;
    private VehicleGenerator generator;
    private boolean greenLight = false;
    private Queue<Vehicle> queue = new LinkedList<>();

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator){
        if(entryDelay <= 0) throw new IllegalArgumentException();
        this.entryDelay = entryDelay;
        if(exitDelay <= 0) throw new IllegalArgumentException();
        this.exitDelay = exitDelay;
        if(trafficLightRate <= 0) throw new IllegalArgumentException();
        this.trafficLightRate = trafficLightRate;
        if(generator == null) throw new NullPointerException();
        this.generator = generator;
    }

    public void enter(){
        this.queue.add(this.generator.createVehicle());
    }

    public void leave(){
        this.queue.poll();
    }

    public int getSize(){
        return this.queue.size();
    }

    public double getLength(){
        double length = 0;
        for(Vehicle vehicle : this.queue){
            length += vehicle.getLength();
        }
        return length;
    }

    private int getTime(){
        return this.givenTime;
    }

    private void setTime(int time){
        if(time < 0) throw new IllegalArgumentException();
        this.givenTime = time;
    }

    private double LastTimeLeaved(){
        double leavedAmount = this.exitDelay * needToLeaveOnTimestamp(this.getTime() - 1);
        return Math.round(leavedAmount);
    }

    private void changeLightColor(){
        double changeTime = (this.givenTime % (this.trafficLightRate * 2)) % this.trafficLightRate;
        if(changeTime == 0) this.greenLight = !this.greenLight;
    }

    private boolean isSwitched(int time){
        if(time < 0) throw new IllegalArgumentException();
        return time != 0 && !isItTimeForGreenLight(time) && isItTimeForGreenLight(time - 1);
    }

    private boolean isItTimeForGreenLight(int time){
        if(time < 0) throw new IllegalArgumentException();
        return (time % (this.trafficLightRate * 2)) >= trafficLightRate;
    }

    private double ToEnterAmount(){
        double enter1 =  Math.floor(this.getTime() / this.entryDelay);
        double enter2 =  Math.floor((this.getTime() - 1) / this.entryDelay);
        return enter1 - enter2;
    }

    private double needToLeaveOnTimestamp(int time){
        if(time < 0) throw new IllegalArgumentException();
        if (time < this.trafficLightRate) return 0.00;
        return Math.floor((time % this.trafficLightRate) / this.exitDelay);
    }

    private double ToLeaveAmount(){
        double amountToHaveLeave;
        if (isSwitched(this.getTime())){
            amountToHaveLeave = (this.trafficLightRate - this.LastTimeLeaved()) / this.exitDelay;
            return Math.floor(amountToHaveLeave);
        } else{
            double leave1 = 0.00;
            double leave2 = 0.00;
            if(!((this.givenTime % (this.trafficLightRate * 2)) < this.trafficLightRate)){
                leave1 = Math.floor(((this.givenTime % (this.trafficLightRate * 2)) % this.trafficLightRate) / this.exitDelay);
            }
            if(!(((this.givenTime % (this.trafficLightRate * 2))  - 1) < this.trafficLightRate)){
                leave2 = Math.floor((((this.givenTime % (this.trafficLightRate * 2)) - 1) % this.trafficLightRate) / this.exitDelay);
            }
            return leave1 - leave2;
        }
    }

    @Override
    public void tick(int time){
        this.setTime(time);
        this.changeLightColor();

        double toEnter = ToEnterAmount();
        double toLeave = ToLeaveAmount();
        for (int i = 0; i < toEnter; i++) this.enter();
        for (int i = 0; i < toLeave; i++) this.leave();
    }
}