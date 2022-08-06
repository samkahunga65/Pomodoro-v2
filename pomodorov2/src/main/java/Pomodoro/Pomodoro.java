package Pomodoro;

import java.util.ArrayList;

import static Pomodoro.PomType.TWENTY;

public class Pomodoro {
    PomType pomType;
    ArrayList<Comment> comments;
    Pomodoro() {
        pomType = TWENTY;
    }

    void addComment(String comment) {
        comments.add(Comment.create(comment));
    }
}
