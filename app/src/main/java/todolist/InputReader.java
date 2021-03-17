package todolist;
import taskmanager.*;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void start() {
        boolean stop = false;
        Messages.printWelcome();
        printTasksStatus();

        int choice = 0;
        while(choice <= 0 || choice > taskManagers.length || !stop) {
            try {
                Messages.printOptions(options);
                choice = reader.nextInt();
                System.out.println("Your choice: " + taskManagers[choice-1].getClass().getSimpleName());
                stop = taskManagers[choice-1].run();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid Menu Selection.");
                System.out.println("Available options");
            }
            catch(InputMismatchException e){
                System.out.println("Error: Menu selection must be an integer! Please try again:");
                reader.next();
            }
        }
        reader.close();
    }

    /**
     * Print out the message with tasks status.
     */

    private void printTasksStatus() {
        System.out.println("You have " + InputReader.tasks.getIncompetedCount() + " todo and " + InputReader.tasks.getCompletedCount() + " tasks are done!");
    }



    /**
     * Saves user's text input. Checks if it's any.
     * @return String with user input.
     */
    public static String saveUserTextInput() {
        Scanner keyboard = new Scanner(System.in);
        String validInput;
        while((validInput = keyboard.nextLine()).isEmpty()) {
            System.out.println("Input is empty. Please try again");
        }
        return validInput;
    }


    /**
     * Checks if the user input is empty.
     * @return Boolean: true if empty, false otherwise.
     */
    public static boolean inputIsEmpty(String input) {
       return (input == null || input.trim().equals(""));
    }


}
