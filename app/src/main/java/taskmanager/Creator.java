package taskmanager;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import todolist.InputReader;

public class Creator implements TaskManager {

    @Override
    public boolean run() {
        createTask();
        return false;
    }

    /**
     * Creates a task with the title, project, due date provided by the user.
     */
    public void createTask() {

            System.out.println("I need some details to create your task!");
            System.out.println("Title:");
            String title = InputReader.saveUserTextInput();

            System.out.println("Project:");
            String project = InputReader.saveUserTextInput();

            System.out.println("Due date:");

            LocalDate dueDate = setDueDate();

            InputReader.tasks.addTask(title, project, dueDate);
            System.out.println("The task is successfully created");

    }

    /**
     * Sets the due date of the task.
     * @return the deadline date.
     */
    public static LocalDate setDueDate() {
        LocalDate dueDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(true) {
            System.out.println("Enter valid date in format: yyyy-mm-dd");
            String inputDate = InputReader.saveUserTextInput();
            try {
                dueDate = LocalDate.parse(inputDate, formatter);
                break;
            } catch(DateTimeParseException e) {
                System.out.println("Invalid date entered!");
            }
        }
        return dueDate;
    }
}
