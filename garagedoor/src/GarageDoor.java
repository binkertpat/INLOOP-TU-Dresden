public class GarageDoor {
    private DoorState currentState;
    private Motor motor;

    public GarageDoor(){
        this.currentState = new Closed();
        this.motor = new Motor();
    }

    public void openDoor(){
        currentState.openDoor();
    }

    public void stopper(){
        currentState.stopper();
    }

    public void closeDoor(){
        currentState.closeDoor();
    }

    public Motor getMotor(){
        return this.motor;
    }

    public void setMotor(Motor motor){
        this.motor = motor;
    }

    public DoorState getCurrentState(){
        return this.currentState;
    }

    public void setCurrentState(DoorState state){
        this.currentState = state;
    }

    public static abstract class DoorState {
        public abstract void openDoor();
        public abstract void closeDoor();
        public abstract void stopper();
    }

    public class Closed extends DoorState{
        @Override
        public void openDoor() {
            setCurrentState(new Opening());
            getMotor().upwards();
        }

        @Override
        public void closeDoor() {
            throw new IllegalStateException();
         }

         @Override
         public void stopper() {
             throw new IllegalStateException();
         }
    }

    public class Opening extends DoorState {

        @Override
        public void openDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void closeDoor() {
            setCurrentState(new Closing());
            getMotor().downwards();
        }

        @Override
        public void stopper() {
            setCurrentState(new Open());
            getMotor().stop();
        }
    }

    public class Open extends DoorState {
        @Override
        public void openDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void closeDoor() {
            setCurrentState(new Closing());
            getMotor().downwards();
        }

        @Override
        public void stopper() {
            throw new IllegalStateException();
        }
    }


    public class Closing extends DoorState {
        @Override
        public void openDoor() {
            setCurrentState(new Opening());
            getMotor().upwards();
        }

        @Override
        public void closeDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void stopper() {
            setCurrentState(new Closed());
            getMotor().stop();
        }
    }
}
