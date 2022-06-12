package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.Storage.SharedPrefManager;
import thuyhai.tchl.project_final.adapter.Question_Adapter;
import thuyhai.tchl.project_final.models.kind_response;
import thuyhai.tchl.project_final.models.question_response;
import thuyhai.tchl.project_final.models.vocabulary_response;

public class Question_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private RecyclerView rcvQuestion;
    private static List<question_response> question_models;
    private Context context;
    private Question_Adapter question_adapter;
    private ImageView imgbackHome, sendQs;
    SharedPrefManager sharedPrefManager;
    public static String token, username;
    private static EditText edtCreaterQs;
    private static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        Intent intent_qs = getIntent();

        imgbackHome = findViewById(R.id.imgbackHome);
        imgbackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back_home = new Intent(Question_Activity.this, MainActivity.class);
                intent_back_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_back_home);
            }
        });


        rcvQuestion = findViewById(R.id.recyclerQuestion);
        question_models = new ArrayList<>();

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        token = sharedPrefManager.getToken().getToken();
        username = sharedPrefManager.getUser().getName();
        id = sharedPrefManager.getUser().getID();

        getDataQuestion(token);


        edtCreaterQs = findViewById(R.id.edtCreate);
        sendQs = findViewById(R.id.sendQs);
        sendQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CreateQuestion(token);
                edtCreaterQs.setText("");

            }
        });

    }

    public void getDataQuestion(String token) {
        Call<List<question_response>> call = Retrofit_Client.getInstance().getApi().getQuestion("Bearer " + token);
        call.enqueue(new Callback<List<question_response>>() {
            @Override
            public void onResponse(Call<List<question_response>> call, Response<List<question_response>> response) {
                List<question_response> questionResponses = response.body();
                if (response.isSuccessful() && question_models != null) {
                    for (question_response post : questionResponses) {
                        question_models.add(post);
                    }
                    putDataRecycleView(question_models);
                    System.out.println(questionResponses);
                }
            }

            @Override
            public void onFailure(Call<List<question_response>> call, Throwable t) {

            }
        });


    }

    public void CreateQuestion(String token) {

        String post = edtCreaterQs.getText().toString();
        Call<List<question_response>> call = Retrofit_Client.getInstance().getApi().createQuestion("Bearer " + token, post);
        call.enqueue(new Callback<List<question_response>>() {
            @Override
            public void onResponse(Call<List<question_response>> call, Response<List<question_response>> response) {
                if (response.isSuccessful()) {
                    question_models.clear();
                    Toast.makeText(Question_Activity.this, "post question success", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<question_response>> call, Throwable t) {

            }
        });


    }

    public void deleteQuestion(String token) {
        String post = edtCreaterQs.getText().toString();
        Call<List<question_response>> call = Retrofit_Client.getInstance().getApi().deleteQuestion("Bearer " + token, id);
        call.enqueue(new Callback<List<question_response>>() {
            @Override
            public void onResponse(Call<List<question_response>> call, Response<List<question_response>> response) {
                List<question_response> questionResponses = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(Question_Activity.this, "delete success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<question_response>> call, Throwable t) {

            }
        });


    }

    public void updateQuestion(String token) {
        String post = edtCreaterQs.getText().toString();
        Call<List<question_response>> call = Retrofit_Client.getInstance().getApi().deleteQuestion("Bearer " + token, id);
        call.enqueue(new Callback<List<question_response>>() {
            @Override
            public void onResponse(Call<List<question_response>> call, Response<List<question_response>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Question_Activity.this, "update question success", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<question_response>> call, Throwable t) {

            }
        });


    }


    public void putDataRecycleView(List<question_response> question_models) {
        question_adapter = new Question_Adapter(question_models);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(rcvQuestion.getContext(), 1);
        rcvQuestion.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvQuestion.addItemDecoration(itemDecoration);
        rcvQuestion.setAdapter(question_adapter);
    }

    public void ShowPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu2);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
//               int position = 0;
//
//               if (question_models.get(position).getName() == username) {
//                   deleteQuestion(token);
//                   Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
//               }else{
//
//                   Toast.makeText(this, "delete fail", Toast.LENGTH_SHORT).show();
//               }
                deleteQuestion(token);

                return true;
            case R.id.item2:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}

//    private void GetDataQs(final String key){
//        String post = edtCreaterQs.getText().toString();
//        Call<List<question_response>> call;
//        if(post.length() >= 1){
//            call = Retrofit_Client.getInstance().getApi().createQuestion("Bearer "+token, post);
//        }else{
//            call = Retrofit_Client.getInstance().getApi().getQuestion("Bearer "+token);
//        }
//
//        call.enqueue(new Callback<List<question_response>>() {
//            @Override
//            public void onResponse(Call<List<question_response>> call, Response<List<question_response>> response) {
//                List<question_response> questionResponses = response.body();
//                if(response.isSuccessful()){
//                    question_models.clear();
//                    for (question_response post : questionResponses) {
//                        question_models.add(post);
//                    }
//                    putDataRecycleView(question_models);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<question_response>> call, Throwable t) {
//
//            }
//        });
//
//    }