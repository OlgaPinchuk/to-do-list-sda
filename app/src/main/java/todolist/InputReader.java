package todolist;
import taskmanager.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class serves for reading and processing user's input.
 */
public class InputReader {
    private final Scanner reader;
    public static ToDoList tasks;
    private final TaskManager [] taskManagers = { new ListPrinter(), new Creator(), new Editor(), new FileWriter() };
    private final String [] options = {
            "Show Task List (by date or project)",
            "Add New Task",
            "Edit Task (update, mark as done, remove)",
            "Save to File and Quit"
    };

    /**
     * Create a new InputReader that reads input from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
        tasks = new ToDoList();
    }
    /**
     * Starts the InputReader.
     */
    public void start() {
        boolean stop = false;
        int choice = 0;
        tasks = FileWriter.openSavedList("tasks.txt");

        MessagePrinter.printWelcome();

        while(choice <= 0 || choice > taskManagers.length || !stop) {
            try {
                MessagePrinter.printOptions(options);
                choice = reader.nextInt();
                System.out.println("Your choice: " + taskManagers[choice-1].toString());

                //Runs the corresponding TaskManager depending on the user choice.
                // Only FileWriter returns true and it stops the application
                stop = taskManagers[choice-1].run();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Selection.");
                System.out.println("Available options[1-4]:");
            } catch(InputMismatchException e){
                System.out.println("Menu selection should be an integer! Please try again:");
                reader.next();
            }
        }
        reader.close();
    }

    /**
     * Saves user's text input. Checks if it's any.
     * @return String with user input.
     */
    public static String saveUserTextInput() {
        Scanner keyboard = new Scanner(System.in);
        String validInput;
        while(!inputNotEmpty(validInput = keyboard.nextLine())) {
            System.out.println("Input is empty. Please try again");
        }
        return validInput;
    }

    /**
     * Checks if the user input is not empty.
     * @return Boolean: true if it is not empty, false otherwise.
     */
    public static boolean inputNotEmpty(String input) {
       return !(input == null || input.trim().equals(""));
    }

}
