package no.filkyl.core;

import no.filkyl.model.Task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Storage {
    private ObjectMapper mapper = new ObjectMapper();

    public void save(List<Task> tasks) {
        try {
            mapper.writeValue(new File("data/library.json"), tasks);
        } catch (IOException e) {
            System.out.println("Could not save tasks.");
        }
    }

    public List<Task> load() {
        try {
            List<Task> tasks = mapper.readValue(
                new File("data/library.json"),
                new TypeReference<List<Task>>() {}
            );
            return tasks;

        } catch (IOException e) {
            System.out.println("Could not load tasks.");
            return new ArrayList<>();
        }
    }


}
