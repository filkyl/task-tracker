package no.filkyl.core;

import no.filkyl.model.Task;
import no.filkyl.core.Storage;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Task> tasks;
    private Storage storage;

    public Library() {
        tasks = new ArrayList<>();
        storage = new Storage();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task getTask(int i) {
        for (Task task : tasks) {
            if (task.getId() == i) {
                return task;
            }
        }
        return null;
    }

    public void addTask(String c, String t, String d) {
        Task task = new Task(c, t, d);
        tasks.add(task);
    }
    
    public void removeTask(Task t) {
        tasks.remove(t);
    }

    public void editTask(Task tsk, String c, String t, String d) {
        Task task = tsk;
        task.setCourse(c);
        task.setTitle(t);
        task.setDue(d);
    }

    public void save() {
        storage.saveTasks(tasks);
    }

    public void load() {
        tasks = storage.loadTasks();
    }


}
