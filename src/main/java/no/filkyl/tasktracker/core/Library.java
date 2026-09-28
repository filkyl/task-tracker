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
        return tasks;
    }

    public Task getTask(int i) {
        return tasks.get(i);
    }

    public void addTask(Task t) {
        tasks.add(t);
    }
    
    public void removeTask(Task t) {
        tasks.remove(t);
    }

    public void editTask(int i, String c, String n, String d, boolean b) {
        Task task = tasks.get(i);
        task.setCourse(c);
        task.setName(n);
        task.setDue(d);
        if (b) {
            task.setFinished();
        }; 
    }

    public void saveTasks() {
        storage.save(tasks);
    }

    public void loadTasks() {
        tasks = storage.load();
    }


}
