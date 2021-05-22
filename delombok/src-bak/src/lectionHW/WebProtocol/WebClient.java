package lectionHW.WebProtocol;

import com.google.gson.*;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class WebClient {
    private static final String TEST_URL ="https://jsonplaceholder.typicode.com/users";
    private WebUser [] users;

    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient();
        OkHttpClient client = new OkHttpClient();
        webClient.users = getUsers(client);
        getUserById(webClient.users, 10);


    }

    public static WebUser[] getUsers(OkHttpClient client) throws IOException {
        Request request = new Request.Builder()
                .url(TEST_URL)
                .get()
                .build();
        Gson gson = new Gson();
        WebUser[] result = gson.fromJson(new BufferedReader(new InputStreamReader(client.newCall(request).execute()
                .body().byteStream())).lines().collect(Collectors.joining("\n")), WebUser[].class);
        return result;
    }

    public static void getUserById (WebUser[] webUser, long id) {
        for (WebUser user:webUser) {
            if (user.getId() == id){
                System.out.println(user.toString());
            }
        }
    }
}
