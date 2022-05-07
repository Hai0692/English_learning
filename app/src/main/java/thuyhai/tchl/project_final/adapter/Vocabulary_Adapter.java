package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thuyhai.tchl.project_final.Detail_Vocabulary_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.Vocabulary_Model;

public class Vocabulary_Adapter extends RecyclerView.Adapter<Vocabulary_Adapter.Vocabulary_ViewHolder> {
    private List<Vocabulary_Model> vocabulary_models;
    private Context context;


    public Vocabulary_Adapter(List<Vocabulary_Model> vocabulary_models, Context context) {
        this.vocabulary_models = vocabulary_models;
        this.context = context;
    }


    @NonNull
    @Override
    public Vocabulary_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vocabulary_list_item,parent,false);
        return new Vocabulary_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vocabulary_ViewHolder holder, int position) {

        final Vocabulary_Model vocabulary_model = vocabulary_models.get(position);
        holder.tv_Meaning.setText(vocabulary_model.getMeaning());
        holder.tv_Vocabulary.setText(vocabulary_model.getVocabulary());



        //intent
        holder.detail_vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_detail = new Intent(v.getContext(), Detail_Vocabulary_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("detail", vocabulary_model);
                intent_detail.putExtras(bundle);
                v.getContext().startActivity(intent_detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vocabulary_models.size();
    }

    public class Vocabulary_ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_Vocabulary, tv_Meaning;
        private RelativeLayout detail_vocabulary;
        public Vocabulary_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Vocabulary= itemView.findViewById(R.id.tv_vocabulary);
            tv_Meaning= itemView.findViewById(R.id.tv_meaning);
            detail_vocabulary = itemView.findViewById(R.id.detail_vocabulary);

        }
    }
}
