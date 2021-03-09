package todolist;
import java.util.Scanner;

public class InputReader {
    private Scanner reader;
    private ToDoList tasks;

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
        boolean exit = false;
        int selection;

        printWelcome();
        printTasksStatus();

        while (!exit) {
            printChoices();
            selection = reader.nextInt();
            switch (selection) {
                case 1 :
                    System.out.println("Test line: choice 1");
                    exit = true;
                    break;

                case 2 :
                    System.out.println("Test line: choice 2");
                    exit = true;
                    break;
                case 3 :
                    System.out.println("Test line: choice 3");
                    exit = true;
                    break;
                case 4 :
                    System.out.println("Test line: choice 4");
                    exit = true;
                    break;
                default:
                    System.out.println("Make your choice");
            }
        }

    }
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to your awesome ToDo List");
    }

    private void printTasksStatus() {
        System.out.println("You have " + tasks.getNotCompetedCount() + " todo and " + tasks.getCompletedCount() + " tasks are done!");
    }

    private void printChoices() {
        System.out.println("Pick an option:");
        System.out.println("\t (1) - Show Task List (by date or project)");
        System.out.println("\t (2) - Add New Task");
        System.out.println("\t (3) - Edit Task (update, mark as done, remove)");
        System.out.println("\t (4) - Save and Quit");
    }


}
