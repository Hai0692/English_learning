package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thuyhai.tchl.project_final.List_Vocabulary_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.kind_response;

public class Kind_Adapter extends RecyclerView.Adapter<Kind_Adapter.KindViewHolder> {


    private List<kind_response> kind_models;
    private Context mContext;

    public Kind_Adapter(List<kind_response> kind_models) {
        this.kind_models = kind_models;
    }

    @NonNull
    @Override
    public KindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kind_list_item, parent, false);

        return new KindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KindViewHolder holder, int position) {

       final   String name_kind = kind_models.get(position).getKind_name();
        holder.tvKind.setText(name_kind);

        final  int kind_id = kind_models.get(position).getId();
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vocabulary = new Intent(v.getContext(), List_Vocabulary_Activity.class);
                intent_vocabulary.putExtra("Key_2", name_kind);
                intent_vocabulary.putExtra("Key_3",kind_id);
                v.getContext().startActivity(intent_vocabulary);


            }
        });


    }

    @Override
    public int getItemCount() {
        return kind_models.size();
    }

    public class KindViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout_item;
        private TextView tvKind;
        public KindViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKind = itemView.findViewById(R.id.txtKind);
            layout_item = itemView.findViewById(R.id.kind_item);

        }

    }



}
