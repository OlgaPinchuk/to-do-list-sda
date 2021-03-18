package taskmanager;
import todolist.InputReader;
import todolist.MessagePrinter;
import  todolist.Task;

import java.util.Scanner;
/**
 *
 * This class implements TaskManager interface and contains methods for editing tasks in the todolist.
 */
public class Editor implements TaskManager {
    private final String [] options = {"Edit Task Fields", "Mark Task as Done", "Remove Task"}; //editing options to choose

    /**
     * Implements run method of the interface TaskManager.
     *  @return false.
     */
    @Override
    public boolean run() {
        Scanner reader = new Scanner(System.in);
        if(InputReader.tasks.getSize() > 0) {
            System.out.println("Which task would you like to edit?");
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

    /**
     * Selects a task to edit.
     *  @return the index of the task.
     */
    public int selectTask() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please choose the task to edit");
        return keyboard.nextInt();
    }

    /**
     * Prints the options for editing.
     */
    public void editOptions() {
        System.out.println("How do you want to edit a task?");
        MessagePrinter.printOptions(options);
    }

    /**
     *  Chooses and edits the task fields. If user presses ENTER without providing the new value
     *  the field isn't changed.
     * @param task  - the chosen task for editing.
     */
    public void editTask(Task task) {
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.println("To change the task's fields please provide the following:");
            System.out.println("Update the field or just press ENTER to skip editing the field");
            System.out.println("New Title:");
            String newTitle = keyboard.nextLine();
            if(InputReader.inputNotEmpty(newTitle)) {
                task.setTitle(newTitle);
            }
            System.out.println("New Project:");
            String newProject = keyboard.nextLine();
            if(InputReader.inputNotEmpty(newProject)) {
                task.setProject(newProject);
            }
            System.out.println("New Due Date [yyyy-MM-dd]:");
            String newDueDate = keyboard.nextLine();
            if(InputReader.inputNotEmpty(newDueDate)) {
                task.setDueDate(newDueDate);
            }
        }
        catch(Exception e) {
            System.out.println("The error occurs:"+ e.getMessage());
        }
    }

}
