package taskmanager;
import todolist.InputReader;
import todolist.ToDoList;

import java.io.*;

/**
 * This class implements TaskManager interface and contains methods for saving the todolist to file before quiting the app
 * and loading the file with saved todolist after opening the app again.
 */
public class FileWriter implements TaskManager{

    /**
     * Implements run method of the interface TaskManager.
     *  @return true.
     */
    @Override
    public boolean run() {
        saveListToFile("tasks.txt", InputReader.tasks);
        return true;
    }

    /**
     * Saves the todolist to file before quiting the app.
     * @param fileName provides the path to the file to save the list.
     * @param taskList - todolist to save.
     */
    public void saveListToFile (String fileName, ToDoList taskList) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);

            output.close();
            file.close();
            System.out.println("Your tasks are successfully saved");
            System.out.println("See you later!");
        }
        catch(IOException e)
        {
            System.out.println("File does not exist " +  e);
        }
    }

    /**
     * Loads the saved todolist after opening the app.
     * @param fileName provides the path to the file to load the list.
     */
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

    /**
     * Returns the string with short class description
     * @return string with class description
     */
    @Override
    public String toString() {
        return "saving a list";
    }
}
