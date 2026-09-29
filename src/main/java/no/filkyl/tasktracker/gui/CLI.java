package no.filkyl.gui;

import no.filkyl.model.Task;
import no.filkyl.core.Library;
import no.filkyl.core.Storage;

import java.util.Scanner;
import java.util.List;

public class CLI {
    private Library library;
    private Storage storage;

    public CLI(Library l) {
        library = l;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[Task Tracker]\n");
        System.out.println("Type 'help' for help, or 'exit' to exit");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] args = input.split(" ");

            command(args);
        }
    }

    public void add(String[] args) {
        if (args.length != 4) {
            System.out.println("Use: add <course> <title> <due>");
            return;
        }

        String course = args[1];
        String title = args[2];
        String due = args[3];

        library.addTask(course, title, due);
        System.out.println("Added task " + title + ".");
    }

    public void list() {
        List<Task> tasks = library.getAllTasks();

        if (tasks.size() == 0) {
            System.out.println("No tasks in library.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task); 
        }
    }

    public void edit(String[] args) {
        if (args.length != 5) {
            System.out.println("Use: edit <id> <course> <title> <due>");
            return;
        }

        int id = Integer.parseInt(args[1]);
        String course = args[2];
        String title = args[3];
        String due = args[4];

        Task task = library.getTask(id);

        if (task == null) {
            System.out.println("Task with ID <" + id + "> was not found.");
            return;
        }

        library.editTask(task, course, title, due);
        System.out.println("Task with ID <" + id + "> was updated.");
    }

    public void finish(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: finish <id>");
        }

        int id = Integer.parseInt(args[1]);
        Task task = library.getTask(id);
        task.setFinished();
        System.out.println("Task with ID <" + id + "> was updated.");
    }

    public void remove(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: remove <id>");
            return;
        }

        int id = Integer.parseInt(args[1]);
        Task task = library.getTask(id);
        library.removeTask(task);
        System.out.println("Task with ID <" + id + "> was removed.");
    }

    public void command(String[] args) {
        if (args.length == 0) {
            return;
        }

        switch (args[0]) {
            case "add":
                add(args);
                break;
            case "list":
                list();
                break;
            case "edit":
                edit(args);
                break;
            case "finish":
                finish(args);
                break;
            case "remove":
                remove(args);
                break;
            case "help":
                printHelp();
                break;
            default:
                System.out.println("Unknown command: " + args[0]);
                printHelp();
        }
    }

    public void printHelp() {
        System.out.println("""
                [Task Tracker]

                Commands:
                    add <course> <title> <due>          add new task
                    list                                list all tasks by id
                    edit <id> <course> <title> <due>    edit a task
                    finish <id>                         mark task as finished
                    remove <id>                         remove task

                Arguments:
                    <course>                            course code
                    <title>                             task title
                    <due>                               task due date
                    <id>                                task id

                Example: 
                    add "ECON101" "Assignment 1" "01/01/26"
                """);
    }

}
