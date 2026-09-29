package no.filkyl.tasktracker;

import no.filkyl.core.Library;
import no.filkyl.gui.CLI;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.load();

        CLI cli = new CLI(library);
        cli.run();

        library.save();   
    }
}
