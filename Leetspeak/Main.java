public class Main {
    public static void main(String[] args) {
  
        String [] input = {"We are elite hackers!", "Informatiker machen coole Sachen!"};

        String [] ausgabe = Leet.allToLeet(input);

        for(int i = 0; i < ausgabe.length; i++){
            System.out.println(ausgabe[i]);
        }
    }
}