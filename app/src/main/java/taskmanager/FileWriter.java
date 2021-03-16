package taskmanager;

public class FileWriter implements TaskManager{
    @Override
    public boolean run() {
        System.out.println("Test choice 4: save to file");
        return true;
    }
}
