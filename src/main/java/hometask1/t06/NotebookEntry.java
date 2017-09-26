package hometask1.t06;

/**
 * Class which describes Entity implementation
 */
public class NotebookEntry {
    private String text;

    public NotebookEntry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
