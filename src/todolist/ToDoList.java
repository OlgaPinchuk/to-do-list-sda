package todolist;
import java.util.ArrayList;
import java.io.Serializable;

public class ToDoList implements Serializable {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    private boolean addTask(String title, String project, String deadline) {
       return tasks.add(new Task(title, project,deadline));
    }

    private boolean removeTask(Task task) {
        return tasks.remove(task);
    }

//    private void editTask(Task task){
//
//    }
}
