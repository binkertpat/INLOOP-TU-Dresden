import java.util.*;

public class TextFileIterator implements Iterator<String>{
        private Iterator<String> iter;
        private List<String> iterableListOfString;
        private Resource res;
        private String givenText = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";

        public TextFileIterator(Resource res){
            if(res == null){
                throw new NullPointerException("Resource should not be null.");
            }
            this.res = res;

            String[] singleWords = replaceShittyCharacters().split(" ");
            iterableListOfString = Arrays.asList(singleWords);
            this.iter = iterableListOfString.iterator();
        }

        public boolean hasNext(){
            return iter.hasNext();
        }

        public String next(){
            return iter.next();
        }

        public void remove(){
            throw new UnsupportedOperationException("You can't delete in this project.");
        }

        public String getAsString(Resource res){
            return res.getName();
        }

        public String replaceShittyCharacters(){
            String replacedText = givenText;
            replacedText = replacedText.replace("-\n", "");
            replacedText = replacedText.replace("\n", "");
            replacedText = replacedText.replace("!", " ");
            replacedText = replacedText.replace(".", "");

            return replacedText;
        }
    
}