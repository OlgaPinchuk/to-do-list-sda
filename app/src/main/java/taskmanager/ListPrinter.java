package taskmanager;

import todolist.InputReader;
import todolist.Messages;

import java.util.Scanner;

public class ListPrinter implements TaskManager {
    private final String [] options = {"by project", "by date"};

    @Override
    public boolean run() {
        chooseList();
        return false;
    }

    public void chooseList() {
        Scanner reader = new Scanner(System.in);
        listOptions();
        int choice = reader.nextInt();
        switch (choice) {
            case 1 -> InputReader.tasks.sortByProject();
            case 2 -> InputReader.tasks.sortByDate();
        }
        InputReader.tasks.showList();
    }

    public void listOptions() {
        System.out.println("Please choose how you want to sort your tasks:");
        Messages.printOptions(options);
    }


}
