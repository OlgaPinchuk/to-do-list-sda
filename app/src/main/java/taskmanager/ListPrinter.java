package taskmanager;

public class ListPrinter implements TaskManager {

    @Override
    public boolean run() {
        System.out.println("Test choice 1: show todo list");
        return false;
    }

}
