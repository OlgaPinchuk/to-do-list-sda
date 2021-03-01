package todolist;

import java.time.LocalDate;
/**
 * Class ToDoItem - an item in a tasks list.
 *
 * This class is a part of ToDoList application. It holds an information about
 * a title, due date, status and project of a particular task.
 *
 * @author Olha Pinchuk
 * @version 1.0
 */
public class ToDoItem {

    private String title;
    private String project; // stores a project to which a task belongs;
    private boolean complete;
    private LocalDate dueDate; // stores a task deadline date;

    /**
     /**
     * Constructor - initialise a new task.
     * Initially task is not completed.
     * @param taskTitle The task title.
     * @param projectName The name of the project.
     * @param deadlineDate The due date for a task completion.
     */
    public ToDoItem(String taskTitle, String projectName, String deadlineDate) {
        title = taskTitle;
        project = projectName;
        complete = false;
        dueDate = LocalDate.parse(deadlineDate);
    }

    /**
     * @return The title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define the title of a task.
     */
    public void setTitle(String taskTitle) {
        title = taskTitle;
    }

    /**
     * @return The name of the project to which the task belongs.
     */
    public String getProject() {
        return project;
    }

    /**
     * Define the project to which the task belongs.
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
     * Toggles the task completeness.
     * Set it to false if it was true or set it to true if it was false.
     */
    public void toggleCompleted() {
        complete = !complete;
    }

    /**
     * @return The deadline date of the task.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Define the task due date.
     */
    public void setDueDate(LocalDate newDate) {
         dueDate = newDate;
    }
}
