package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import thuyhai.tchl.project_final.adapter.Question_Adapter;
import thuyhai.tchl.project_final.models.Question_Model;

public class Question_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private RecyclerView recyclerView;
    private List<Question_Model> question_models;
    private Context context;
    private Question_Adapter question_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();

        recyclerView = findViewById(R.id.recyclerQuestion);
        question_models = new ArrayList<>();
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_models.add(new Question_Model("What your name","Thuy Hai", R.drawable.avatar));
        question_adapter = new Question_Adapter(question_models, context);
        recyclerView.setAdapter(question_adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Question_Activity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        //


    }
    public void  ShowPopup(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu2);
        popupMenu.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
       switch (item.getItemId()){
           case R.id.item1 :
               Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
               return true;
           case R.id.item2 :
               Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
               return true;
           case R.id.item3 :
               Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show();
               return true;
           default:return  false;
       }
    }
}