package hometask1.t06;


import java.util.Scanner;

/**
 * Implementation of simple UI as console application
 * Removing and editing operations are unavailable.
 * This will be fixed soon
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Choose the action: \n" + "1. Add entry \n" + "2. Show all entries \n"
                + "3. Edit entry \n" + "4. Delete entry \n" + "5. Exit");
        Scanner sc = new Scanner(System.in);
        Notebook nb = new Notebook(5);
        String action = sc.nextLine();
        NotebookEntry[] entries;
        while (true) {
            if (action.equals("1") || action.equals("1.") || action.equals("Add entry")) {
                System.out.println("Write your entry");
                String text = sc.nextLine();
                nb.addEntry(text);
                action = sc.nextLine();
            }
            if (action.equals("2") || action.equals("2.") || action.equals("Show all entries")) {
                entries = nb.getEntries();
                for (int i = 0; i < entries.length; i++) {
                    if (entries[i] != null) {
                        System.out.println(entries[i].getText());
                    }
                }
                action = sc.nextLine();
            }
            if (action.equals("3") || action.equals("3.") || action.equals("Edit entry")) {
                System.out.println("Choose entry you want to edit");
                String text = sc.nextLine();
                nb.addEntry(text);
                action = sc.nextLine();
            }
            if (action.equals("4") || action.equals("4.") || action.equals("Delete entry")) {
                System.out.println("Choose entry you want to remove");
                String text = sc.nextLine();
                nb.addEntry(text);
                action = sc.nextLine();
            }
            if (action.equals("5") || action.equals("5.") || action.equals("Exit")) {
                System.exit(0);
            }
        }
    }

}
