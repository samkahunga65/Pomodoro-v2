package Pomodoro;

public class Comment {
    String message;

    Comment(String message) {
        this.message = message;
    }
    static Comment create(String msg) {
        return new Comment(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
