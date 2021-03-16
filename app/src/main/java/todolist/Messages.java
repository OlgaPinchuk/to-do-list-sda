package todolist;

import java.util.stream.IntStream;

public class Messages {

    public static void printWelcome() {
        System.out.println();
        System.out.println("Welcome to your awesome ToDo List");
    }

    /**
     * Print out the options a user can choose.
     */
    public static void printOptions(String[] opt) {
        IntStream.range(0, opt.length)
                .forEach(i -> System.out.println("\t (" + (i+1) + ") - " + opt[i]));
    }
}
