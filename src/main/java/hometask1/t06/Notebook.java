package hometask1.t06;

public class Notebook {
    private final int size;
    private NotebookEntry[] entries;

    public Notebook(int size) {
        this.size = size;
        entries = new NotebookEntry[size];
    }

    public void addEntry(String text){

        NotebookEntry[] array = getEntries();
        for(int i = 0; i < array.length; i++){

            if((array[i] == null)){
                array[i] = new NotebookEntry(text);
                break;
            }
        }
    }

    public void removeEntry(String text){
        NotebookEntry[] array = getEntries();
        for(int i = 0; i < array.length; i++){
            if((array[i].getText().equals(text))){
                array[i] = null;
            }
            break;
        }
    }

    public void editEntry(String text, String newText){
        NotebookEntry[] array = getEntries();
        for(int i = 0; i < array.length; i++){
            if((array[i].getText().equals(text))){
                array[i].setText(newText);
            }
            break;
        }
    }

    public int getSize() {
        return size;
    }

    public NotebookEntry[] getEntries() {
        return entries;
    }

}
