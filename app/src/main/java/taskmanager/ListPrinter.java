package taskmanager;

import todolist.InputReader;
import todolist.MessagePrinter;

import java.util.Scanner;

/**
 * This class implements TaskManager interface and contains methods for print the todolist
 * for the user by date or by project.
 */
public class ListPrinter implements TaskManager {
    private final String [] options = {"by project", "by date"}; // printing options to choose

    /**
     * Implements run method of the interface TaskManager.
     *  @return false.
     */
    @Override
    public boolean run() {
        if(InputReader.tasks.getSize() > 0) {
            chooseList();
        }
        else {
            System.out.println("Your list is empty.Please add your tasks");
        }
        return false;
    }

    /**
     * Displays the task in the list by date or by project.
     */
    public void chooseList() {
        Scanner reader = new Scanner(System.in);
        int choice;
        do {
            listOptions();
            while (!reader.hasNextInt()) {
                System.out.println("That's not a number!");
                reader.next();
            }
            choice = reader.nextInt();
        } while (choice <= 0 || choice > options.length);

        switch (choice) {
            case 1 -> InputReader.tasks.sortByProject();
            case 2 -> InputReader.tasks.sortByDate();
        }
        InputReader.tasks.showList();
    }

    /**
     * Shows the sorting options in menu.
     */
    public void listOptions() {
        System.out.println("How should the tasks be ordered in a task list?");
        System.out.println("Please choose the correct number");
        MessagePrinter.printOptions(options);
    }

    /**
     * Returns the string with short class description
     * @return string with class description
     */
    @Override
    public String toString() {
        return "showing a list";
    }


}
