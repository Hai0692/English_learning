package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import thuyhai.tchl.project_final.adapter.Vocabulary_Adapter;
import thuyhai.tchl.project_final.models.Theme_Model;
import thuyhai.tchl.project_final.models.Vocabulary_Model;

public class List_Vocabulary_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private   Vocabulary_Adapter vocabulary_adapter;
    private List<Vocabulary_Model> vocabulary_models;
    private Context context;
    private TextView topic;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vocabulary);


        // intent
        topic = findViewById(R.id.topic);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Theme_Model modelTheme = (Theme_Model) bundle.get("object");
        topic.setText(modelTheme.getTitleTheme());




        //recycleView
        recyclerView = findViewById(R.id.recycler_Vocabulary);
        vocabulary_models = new ArrayList<>();
        vocabulary_models.add(new Vocabulary_Model("father","bố"));
        vocabulary_models.add(new Vocabulary_Model("mother","mẹ"));
        vocabulary_models.add(new Vocabulary_Model("older sister","chị gái"));
        vocabulary_models.add(new Vocabulary_Model("younger brother","em trai "));
        vocabulary_models.add(new Vocabulary_Model("grandparents","ông bà"));
        vocabulary_models.add(new Vocabulary_Model("son","Con trai"));

        vocabulary_adapter = new Vocabulary_Adapter(vocabulary_models,context);
        recyclerView.setAdapter(vocabulary_adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(List_Vocabulary_Activity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);




        // searchView
        searchView = findViewById(R.id.search_bar);
        searchView.setQueryHint("Type here to Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });








    }

}