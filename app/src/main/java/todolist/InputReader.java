package todolist;
import taskmanager.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputReader {
    private Scanner reader;
    private ToDoList tasks;
    TaskManager [] taskManagers = { new ListPrinter(), new Creator(), new Editor(), new FileWriter() };


    /**
     * Create a new InputReader that reads input from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
        tasks = new ToDoList();
    }

    /**
     * Print out the welcoming message for the user.
     */

    public void start() {
        printWelcome();
        printTasksStatus();

        int choice = 0;
        while(choice <= 0 || choice >= taskManagers.length) {
            try {
                printOptions();
                choice = reader.nextInt();
                System.out.println("Your choice: " + taskManagers[choice-1].getClass().getSimpleName());
                taskManagers[choice-1].run();
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
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to your awesome ToDo List");
    }

    private void printTasksStatus() {
        System.out.println("You have " + tasks.getNotCompetedCount() + " todo and " + tasks.getCompletedCount() + " tasks are done!");
    }

    private void printOptions() {
        String [] options = {
                "Show Task List (by date or project)",
                "Add New Task",
                "Edit Task (update, mark as done, remove)",
                "Save to File and Quit"
        };

        IntStream.range(0, taskManagers.length)
                .forEach(i -> System.out.println("\t (" + (i+1) + ") - " + options[i]));
    }


}
