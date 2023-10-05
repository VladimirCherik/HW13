package org.example.Task_2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWorkToCreateFile {

    private final static HttpClient client = HttpClient.newHttpClient();
    public void createFileJsWithCommentsLastPostUserID(int userId) throws IOException, InterruptedException {

        //Get all posts of one user
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/" + userId + "/posts"))
                .GET()
                .build();
        String allPosts = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        //Find number of last post
        Pattern compile = Pattern.compile("\\\"id\": \\d+");
        Matcher matcher = compile.matcher(allPosts);
        ArrayList<String> arraysIdPost = new ArrayList<>();
        while (matcher.find()){
            arraysIdPost.add(matcher.group());
        }
        String lastIdPost = arraysIdPost.get(arraysIdPost.size() - 1);
        String[] split = lastIdPost.split(" ");
        int lastIdDigit = Integer.parseInt(split[1]);

        //Get all comments of last post
        HttpRequest requestAllComments = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + lastIdDigit + "/comments"))
                .GET()
                .build();
        String allComments = client.send(requestAllComments, HttpResponse.BodyHandlers.ofString()).body();

        //Create and write the file
        String jsonFilePath = "src/main/resources/" + "user-" + userId + "-post-" + lastIdDigit + "-comments.json";
        File file = new File(jsonFilePath);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(allComments);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        System.out.println(allComments);
    }
}
