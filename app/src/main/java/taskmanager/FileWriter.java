package taskmanager;
import todolist.InputReader;
import todolist.ToDoList;

import java.io.*;


public class FileWriter implements TaskManager{
    @Override
    public boolean run() {
        saveListToFile("tasks.txt", InputReader.tasks);
        return true;
    }

    public void saveListToFile (String fileName, ToDoList taskList) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);

            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File does not exist " +  e);
        }
    }

    public static ToDoList openSavedList(String fileName) {

        ToDoList tasks = new ToDoList();

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream output = new ObjectInputStream(file);

            tasks = (ToDoList) output.readObject();

            output.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println(e);
        }

        return tasks;
    }

}
