package Pomodoro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Project {
    UUID id = UUID.randomUUID();
    String name;
    ArrayList<Task> tasks;
    ArrayList<Task> incompleteTasks;
    Project(String name,ArrayList<Task> tasks) {
        this.name = name;
    }
    String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
    String getQuestion() {
        AtomicInteger completedTasks = new AtomicInteger();
        String options = "";
        AtomicInteger count = new AtomicInteger();
        tasks.forEach(task -> {
            var nc = task.vibarua.stream().map(kibarua -> !kibarua.completed).findAny();
            if(nc.isEmpty()) {
                completedTasks.incrementAndGet();
            } else {
                options.concat("(" + count.get() + ") " + task.name + "\n");
            }
            count.getAndIncrement();
        });
        int percentageCompletion = (int) Math.floor(completedTasks.get()/tasks.size()*100);
        return "Tasks : " + percentageCompletion + "% \n" + options;

    }
}
