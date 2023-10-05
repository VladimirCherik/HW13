package org.example.Task_2;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        int userID = 1;

        MainWorkToCreateFile mainWork = new MainWorkToCreateFile();
        mainWork.createFileJsWithCommentsLastPostUserID(userID);
    }
}
