package org.example.Task_1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class AllMethods {
    private final static HttpClient client = HttpClient.newHttpClient();
    String uri = "https://jsonplaceholder.typicode.com/users";
    String uriToUpdateAndDelete = "https://jsonplaceholder.typicode.com/users/1";


    public HttpResponse<String> CreateNewUserOnServer(String jsonFromMyName) throws IOException, InterruptedException {
        HttpRequest requestToCreate = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(jsonFromMyName))
                .build();
        return client.send(requestToCreate, HttpResponse.BodyHandlers.ofString());
    }
    public  HttpResponse<String> UpdateUser(String jsonFromMyName) throws IOException, InterruptedException {
        HttpRequest requestUpdating = HttpRequest.newBuilder()
                .uri(URI.create(uriToUpdateAndDelete))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonFromMyName))
                .build();
        return client.send(requestUpdating, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> DeleteUser() throws IOException, InterruptedException {
        HttpRequest requestToDelete = HttpRequest.newBuilder()
                .uri(URI.create(uriToUpdateAndDelete))
                .header("Content-Type", "application/json; charset=UTF-8")
                .DELETE()
                .build();
        return client.send(requestToDelete, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> GetAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    public HttpResponse<String> GetUserById (int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .GET()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    public HttpResponse<String> GetUserByUsername (String username) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "?username=" + username))
                .GET()
                .timeout(Duration.of(20, SECONDS))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
