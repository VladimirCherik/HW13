package org.example.Task_3;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        MainWorkToGetUncompletedTasks mainWork = new MainWorkToGetUncompletedTasks();
        mainWork.getAllUncomletedTasks(1);
    }
}
