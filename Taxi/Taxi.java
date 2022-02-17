public class Taxi {
    Human driver;
    Human[] passengers = new Human[4];
    int passengerIdx = 0;

    public Taxi(Human d){
        driver = d;
    }

    public String getDriverName(){
        return driver.toString();
    }
    
    public void add(Human passenger){
        if(passengerIdx != 4){
           passengers[passengerIdx] = passenger;
           System.out.println(passenger.toString() + " gets in."); 
           passengerIdx += 1;         
        } else {
            System.out.println("We are sorry, " + passenger.toString() + ". The taxi is full.");
        }
    }

    // public String toString() {
    //     String output = "This is the taxi of ";
    //     if (passengerIdx == 0){
    //         output += driver.toString() + ". He takes nobody along."; 
    //     } else if (passengerIdx == 1) {
    //         output += driver.toString() + ". He takes " + passengers[passengerIdx - 1].toString() + " along.";
    //     } else if (passengerIdx == 2) {
    //         output += driver.toString() + ". He takes " + passengers[passengerIdx - 2].toString() + " and " + passengers[passengerIdx - 1].toString() +  " along.";
    //     } else if (passengerIdx == 3) {
    //         output += driver.toString() + ". He takes " + passengers[passengerIdx - 3].toString() + ", " + passengers[passengerIdx - 2].toString();
    //         output += " and " + passengers[passengerIdx - 1] + " along.";
    //     } else if (passengerIdx == 4) {
    //         output += driver.toString() + ". He takes " + passengers[passengerIdx - 4].toString() + ", " + passengers[passengerIdx - 3].toString();
    //         output += ", " + passengers[passengerIdx - 2] + " and " + passengers[passengerIdx - 1] + " along.";
    //     }
    //     return output;
    // }

    public String toString() {
        String output = "This is the taxi of " + driver.toString() + ". He takes ";

        if (passengers[0] == null){
            return output += "nobody along.";
        }

        for(int i = 0; i < passengers.length; i++){
            if(passengers[i] != null){
                output += passengers[i] + ", ";    
            }
        }
        if(passengers[1] != null){
            output = output.substring(0, output.lastIndexOf(", ") - 1) + "." ;
            output = output.substring(0, output.lastIndexOf(", ") - 1) + " and" + output.substring(output.lastIndexOf(", ") + 1) ;
        } 
        return output;
    }


    public Human[] allGetOut(){
        Human[] output = new Human[passengerIdx];
        for(int i = 0; i < output.length; i++){
            output[i] = passengers[i];
            passengers[i] = null;
            passengerIdx--;   
        }
        return output;
    }
}