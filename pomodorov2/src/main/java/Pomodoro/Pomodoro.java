package Pomodoro;

import java.sql.Time;
import java.util.ArrayList;

import static Pomodoro.PomType.TWENTY;

public class Pomodoro {
    PomType pomType;
    ArrayList<Comment> comments;
    Timer timer;
    Pomodoro() {
        pomType = TWENTY;
        timer = new Timer();
    }
    void pauseTimer() {
        timer.pause();
    }

    void addComment(String comment) {
        comments.add(Comment.create(comment));
    }
}
