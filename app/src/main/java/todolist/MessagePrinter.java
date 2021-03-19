package todolist;

import java.util.stream.IntStream;

/**
 * Class Printer - prints the messages to the terminal.
 *
 * This class is a part of ToDoList application. Stores and the messages to terminal.
 */
public class MessagePrinter {

    /**
     * Print out the initial welcome message.
     */
    public static void printWelcome() {
        System.out.println("####################################");
        System.out.println();
        System.out.println("Welcome to your awesome ToDo List");
        System.out.println("You have " + InputReader.tasks.getIncompetedCount() + " todo and " + InputReader.tasks.getCompletedCount() + " tasks are done!");
    }

    /**
     * Print out the options a user can choose.
     * @param options provides the options to print out.
     */
    public static void printOptions(String[] options) {
        IntStream.range(0, options.length)
                .forEach(i -> System.out.println("\t (" + (i+1) + ") - " + options[i]));
    }

    /**
     * Print out the warning if the option is not valid.
     */
    public static void invalidOptionWarning() {
        System.out.println("Invalid Selection.");
        System.out.println("See available options:");
    }
}

