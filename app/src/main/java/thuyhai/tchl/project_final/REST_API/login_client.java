package thuyhai.tchl.project_final.REST_API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login_client {

    private static String BASE_URL = "http://192.168.1.121/App-E/public/api/";
    private static login_client retrofitClient;
    private static Retrofit retrofit;
    private OkHttpClient.Builder builder = new OkHttpClient.Builder();
    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    private login_client() {

        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public static synchronized login_client getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new login_client();
        }
        return retrofitClient;
    }

    public API_interface getApi() {
        return retrofit.create(API_interface.class);
    }





}
