package thuyhai.tchl.project_final.REST_API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterClient {
    private static String BASE_URL = "http://192.168.0.106/App-E/public/api/";
    private static RegisterClient retrofitClient;
    private static Retrofit retrofit;
    private OkHttpClient.Builder builder = new OkHttpClient.Builder();
    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    private RegisterClient() {

        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public static synchronized RegisterClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RegisterClient();
        }
        return retrofitClient;
    }

    public API_interface getApi() {
        return retrofit.create(API_interface.class);
    }


}
