package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.adapter.Vocabulary_Adapter;
import thuyhai.tchl.project_final.models.vocabulary_response;

public class List_Vocabulary_Activity extends AppCompatActivity {
    private static RecyclerView rcvVocabulary;
    private static Vocabulary_Adapter vocabulary_adapter;
    private  static List<vocabulary_response> vocabulary_models;
    private Context context;
    private TextView topic;
    private  static SearchView searchView;
    private ImageView imgBack;
    private static int value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vocabulary);



        topic = findViewById(R.id.topic);
        Intent intent_vocabulary = getIntent();

        topic.setText(intent_vocabulary.getStringExtra("Key_2"));

        value = intent_vocabulary.getIntExtra("Key_3", -1);




        imgBack = findViewById(R.id.imgback_kind);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(List_Vocabulary_Activity.this, Kind_Activity.class );
                intent_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_back);
            }
        });


        rcvVocabulary = findViewById(R.id.recycler_Vocabulary);
       vocabulary_models = new ArrayList<>();

        GetDataVocabulary("");



        // searchView
        searchView = findViewById(R.id.search_bar);
        searchView.setQueryHint("Type here to Search");
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                GetDataVocabulary(query);
                System.out.println(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }

    private static void GetDataVocabulary(final String key){
        Call<List<vocabulary_response>> call;
        if(key.length() >= 1){
            call = Retrofit_Client.getInstance().getApi().getSearchVocabulary(key);
        }else{
            call = Retrofit_Client.getInstance().getApi().showVocabulary(value);
        }

        call.enqueue(new Callback<List<vocabulary_response>>() {
            @Override
            public void onResponse(Call<List<vocabulary_response>> call, Response<List<vocabulary_response>> response) {
                List<vocabulary_response> vocabularyResponses = response.body();
                if(response.isSuccessful()){
                   vocabulary_models.clear();
                    for(vocabulary_response post : vocabularyResponses){
                        vocabulary_models.add(post);
                    }
                    PutDataInRecyclerView(vocabulary_models);
                }
            }

            @Override
            public void onFailure(Call<List<vocabulary_response>> call, Throwable t) {

            }
        });

    }


    private static void PutDataInRecyclerView(List<vocabulary_response> vocabulary_models) {
        vocabulary_adapter = new Vocabulary_Adapter(vocabulary_models);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(rcvVocabulary.getContext(), 1);
        rcvVocabulary.setLayoutManager(gridLayoutManager);
        rcvVocabulary.setAdapter(vocabulary_adapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(rcvVocabulary.getContext(), DividerItemDecoration.VERTICAL);
        rcvVocabulary.addItemDecoration(itemDecoration);
    }


}