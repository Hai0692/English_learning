package thuyhai.tchl.project_final.REST_API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import thuyhai.tchl.project_final.models.kind_response;
import thuyhai.tchl.project_final.models.level_response;
import thuyhai.tchl.project_final.models.login_response;
import thuyhai.tchl.project_final.models.register_response;

public interface API_interface {

    @FormUrlEncoded
    @POST("register")
    Call<register_response> register(@Field("name") String name,
                                     @Field("email") String email,
                                     @Field("phone") String phone,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<login_response> login(@Field("email") String email,
                               @Field("password") String password);
    @GET("level")
    Call<List<level_response>> level();

    @GET("level/{id}")
    Call<List<kind_response>> showLevel(@Path("id") String id);


}
