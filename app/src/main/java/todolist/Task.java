package todolist;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class ToDoItem - an item in a tasks list.
 *
 * This class is a part of ToDoList application. It holds an information about
 * a title, due date, status and project of a particular task.
 *
 * @author Olha Pinchuk
 * @version 1.0
 */
public class Task implements Serializable {

    private String title;
    private String project; // stores a project to which a task belongs;
    private boolean complete;
    private LocalDate dueDate; // stores a task deadline date;

    /**
     * Constructor - initialise a new task.
     * Initially task is not completed.
     * @param taskTitle The task title.
     * @param projectName The name of the project.
     * @param deadlineDate The due date for a task completion.
     */
    public Task(String taskTitle, String projectName, LocalDate deadlineDate) {
        title = taskTitle;
        project = projectName;
        complete = false;
        dueDate = deadlineDate;
    }

    /**
     * Getter method for task title.
     * @return The title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define the title of a task.
     * @param taskTitle - provides the new title for the task.
     */
    public void setTitle(String taskTitle) {
        title = taskTitle;
    }

    /**
     * * Getter method for task project.
     * @return The name of the project to which the task belongs.
     */
    public String getProject() {
        return project;
    }

    /**
     * Define the project to which the task belongs.
     * * @param projectName - provides the new project name for the task.
     */
    public void setProject(String projectName) {
        project = projectName;
    }

    /**
     * Check whether a given task is completed.
     * @return true if it is, false if it's not.
     */
    public boolean isCompleted() {
        return complete;
    }

    /**
     * Return string definition if the task is completed.
     * @return String describing status of task.
     */
    public String printCompleted() {
        return complete ? "done" : "to do";
    }


    /**
     * Mark a task as completed.
     */
    public void setCompleted() {
        complete = true;
    }

    /**
     * Getter method for task due date.
     * @return The deadline date of the task.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the task due date.
     * @param newDate - new deadline date for the task.
     */
    public void setDueDate(String newDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            dueDate = LocalDate.parse(newDate, formatter);
        } catch(DateTimeParseException e) {
            System.out.println("Invalid date entered!");
        }
    }

    /**
     * The methods that overrides toString method.
     */
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-15s %-10s", title, project, dueDate, printCompleted());
    }
}

