package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import thuyhai.tchl.project_final.models.Theme_Model;
import thuyhai.tchl.project_final.models.Vocabulary_Model;

public class Detail_Vocabulary_Activity extends AppCompatActivity {
    private TextView word;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vocabulary);

        //intent
        word = findViewById(R.id.word);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Vocabulary_Model vocabulary_model = (Vocabulary_Model) bundle.get("detail");
        word.setText(vocabulary_model.getVocabulary());

    }
}