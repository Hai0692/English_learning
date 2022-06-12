package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.adapter.Kind_Adapter;
import thuyhai.tchl.project_final.models.kind_response;

public class Kind_Activity extends AppCompatActivity {
    private static RecyclerView rcvKind;
    private static List<kind_response> kind_name;
    private static Kind_Adapter kind_adapter;
    private Context context;
    private static TextView txtlevel;
    private ImageView imgback_home;
    private static String value1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);


        imgback_home = findViewById(R.id.imgback_home);
        imgback_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back_home = new Intent(Kind_Activity.this, MainActivity.class );
                intent_back_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_back_home);
            }
        });


        txtlevel = findViewById(R.id.txtlevel);
        Intent intent_level = getIntent();
        value1 = intent_level.getStringExtra("Key_1");
        txtlevel.setText(value1);


        rcvKind = findViewById(R.id.recyclerKind);
        kind_name = new ArrayList<>();


        GetDataKind();
    }

    public static void GetDataKind(){

        Call<List<kind_response>> call = Retrofit_Client.getInstance().getApi().showLevel(value1);
        call.enqueue(new Callback<List<kind_response>>() {
            @Override
            public void onResponse(Call<List<kind_response>> call, Response<List<kind_response>> response) {
                List<kind_response>  kindResponses = response.body();
                if(response.isSuccessful() && kindResponses != null){
                    for(kind_response post : kindResponses) {
                        kind_name.add(post);
                    }
                    PutDataInRecyclerView(kind_name);

                }

            }

            @Override
            public void onFailure(Call<List<kind_response>> call, Throwable t) {

            }
        });

    }
    private static void PutDataInRecyclerView(List<kind_response> kind_name) {
        kind_adapter = new Kind_Adapter(kind_name);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(rcvKind.getContext(), 2);
       rcvKind.setLayoutManager(gridLayoutManager);
        rcvKind.setAdapter(kind_adapter);

    }
}