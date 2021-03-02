package todolist;
import java.util.ArrayList;
import java.io.Serializable;

public class ToDoList implements Serializable {
    private ArrayList<Task> todos;

    public ToDoList() {
        todos = new ArrayList<>();
    }
}
