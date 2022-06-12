package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.content.Intent;
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
import thuyhai.tchl.project_final.models.vocabulary_response;

public class Vocabulary_Adapter extends RecyclerView.Adapter<Vocabulary_Adapter.Vocabulary_ViewHolder> {
    private List<vocabulary_response> vocabulary_models;
    private Context context;

    public Vocabulary_Adapter(List<vocabulary_response> vocabulary_models) {
        this.vocabulary_models = vocabulary_models;
    }

    @NonNull
    @Override
    public Vocabulary_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vocabulary_list_item,parent,false);
        return new Vocabulary_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vocabulary_ViewHolder holder, int position) {

         String word = vocabulary_models.get(position).getWord();
         holder.tv_Vocabulary.setText(word);
        final int id = vocabulary_models.get(position).getId();


        //intent
        holder.detail_vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_detail = new Intent(v.getContext(), Detail_Vocabulary_Activity.class);
                intent_detail.putExtra("Key_1", id);
                v.getContext().startActivity(intent_detail);

            }
        });

    }


    @Override
    public int getItemCount() {
        return vocabulary_models.size();
    }

    public class Vocabulary_ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_Vocabulary;
        private RelativeLayout detail_vocabulary;
        public Vocabulary_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Vocabulary= itemView.findViewById(R.id.tv_vocabulary);
            detail_vocabulary = itemView.findViewById(R.id.detail_vocabulary);

        }
    }
}
