package lectionHW.WebProtocol;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClient {
    @GET("users")
    @Headers("Content-Type: application/json")
    Call<List<WebUser>> getUsers ();

    @GET("users/{id}")
    @Headers("Content-Type: application/json")
    Call<WebUser> getUserById(@Path("id") int id);

    @GET("users")
    @Headers("Content-Type: application/json")
    Call<List<WebUser>> getUserByName(@Query("username") String username);

    @POST("users")
    Call<WebUser> createUser(@Body WebUser newUser);

    @FormUrlEncoded
    @PUT("users/{id}")
    Call<WebUser> updateUserInfo (@Path("id") int id,
                                  @Field("phone") String newPhone);

    @DELETE("users/{id}")
    Call<WebUser> delUser(@Path("id") int id);
}
