package org.example.Task_3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MainWorkToGetUncompletedTasks {
    private final static HttpClient client = HttpClient.newHttpClient();
    public void getAllUncomletedTasks(int userId) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/" + userId + "/todos"))
                .GET()
                .build();
        String allTasks = client.send(request, HttpResponse.BodyHandlers.ofString()).body();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ToDosJPH[] todosArray = gson.fromJson(allTasks, ToDosJPH[].class);

        List<ToDosJPH> resultList = new ArrayList<>();
        for (ToDosJPH element : todosArray) {
            if (!element.completed) {
                resultList.add(element);
            }
        }
        String outputString = gson.toJson(resultList.toArray());

        System.out.println(outputString);
    }

    class ToDosJPH {
        int userId;
        int id;
        String title;
        boolean completed;

        public ToDosJPH(int userId, int id, String title, boolean completed) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }
    }
}
