public class Main{
    public static void main(String args[]){
        List l = new List();
        l.append("1");
        l.append("2");
        l.append("3");
        l.append("4");
        l.append("5");
        l.append("6");
        System.out.println(l);
        l.remove("1");
        l.remove("6");
        l.remove("4");
        l.remove("2");
        l.remove("3");
        l.remove("5");
        l.remove("3");
        System.out.println(l);
    }
    
}