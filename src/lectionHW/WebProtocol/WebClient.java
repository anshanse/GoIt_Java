package lectionHW.WebProtocol;

import com.google.gson.*;
import okhttp3.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class WebClient {
    private static final String TEST_URL ="https://jsonplaceholder.typicode.com/users";
    private WebUser [] users;

    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient();
        OkHttpClient connection = new OkHttpClient();
        webClient.users = getUsers(connection);
        webClient.getUserById(connection, 10);
        webClient.getUserByName(connection,"Kamren");
        WebUser newUser = new WebUser(webClient.users.length+1,"Ivan Bobrov","Bobr","bobr@reka.wood",
                new Address("MyStreet","MySuite","MyCity","000000",
                        new Geo("11.11111","22.2222")),"666-666-666","bobr.river.wood",
                new Company("Wood LLC","Catch if you can","Make more woods"));

        webClient.createNewUser(connection,newUser);
        webClient.deleteUser(connection,newUser);


    }

    public static WebUser[] getUsers(OkHttpClient connection) throws IOException {
        Request request = new Request.Builder()
                .url(TEST_URL)
                .get()
                .build();
        Gson gson = new Gson();
        WebUser[] result = gson.fromJson(new BufferedReader(new InputStreamReader(connection.newCall(request).execute()
                .body().byteStream())).lines().collect(Collectors.joining("\n")), WebUser[].class);
        System.out.println("Get Users:\n" + connection.newCall(request).execute()+"\n******************");
        return result;
    }

    public void getUserById(OkHttpClient client, int id) throws IOException {
        String url = HttpUrl.parse(TEST_URL).newBuilder()
                .addQueryParameter("id", String.valueOf(id))
                .build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Get User By Id (id=" + id + "):\n" + response + "\n******************");
    }

    public void getUserByName (OkHttpClient client, String userName) throws IOException {
        String url = HttpUrl.parse(TEST_URL).newBuilder()
                .addQueryParameter("username", userName)
                .build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Get User By User Name (username=" + userName + "):\n" + response + "\n******************");
    }

    public void createNewUser (OkHttpClient connection, WebUser newUser) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(newUser);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        //System.out.println(gson.toJson(newUser));
        Request request = new Request.Builder()
                .url(TEST_URL)
                .post(body)
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Add New User:\n" + response + "\n******************");
    }

    public void deleteUser (OkHttpClient connection, WebUser newUser) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(newUser);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        //System.out.println(gson.toJson(newUser));
        Request request = new Request.Builder()
                .url(TEST_URL)
                .delete(body)
                .build();
        Response response = connection.newCall(request).execute();
        System.out.println("Delete User:\n" + response + "\n******************");
    }

}
