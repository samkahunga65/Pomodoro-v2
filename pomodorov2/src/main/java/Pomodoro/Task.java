package Pomodoro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Task {
    public boolean complete;
    UUID id = UUID.randomUUID();
    String name;
    ArrayList<Kibarua> vibarua;
    ArrayList<Kibarua> incompleteKibarua;

    public Kibarua[] getVibarua() {
        return vibarua.toArray(Kibarua[]::new);
    }

    String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
    String getQuestion() {
        var outString = "Vibarua :";
        int completed = (int) vibarua.stream().filter(kibarua -> kibarua.completed).count();
        int completionPercentage = (int) Math.floor((completed / (vibarua.size()))*100);
        AtomicReference<String> options = new AtomicReference<>("");
        this.incompleteKibarua = vibarua
                .stream()
                .filter(kibarua -> !kibarua.completed)
                .collect(Collectors.toCollection(ArrayList::new));
        AtomicInteger count = new AtomicInteger(0);
        incompleteKibarua.forEach(kibarua -> {
            options.set(options.get().concat("(" + count.get() + ") " + kibarua.name));
            count.getAndIncrement();
        });
        return outString + completionPercentage + "\n" + options.get();
    }

}
