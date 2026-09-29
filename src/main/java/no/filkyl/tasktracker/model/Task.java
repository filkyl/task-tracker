package no.filkyl.model;

public class Task {

    private static int nextId = 1;

    private int id;
    private String course;
    private String title;
    private String due;
    private boolean finished;

    public Task() {}

    public Task(String c, String t, String d) {
        id = nextId++;
        course = c;
        title = t;
        due = d;
        finished = false;
    }

    public static void setNextId(int id) {
        Task.nextId = id;
    }

    public int getId() {return id;}

    public String getCourse() {return course;}

    public String getTitle() {return title;}

    public String getDue() {return due;}

    public boolean getFinished() {return finished;}

    public void setCourse(String c) {course = c;}

    public void setTitle(String t) {title = t;}

    public void setDue(String d) {due = d;}

    public void setFinished() {finished = true;}

    @Override
    public String toString() {
        return """
                ID: %d
                    Course: %s
                    Title: %s
                    Due: %s
                    Finished: %b
                """.formatted(id, course, title, due, finished);
    }

}
