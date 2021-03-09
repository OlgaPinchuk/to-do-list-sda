package todolist;
import java.util.ArrayList;
import java.io.Serializable;

public class ToDoList implements Serializable {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public int getTasksNumber() {
        return tasks.size();
    }

    public boolean addTask(String title, String project, String deadline) {
       return tasks.add(new Task(title, project, deadline));
    }

    public boolean removeTaskByTitle(String title) {
        return tasks.removeIf(task -> title.equals(task.getTitle()));
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public long getCompletedCount() {
        return tasks.stream().filter(Task::isCompleted).count();
    }

    public long getNotCompetedCount() {
        return tasks.stream().filter(task -> !task.isCompleted()).count();
    }
}
