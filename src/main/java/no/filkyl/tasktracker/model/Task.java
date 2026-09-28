package no.filkyl.model;

public class Task {
    
    private String course;
    private String name;
    private String due;
    private boolean finished;

    public Task(String c, String n, String d) {
        course = c;
        name = n;
        due = d;
        finished = false;
    }

    public String getCourse() {return course;}

    public String getName() {return name;}

    public String getDue() {return due;}

    public boolean getStatus() {return finished;}

    public void setCourse(String c) {course = c;}

    public void setName(String n) {name = n;}

    public void setDue(String d) {due = d;}

    public void setFinished() {finished = true;}

    @Override
    public String toString() {
        String s;
        s = "Course: " + course + "\nName: " + name + "\nDue: " + due + "\nFinished: " + finished;
        return s;
    }

}
