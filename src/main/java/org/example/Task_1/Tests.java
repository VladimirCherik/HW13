package org.example.Task_1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Tests {


    public static void main(String[] args) throws IOException, InterruptedException {

        // Create Object User with my Name
        String jsonFromMyName = createJsonFromMyName();
        System.out.println(jsonFromMyName);

        AllMethods allMethods = new AllMethods();

        //Create a new user on server
        HttpResponse<String> responseToCreate = allMethods.CreateNewUserOnServer(jsonFromMyName);

        System.out.println(responseToCreate.statusCode() + " = responseToCreate.statusCode()");
        System.out.println(responseToCreate.headers());
        System.out.println(responseToCreate.body());


        // UpdateUser
        HttpResponse<String> responseToUpdate = allMethods.UpdateUser(jsonFromMyName);

        System.out.println(responseToUpdate.statusCode() + " = responseToUpdate.statusCode()");
        System.out.println(responseToUpdate.headers());
        System.out.println(responseToUpdate.body());


        //DeleteUser
        HttpResponse<String> responseToDelete = allMethods.DeleteUser();

        System.out.println(responseToDelete.statusCode() + " = responseToDelete.statusCode()");
        System.out.println(responseToDelete.headers());
        System.out.println(responseToDelete.body());


        //GetAllUsers
        HttpResponse<String> allUsers = allMethods.GetAllUsers();

        System.out.println(allUsers.statusCode() + " = allUsers.statusCode()");
        System.out.println(allUsers.headers());
        System.out.println(allUsers.body());

        //GetUserById
        HttpResponse<String> userById = allMethods.GetUserById(10);

        System.out.println(userById.statusCode() + " = userById.statusCode()");
        System.out.println(userById.headers());
        System.out.println(userById.body());

        //GetUserByUsername
        HttpResponse<String> userByUsername = allMethods.GetUserByUsername("Elwyn.Skiles");

        System.out.println(userByUsername.statusCode() + " = userByUsername.statusCode()");
        System.out.println(userByUsername.headers());
        System.out.println(userByUsername.body());


    }
    public static String createJsonFromMyName(){

        User userWithMyName = new User(1, "Vladimir Cherik", "Bret", "Sincere@april.biz",
                new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874",
                        new Geo(-37.3159, 81.1496)
                ), "024-648-3804", "ambrose.net",
                new Company("Hoeger LLC", "Centralized empowering task-force", "target end-to-end models")
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(userWithMyName);
    }
}
