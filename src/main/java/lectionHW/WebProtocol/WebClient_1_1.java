package lectionHW.WebProtocol;

import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static lectionHW.WebProtocol.RetrofitConfig.*;

public class WebClient_1_1{

    static String urlPath = "https://jsonplaceholder.typicode.com/";


    public static void main(String[] args) throws IOException {
        RetrofitClient client = createClient(urlPath, GsonConverterFactory.create(), RetrofitClient.class);
        List<WebUser> users = execute(client.getUsers());
        WebUser userById = execute(client.getUserById(5));
        List<WebUser> userByName = execute(client.getUserByName("Antonette"));
        WebUser newUser = new WebUser(/*webClient.users.length+1,*/"Ivan Bobrov","Bobr","bobr@reka.wood",
                new Address("MyStreet","MySuite","MyCity","000000",
                        new Geo("11.11111","22.2222")),"666-666-666","bobr.river.wood",
                new Company("Wood LLC","Catch if you can","Make more woods"));
        WebUser user = execute(client.createUser(newUser));
        WebUser updateUser = execute(client.updateUserInfo(3, "666-666-666"));
        WebUser delUser = execute(client.delUser(2));
    }
}
