package no.filkyl.tasktracker;

import no.filkyl.model.Task;


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Task Tracker ---");

        String course = "IN2130";
        String name = "Oblig 2";
        String due = "02/10/26";

        Task task = new Task(course, name, due);

        System.out.println("\n--- Unfinished ---");
        System.out.println(task);

        task.setFinished();

        System.out.println("\n--- Finished ---");
        System.out.println(task);
    }
}
