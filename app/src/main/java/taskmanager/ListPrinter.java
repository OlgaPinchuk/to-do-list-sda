package taskmanager;

public class ListPrinter implements TaskManager {

    @Override
    public void run() {
        System.out.println("Test choice 1: show todo list");
    }

}
