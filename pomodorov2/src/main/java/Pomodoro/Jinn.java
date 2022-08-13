package Pomodoro;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Jinn {
    String startStatement = "Hi, Sam. Welcome. \\n Project completion 12% \\n new kibarua (n) new task (t) \\n Pending tasks";
    ArrayList<String> pendingTasks;
    ArrayList<String> pendingVibarua;
    boolean summoned;
    Menus state = Menus.PROJECTSMENU;
    Scanner scanner;
    boolean timerInProgress = false;
    String lastInput = "";
    Timer timer;
    ArrayList<Project> projects;
    ArrayList<Task> currTasks;
    Project currProject;
    boolean activePomodoro = false;
    Task currTask;
    Kibarua currKibarua;
    Jinn(ArrayList<Project> projects) {
        this.scanner = new Scanner(System.in);
        this.projects = projects;
    }

    void summon() {
        var inputWasNumber = checkIfNumber(scanner.next());
        while (summoned && !Objects.equals(lastInput, "x")) {
            if (state == Menus.PROJECTSMENU) {
                if (inputWasNumber) {
                    currProject= projects.get(Integer.parseInt(scanner.next()));
                    System.out.println(currProject.getQuestion());
                    state = Menus.TASKSMENU;
                }

            } else if (state == Menus.TASKSMENU) {
                if (inputWasNumber) {
                    currTask = currProject.tasks.get(Integer.parseInt(scanner.next()));
                    System.out.println(currTask.getQuestion());
                    state = Menus.KIBARUAMENU;
                }

            } else {
                System.out.println("(x) complete task \n");
                if (!activePomodoro) {
                    System.out.println("(s) start pomodoro \n");
                } else {
                    System.out.println("(p) pause pomodoro \n");
                }
                if (inputWasNumber) {
                    currKibarua = currTask.getVibarua()[Integer.parseInt(scanner.next())];
                }
                switch (scanner.next()) {
                    case "x":
                        currTask.complete = true;
                        state = Menus.TASKSMENU;
                        System.out.println(cu);
                    default :
                        break;
                }
            }
            lastInput = scanner.next();
        }
    }
    void handleInput(String input, Menus state, ArrayList<Project> projects) {
        var isInputNumber = checkIfNumber(input);

    }
    boolean checkIfNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

enum Menus {
    PROJECTSMENU,
    TASKSMENU,
    KIBARUAMENU;
}