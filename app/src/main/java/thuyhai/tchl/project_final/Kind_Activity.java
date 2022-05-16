package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import thuyhai.tchl.project_final.adapter.Kind_Adapter;
import thuyhai.tchl.project_final.fragment.Home;
import thuyhai.tchl.project_final.models.Kind_Model;

public class Kind_Activity extends AppCompatActivity {
    private RecyclerView rcvKind;
    private List<Kind_Model> kind_models;
    private Kind_Adapter kind_adapter;
    private Context context;
    private ImageView imgback_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);

        rcvKind = findViewById(R.id.recyclerKind);

        kind_models = new ArrayList<>();

        kind_models.add(new Kind_Model(R.drawable.theme1,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme2,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme3,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme4,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme5,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme6,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme7,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme8,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme9,"Family"));
        kind_models.add(new Kind_Model(R.drawable.theme10,"Family"));
        kind_adapter = new Kind_Adapter(kind_models, context);
        rcvKind.setAdapter(kind_adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        rcvKind.setLayoutManager(gridLayoutManager);




    }
}