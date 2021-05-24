package lectionHW.WebProtocol;

import com.google.gson.*;
import okhttp3.*;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebClient {
    private static final String REQUEST_URL ="https://jsonplaceholder.typicode.com";
    private WebUser [] users;
    private static OkHttpClient connection = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient();

        webClient.users = webClient.getUsers();
        webClient.getUserById(10);
        webClient.getUserByName("Kamren");
        WebUser newUser = new WebUser(/*webClient.users.length+1,*/"Ivan Bobrov","Bobr","bobr@reka.wood",
                new Address("MyStreet","MySuite","MyCity","000000",
                        new Geo("11.11111","22.2222")),"666-666-666","bobr.river.wood",
                new Company("Wood LLC","Catch if you can","Make more woods"));

        webClient.createNewUser(newUser);
        webClient.deleteUser(webClient.users[1].getUserName());
        webClient.updateInfo(webClient.users[1]);
        webClient.getComments("Kamren");
        webClient.getComments(2);
        webClient.getOpenTasks(1);

    }

    public WebUser[] getUsers() throws IOException {
        String url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder().build().toString();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Gson gson = new Gson();
        WebUser[] users = gson.fromJson(new BufferedReader(new InputStreamReader(connection.newCall(request).execute()
                .body().byteStream())).lines().collect(Collectors.joining("\n")), WebUser[].class);
        System.out.println("Get Users:\n" + connection.newCall(request).execute()+"\n******************");
        return users;
    }

    public WebUser getUserById(int id) throws IOException {
        String url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder()
                .addQueryParameter("id", String.valueOf(id))
                .build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Get User By Id (id=" + id + "):\n" + response + "\n******************");

        Gson gson = new Gson();
        return gson.fromJson(new BufferedReader(new InputStreamReader(connection.newCall(request).execute()
                .body().byteStream())).lines().collect(Collectors.joining("\n")), WebUser[].class)[0];
    }

    public WebUser getUserByName (String userName) throws IOException {
        String url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder()
                .addQueryParameter("username", userName)
                .build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = connection.newCall(request).execute();
        Gson gson = new Gson();
        WebUser user = gson.fromJson(new BufferedReader(new InputStreamReader(response.body().byteStream()))
                .lines().collect(Collectors.joining("\n")), WebUser[].class)[0];
        System.out.println("Get User By User Name (username=\"" + userName + "\"):\n" + response + "\n******************");
        return user;
    }

    public void createNewUser (WebUser newUser) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(newUser);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        String url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder().build().toString();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Add New User:\n" + response + "\n******************");
    }

    public void deleteUser (String userName) throws IOException {
        HttpUrl url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder().addPathSegment(userName).build();
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Delete User:\n" + response + "\n******************");
    }

    public void updateInfo(WebUser user) throws IOException {
        user.setPhone("3333-3333");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);
        System.out.println(json);
        HttpUrl url = HttpUrl.parse(REQUEST_URL+"/users").newBuilder().addPathSegment(String.valueOf(user.getId())).build();
        //RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        RequestBody body = new FormBody.Builder().add("phone", "3333-3333").build();
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Update User Info:\n" + response + "\n******************");
        printResponse(response);
    }

    public void printResponse (Response response){
        System.out.println(new BufferedReader(new InputStreamReader(response.body().byteStream()))
                .lines().collect(Collectors.joining("\n")));
    }
    public void getComments (String userName) throws IOException {
        int userId = getUserByName(userName).getId();
        HttpUrl url = HttpUrl.parse(REQUEST_URL + "/users/" + userId + "/posts");
        Request requestPosts = new Request.Builder()
                .url(url)
                .build();
        Response response = connection.newCall(requestPosts).execute();
        String stringResponse = new BufferedReader(new InputStreamReader(response.body().byteStream()))
                .lines().collect(Collectors.joining("\n"));
        int lastPostId = Integer.valueOf(stringResponse.substring(stringResponse.lastIndexOf("\"id\"")+6,
                stringResponse.indexOf(",",stringResponse.lastIndexOf("\"id\"")+6)));
        //System.out.println(lastPostId);
        url = HttpUrl.parse(REQUEST_URL + "/posts/" + lastPostId + "/comments");
        response = connection.newCall(new Request.Builder().url(url).build()).execute();
        try(FileWriter fw = new FileWriter("src/main/resources/user-" + userId + "-post-" + lastPostId + "-comments.json")) {
            fw.write(stringResponse);
        }
        //printResponse(response);
        System.out.println("File with comments for user \"" +userName + "\" is done:\n" + response + "\n******************");
    }

    public void getComments (int userId) throws IOException {
        HttpUrl url = HttpUrl.parse(REQUEST_URL + "/users/" + userId + "/posts");
        Request requestPosts = new Request.Builder()
                .url(url)
                .build();
        Response response = connection.newCall(requestPosts).execute();
        String stringResponse = new BufferedReader(new InputStreamReader(response.body().byteStream()))
                .lines().collect(Collectors.joining("\n"));
        int lastPostId = Integer.valueOf(stringResponse.substring(stringResponse.lastIndexOf("\"id\"")+6,
                stringResponse.indexOf(",",stringResponse.lastIndexOf("\"id\"")+6)));
        url = HttpUrl.parse(REQUEST_URL + "/posts/" + lastPostId + "/comments");
        response = connection.newCall(new Request.Builder().url(url).build()).execute();
        try(FileWriter fw = new FileWriter("src/main/resources/user-" + userId + "-post-" + lastPostId + "-comments.json")) {
            fw.write(new BufferedReader(new InputStreamReader(response.body().byteStream()))
                    .lines().collect(Collectors.joining("\n")));
        }
        System.out.println("File with comments for user " +userId + " is done:\n" + response + "\n******************");
    }

    public List<Task> getOpenTasks(int userId) throws IOException {
        Gson gson = new Gson();
        HttpUrl url = HttpUrl.parse(REQUEST_URL + "/users/" + userId + "/todos");
        Response response = connection.newCall(new Request.Builder().url(url).build()).execute();
        Task[] tempTasks = gson.fromJson(new BufferedReader(new InputStreamReader(response.body().byteStream()))
                .lines().collect(Collectors.joining("\n")), Task[].class);
        List<Task> tasks = new ArrayList<>();
        for (Task task : tempTasks) {
            if (!task.isCompleted()) tasks.add(task);
        }
        //System.out.println(tasks);
        System.out.println("List with open tasks for user " +userId + " is done :\n" + response + "\n******************");
        return tasks;
    }

}