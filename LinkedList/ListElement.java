public class ListElement{
    private String content = "";
    private ListElement next = null;
    
    public ListElement(String c){
        if (c == null) {
            throw new IllegalArgumentException("c must be not null");
        } else if (c.equals("")){
            throw new IllegalArgumentException("c must be not empty");
        } else {
            this.content = c;
        }
    }

    public String getContent(){
        return content;
    }

    public void setContent(String c){
        if (c == null) {
            throw new IllegalArgumentException("c must be not null");
        } else if (c.equals("")){
            throw new IllegalArgumentException("c must be not empty");
        }else {
            content = c;
        }
    }

    public ListElement getNext(){
        return next;
    }

    public void setNext(ListElement newElement){
        next = newElement;
    }
}