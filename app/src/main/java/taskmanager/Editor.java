package taskmanager;
import todolist.InputReader;
import todolist.Messages;
import  todolist.Task;

import java.util.Scanner;


public class Editor implements TaskManager {
    private final String [] options = {"Edit Task fields", "Mark Task as Done", "Remove Task"};

    @Override
    public boolean run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Which task would you like to edit?\n");
        if(InputReader.tasks.getSize() > 0) {
            InputReader.tasks.showList();
            int index = selectTask()-1;
            Task chosenTask = InputReader.tasks.getTask(index);
            editOptions();
            int choice = reader.nextInt();
            switch (choice) {
                case 1 -> editTask(chosenTask);
                case 2 -> chosenTask.setCompleted();
                case 3 -> InputReader.tasks.removeTask(index);
            }
        }
        else {
            System.out.println("Your list is empty.Please add your first task.");
        }
        return false;
    }


    public int selectTask() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please choose the task to edit");
        return keyboard.nextInt();
    }

    public void editOptions() {
        System.out.println("How do you want to edit a task?");
        Messages.printOptions(options);
    }


    public void editTask(Task task) {
        System.out.println("Update test");
    }

}
