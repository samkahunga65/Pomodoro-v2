package Pomodoro;

import java.util.ArrayList;
import java.util.Scanner;

public class Jinn {
    ArrayList<Project> projects;
    Project currentProject;
    Task currentTask;
    String lastInput = "";
    Scanner scanner;
    Menu currentMenu;
    Kibarua currentKibarua;
    boolean currentKibaruActive;
    Jinn(ArrayList<Project> projects) {
        this.projects = projects;
        System.out.println("projects :\n");
        projects.forEach(project -> System.out.println(project.name + ":" + project.getCompletionPercentage() + "\n"));
        currentMenu = Menu.PROJECTSMENU;
        this.scanner = new Scanner(System.in);
        currentKibaruActive = false;
    }
    void summon() {
        while (lastInput != "q") {
            if (inputIsInteger(scanner.next())) {
                var input = Integer.parseInt(scanner.next());
                switch (currentMenu) {
                    case PROJECTSMENU:
                        if(input > projects.size()) {
                            System.out.println("choose a valid option");
                        } else {
                            currentProject = projects.get(input);
                            System.out.println(currentProject.getQuestion());
                            currentMenu = Menu.TASKSMENU;
                        }
                    case TASKSMENU:
                        if(input > currentProject.tasks.size()) {
                            System.out.println("choose a valid option");
                        } else {
                            currentTask = currentProject.tasks.get(input);
                            System.out.println(currentTask.getQuestion());
                            currentMenu = Menu.KIBARUAMENU;
                        }
                    case KIBARUAMENU:
                        if (!currentKibaruActive){
                        if(input > currentTask.vibarua.size()) {
                            System.out.println("choose a valid option");
                        } else {
                            currentKibarua = currentTask.vibarua.get(input);
                            System.out.println(currentKibarua.getQuestion());
                        }
                        }
                    default :
                        break;
                }
            } else {
                switch (scanner.next()) {
                    case "s":
                        currentKibarua.
                    default :
                        break;
                }
            }
            lastInput = scanner.next();
        }
    }
    boolean inputIsInteger(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

enum Menu {
    PROJECTSMENU,
    TASKSMENU,
    KIBARUAMENU
}