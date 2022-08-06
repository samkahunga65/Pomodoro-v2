package Pomodoro;

import java.util.Scanner;

public class Jinn {
    String startValue = 
    boolean summoned;
    Scanner scanner;
    boolean timerInProgress = false;
    String lastInput = "";
    Timer timer;
    Jinn() {
        this.scanner = new Scanner(System.in);
    }

    void summon() {
        while (summoned && lastInput != "x") {
            switch (scanner.next()) {
                case "p":
                    if(!timerInProgress) {
                        System.out.println("start a project");
                    } else {

                    }
                    lastInput = "p";
                    break;

                default:
                    break;
            }
        }
    }
}
