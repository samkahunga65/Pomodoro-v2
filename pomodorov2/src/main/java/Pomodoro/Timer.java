package Pomodoro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class Timer {
    UUID id = UUID.randomUUID();
    Long timeStarted;
    Long timeToEnd;
    Long pausedSeconds = 0L;
    Long startPauseTime;
    boolean paused = false;
    boolean exited = false;

    Timer() {
        timeStarted = System.currentTimeMillis();
    }

    public void pause() {
        startPauseTime = System.currentTimeMillis();
        paused = true;
    }

    public void unPause() {
        pausedSeconds = pausedSeconds + startPauseTime - System.currentTimeMillis();
        paused = false;
    }
    public void getTimeElapsed() {
        Long elapsedSecs = (timeStarted - System.currentTimeMillis() - pausedSeconds)/1000;
        int minutes = (int) (elapsedSecs / 3600)*-1;
        int seconds = (int) (elapsedSecs % 3600)*-1;
        System.out.println("you have accumulated mins: " + minutes + ", seconds: " + seconds);
        this.exited = true;
    }
    String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}