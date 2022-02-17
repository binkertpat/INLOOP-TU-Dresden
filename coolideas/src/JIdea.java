import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JIdea extends  JContent{
    private JState state;
    private List<JAttachment> attachmentList;
    private JValuation valuation;

    public JIdea(String title, String description){
        super(title, description);
        this.state = new Draft();
        this.attachmentList = new ArrayList<>();

    }

    public String toString(){
        return "Idea: " + super.getTitle() + "\n" + super.getDescription();
    }

    public boolean removeAttachment(JAttachment attachment) {
        if(attachment == null) throw new NullPointerException();
        return attachmentList.remove(attachment);
    }

    public List<JAttachment> getAttachments() {
        return this.attachmentList;
    }

    public void addAttachment(JAttachment attachment) {
        if(attachment == null) throw new NullPointerException();
        attachmentList.add(attachment);
    }

    public JValuation getValuation() {
       return this.state.getValuation();
    }

    public String getCurrentDiscussion() {
        return this.state.getCurrentDiscussion();
    }

    public boolean isReleased() {
        return this.state instanceof ReleasedIdea;
    }

    public boolean isDeclined() {
        return this.state instanceof DeclinedIdea;
    }

    public void decline() {
        this.state.decline();
    }

    public void release() {
        this.state.release();
    }

    public void hold() {
        this.state.hold();
    }

    public void evaluate(JValuation valuation) {
        this.state.evaluate(valuation);
    }

    public void discuss(String text) {
        this.state.discuss(text);
    }

    abstract class JState {
        private String currentDiscussion = "";
        private JValuation valuation = null;

        public void discuss(String text){
            if(text.isEmpty()) throw new IllegalArgumentException();
            setCurrentDiscussion(getCurrentDiscussion() + text);
        }

        public void evaluate(JValuation valuation){
            if(valuation == null) throw new NullPointerException();
            this.valuation = new JValuation(valuation.getTitle(), valuation.getDescription());
        }

        public void hold(){
            if(state instanceof OpenDraft || state instanceof  Draft) state.hold();
            else throw new IllegalStateException();
        }

        public void release(){
            if(state instanceof ReleasedIdea) state.release();
            else throw new IllegalStateException();
        }

        public void decline(){
            if(state instanceof OpenDraft || state instanceof  Draft) state.decline();
            else throw new IllegalStateException();
        }


        public String getCurrentDiscussion(){
            return this.currentDiscussion;
        }

        public void setCurrentDiscussion(String currentDiscussion){
            if(currentDiscussion.isEmpty()) throw new IllegalArgumentException();
            this.currentDiscussion = currentDiscussion;
        }

        public JValuation getValuation(){
            return this.valuation;
        }

        public void setValuation(JValuation valuation){
            if(valuation == null) throw new NullPointerException();
            this.valuation = valuation;
        }
    }

    class Draft extends JState{
        @Override
        public void hold() {
            state = new OpenDraft();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }

        @Override
        public void discuss(String text){
            throw new IllegalStateException();
        }

        @Override
        public void evaluate(JValuation valuation){
            throw new IllegalStateException();
        }
    }

    class OpenDraft extends JState{
        @Override
        public void discuss(String text){
            if(text.isEmpty()) throw new IllegalArgumentException();
            state.setCurrentDiscussion(state.getCurrentDiscussion() + text + "\n");
        }

        @Override
        public void evaluate(JValuation valuation){
            state.setValuation(valuation);
        }

        @Override
        public void decline(){
            state = new DeclinedIdea();
        }

        @Override
        public void hold(){
            state = new ApprovedIdea();
        }
    }

    class ApprovedIdea extends JState{
        @Override
        public void release() {
            state = new ReleasedIdea();
        }

        @Override
        public void discuss(String text){
            throw new IllegalStateException();
        }

        @Override
        public void evaluate(JValuation valuation){
            throw new IllegalStateException();
        }

        @Override
        public void hold() {
            throw new IllegalStateException();
        }
    }

    class ReleasedIdea extends JState{
        @Override
        public void discuss(String text){
            throw new IllegalStateException();
        }

        @Override
        public void evaluate(JValuation valuation){
            throw new IllegalStateException();
        }

        @Override
        public void hold() {
            throw new IllegalStateException();
        }

        @Override
        public void release() {
            throw new IllegalStateException();
        }

    }

    class DeclinedIdea extends JState{
        @Override
        public void discuss(String text){
            throw new IllegalStateException();
        }

        @Override
        public void evaluate(JValuation valuation){
            throw new IllegalStateException();
        }

        @Override
        public void hold() {
            throw new IllegalStateException();
        }

        @Override
        public void release() {
            throw new IllegalStateException();
        }
    }
}
