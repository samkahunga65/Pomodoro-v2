package Pomodoro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.UUID;

public class Kibarua implements Serializable {
    UUID id = UUID.randomUUID();
    static String saveFile = "vibarua";
    String name;
    UUID taskId;
    Pomodoro[] pomodoros;
    boolean pomodorosAreActive;
    boolean completed = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    Kibarua(String name, UUID taskId) {
        this.taskId = taskId;
        this.name = name;
        this.pomodorosAreActive = false;
    }
    boolean done() {
        return completed;
    }
    static Kibarua create(String name, UUID taskId) {
        return new Kibarua(name, taskId);
    }

    String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
    void startPomodoro() {
        var pom = new Pomodoro();
        pom
    }
    String getQuestion() {
        if(completed) {
            return "kibarua is completed with " + pomodoros.length + "pomodoros";
        }
        String outString = name + "\n(s) start pomodoro \n(c) complete kibarua";

        return outString;
    }
}
