package taskmanager;
import todolist.InputReader;

import java.io.*;


public class FileWriter implements TaskManager{
    @Override
    public boolean run() {
        saveListToFile("task-list.txt");
        return true;
    }

    public void saveListToFile (String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(InputReader.tasks);
            oos.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println("File is not found");
        }
    }
}
