public class List{
    private ListElement head;
    
    public List(){
        head = null;
    }
    
    public void append(String c){
        if (c == null) {
            throw new IllegalArgumentException("s must be not null");
        } else {
            ListElement newNode = new ListElement(c);
            if(head == null){
                head = newNode;
                return;
            }
            ListElement lastel = _lastElement(); 
            lastel.setNext(newNode);
        }
    }
    
    public ListElement _lastElement(){
        ListElement watchedNode = head;
        while (watchedNode.getNext() != null){
                watchedNode = watchedNode.getNext();
            }
        return watchedNode;
    }

    public String remove(String s){
        if (s == null) {
            throw new IllegalArgumentException("s must be not null");
        } else if (s.equals("")){
            throw new IllegalArgumentException("s must be not empty");
        } else {
            String output = "";
            ListElement watchedNode = head;
            if(watchedNode == null){
                return null;
            }
            if(watchedNode.getNext() == null && watchedNode.getContent().equals(s)){
                output = head.getContent();
                head = null;
                return output;
            }
            while(watchedNode != null && watchedNode.getNext() != null){
                if(watchedNode.getContent() == s){
                    output = watchedNode.getContent();
                    head = watchedNode.getNext();
                    break;
                } else if (watchedNode.getNext().getContent() == s){
                    output = watchedNode.getNext().getContent();
                    if(watchedNode.getNext().getNext() == null){
                        watchedNode.setNext(null);
                    } else {
                        watchedNode.setNext(watchedNode.getNext().getNext());
                    }
                    break;
                } else{
                    output = null;
                }
                watchedNode = watchedNode.getNext();
            }
            return output;
        }
    }

    public String toString(){
        ListElement watchedNode = head;
        String output = "";
        while(watchedNode!= null){
            output += watchedNode.getContent() + ", ";
            watchedNode = watchedNode.getNext();
        }
        return output;
    }
    
    
    
    
}