package todolist;

import java.util.stream.IntStream;

public class Printer {

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
     */
    public static void printOptions(String[] options) {
        IntStream.range(0, options.length)
                .forEach(i -> System.out.println("\t (" + (i+1) + ") - " + options[i]));
    }
}
