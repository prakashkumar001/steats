package street.com.eats.interfaces;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import street.com.eats.pojo.request.LoginRequest;
import street.com.eats.pojo.request.SignUpRequest;
import street.com.eats.pojo.request.response.LoginResponse;

public interface APIInterface {


    @POST("/api/login.php")
    public Call<LoginResponse> doLogin(@Body LoginRequest loginRequest);


    @POST("/api/signup.php")
    public Call<LoginResponse> doSignUp(@Body SignUpRequest signUpRequest);

    @POST("/api/users")
    Call<String> createUser(@Body String user);

    @GET("/api/users?")
    Call<String> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<String> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
