package Pomodoro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.UUID;

public class Project {
    UUID id = UUID.randomUUID();
    String name;
    ArrayList<Task> tasks;
    String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
