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
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.println("To change the task's fields please provide the following:");
            System.out.println("Update the field or just press ENTER to skip editing the field");
            System.out.println("New Title:");
            String newTitle = keyboard.nextLine();
            if(!InputReader.inputIsEmpty(newTitle)) {
                System.out.println("Title is not empty");
                task.setTitle(newTitle);
            }
            System.out.println("New Project:");
            String newProject = keyboard.nextLine();
            if(!InputReader.inputIsEmpty(newProject)) {
                System.out.println("Project is not empty");
                task.setProject(newProject);
            }
            System.out.println("New Due Date [yyyy-MM-dd]:");
            String newDueDate = keyboard.nextLine();
            if(!InputReader.inputIsEmpty(newDueDate)) {
                System.out.println("Due Date is not empty");
                task.setDueDate(newDueDate);
            }

        }
        catch(Exception e) {
            System.out.println("The error occurs:"+ e.getMessage());
        }
    }

}
