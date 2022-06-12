package thuyhai.tchl.project_final.REST_API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import thuyhai.tchl.project_final.models.kind_response;
import thuyhai.tchl.project_final.models.level_response;
import thuyhai.tchl.project_final.models.login_response;
import thuyhai.tchl.project_final.models.question_response;
import thuyhai.tchl.project_final.models.register_response;
import thuyhai.tchl.project_final.models.vocabulary_response;

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

    @GET("level/{level}")
    Call<List<kind_response>> showLevel(@Path("level") String level);

    @GET("kind/{kind_id}")
    Call<List<vocabulary_response>> showVocabulary(@Path("kind_id") int kind_id);

    @GET("kind/detail/{id}")
    Call<List<vocabulary_response>> detailVocabulary(@Path("id") int id);

    @GET("search")
    Call<List<vocabulary_response>> getSearchVocabulary(@Query("data") String data );


    @GET("question")
    Call<List<question_response>> getQuestion(@Header("Authorization") String token);

    @GET("question/{IdQuestion}")
    Call<List<question_response>> showQuestion(@Header("Authorization") String token, @Path("id") int id);

    @FormUrlEncoded
    @POST("question/create")
    Call<List<question_response>> createQuestion(@Header("Authorization") String token,
                                                 @Field("body") String body);

    @DELETE("question/{id}")
    Call<List<question_response>> deleteQuestion(@Header("Authorization") String token,@Path("id") int id);

    @PUT("question/{id}")
    Call<List<question_response>> updateQuestion(@Header("Authorization") String token,@Path("id") int id);

}
