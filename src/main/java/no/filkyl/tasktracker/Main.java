package no.filkyl.tasktracker;

import no.filkyl.model.Task;
import no.filkyl.core.Library;
import no.filkyl.gui.CLI;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.load();

        // Set maxId
        int maxId = 0;
        for (Task task : library.getAllTasks()) {
            int id = task.getId();
            if (id > maxId) {
                maxId = id;
            }
        }
        Task.setNextId(maxId + 1);

        // Run CLI
        CLI cli = new CLI(library);
        cli.run();

        // Save library
        library.save();   
    }
}
