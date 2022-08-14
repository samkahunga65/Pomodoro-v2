package Pomodoro;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public enum FSM implements Dialog{
    MAINMENUDIALOG {
        @Override
        public void goBack() {
        }

        @Override
        public void goForward(Task task) {
            System.out.println(task.getQuestion());
        }

        public void getQuestion(ArrayList<Project> projects) {
            final String[] endString = {""};
            AtomicInteger count = new AtomicInteger();
            projects.forEach(project -> {
                endString[0] = endString[0] + "(" + count.get() + ") " + project.name + "\n";
                count.getAndIncrement();
            });
            int projectCompletion = (int) Math.floor(count.get()/projects.size()*100);
            System.out.println("Projects : " + projectCompletion + "%" + endString[0] );
        }

        @Override
        public void chooseOption() {

        }
    };
//    PROJECTDIALOG {},
//    TASKDIALOG {},
//    VIBARUADIALOG {},
//    KIBARUADIALOG {};
}
