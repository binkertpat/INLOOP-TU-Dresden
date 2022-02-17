public class Human {
  String forename;
  String name;
  
  public Human(String fn, String n) {
    forename = fn;
    name = n;
  }

  public String getName(){
      return name;
  }
  
  public String getForename(){
      return forename;
  }
  
  public String toString() {
        return forename + " " + name;
  }
}