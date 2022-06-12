package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.models.kind_response;
import thuyhai.tchl.project_final.models.login_response;
import thuyhai.tchl.project_final.models.vocabulary_response;

public class Detail_Vocabulary_Activity extends AppCompatActivity {
    private TextView tvWord, tvType_word, tvPhonetic, tvDefinition;
    private ImageView imgBack;
    private ImageButton imgAudio;
    private static int value;
    private MediaPlayer mysong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vocabulary);

        //  intent
        Intent intent_detail = getIntent();
        value = intent_detail.getIntExtra("Key_1", -1);


        tvWord = findViewById(R.id.word);
        tvType_word = findViewById(R.id.type_word);
        tvPhonetic = findViewById(R.id.phonetic);
        tvDefinition = findViewById(R.id.definition);
        imgAudio = findViewById(R.id.audio);


        imgBack = findViewById(R.id.imgback_vocabulary);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(Detail_Vocabulary_Activity.this, List_Vocabulary_Activity.class);
                intent_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_back);
            }
        });

        Call<List<vocabulary_response>> call = Retrofit_Client.getInstance().getApi().detailVocabulary(value);

        call.enqueue(new Callback<List<vocabulary_response>>() {

            @Override
            public void onResponse(Call<List<vocabulary_response>> call, Response<List<vocabulary_response>> response) {

                List<vocabulary_response> vocabularyResponses = response.body();
                if (response.isSuccessful()) {

                    for (vocabulary_response post : vocabularyResponses) {
                        tvWord.setText(post.getWord());
                        tvDefinition.setText(post.getDefinition());
                        tvPhonetic.setText(post.getPhonetic());
                        tvType_word.setText(post.getType_word());
                    }


                }
            }

            @Override
            public void onFailure(Call<List<vocabulary_response>> call, Throwable t) {
                tvWord.setText("");
                tvDefinition.setText("");
                tvPhonetic.setText("");
                tvType_word.setText("");
            }
        });


}




}