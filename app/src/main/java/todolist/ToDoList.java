package todolist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.stream.IntStream;
/**
 * Class ToDoList - list of all tasks.
 *
 * This class is a part of ToDoList application. It creates a list of the tasks.
 *
 * @author Olha Pinchuk
 * @version 1.0
 */
public class ToDoList implements Serializable {
    public ArrayList<Task> tasks;

    /**
     * Constructor - initialise a new todolist.
     * Initially it's empty.
     */
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    /**
     * Finds a task by its index.
     * @return Task by index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * @return The number of the tasks.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds the task to the end of the todolist.
     * @return true (as specified by Collection.add(E)).
     * @param title The title of the new task.
     * @param project The project to which the task belongs.
     * @param deadline The task deadline.
     */
    public boolean addTask(String title, String project, LocalDate deadline) {
       return tasks.add(new Task(title, project, deadline));
    }

    /**
     * Removes the task from the todolist by title.
     * @return true (as specified by Collection.remove(E)).
     * @param title The title of the task to remove.
     */
    public boolean removeTaskByTitle(String title) {
        return tasks.removeIf(task -> title.equals(task.getTitle()));
    }

    /**
     * Removes the task from the the todolist by the given index.
     * @param index The index of the task to remove.
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    /**
     * Gets the number of the completed tasks in the todolist.
     * @return the completed tasks number.
     */
    public long getCompletedCount() {
        return tasks.stream().filter(Task::isCompleted).count();
    }

    /**
     * Gets the number of the completed tasks in the todolist.
     * @return the completed tasks number.
     */
    public long getIncompetedCount() {
        return tasks.stream().filter(task -> !task.isCompleted()).count();
    }

    public void showList() {
        if(tasks.size() == 0) {
            System.out.println("You have no tasks to do");
            return;
        }

        String lineFormat = "%-5s %-20s %-20s %-15s %-10s";
        System.out.printf((lineFormat) + "%n", "#", "Title", "Project", "Due Date", "Status");
        System.out.printf((lineFormat) + "%n", "-", "-----", "-------", "--------", "------");

        IntStream.range(0, tasks.size())
                .mapToObj(index -> String.format("%d -> %s", index+1,
                        tasks.get(index).toString())).forEachOrdered(System.out::println);
    }

}
