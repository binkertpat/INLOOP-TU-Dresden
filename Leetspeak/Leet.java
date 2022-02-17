public class Leet{
    public static String toLeet(String normal){
        String[] normalwords = {"elite", "cool", "!", "ck", "ers", "er", "en", "e", "t", "o", "a"};
        String[] leetwords = {"1337", "k3wl","!!!11","xx","0rz", "0rz", "n","3","7","0","@"};

        for (int i = 0; i< normalwords.length; i++){
            normal = normal.replace(normalwords[i], leetwords[i]);
        }
        
        return normal;
    }
    
    public static String[] allToLeet(String[] normals) {
        String[] output = new String[normals.length];
        for (int i = 0; i < normals.length; i++){
            output[i] = toLeet(normals[i]); 
        }
        return output;
    }
}
