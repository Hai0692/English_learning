package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thuyhai.tchl.project_final.List_Vocabulary_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.Kind_Model;

public class Kind_Adapter extends RecyclerView.Adapter<Kind_Adapter.KindViewHolder> {


    private List<Kind_Model> kind_models;
    private Context mContext;

    public Kind_Adapter(List<Kind_Model> kind_models, Context mContext) {
        this.kind_models = kind_models;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public KindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kind_list_item, parent, false);

        return new KindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KindViewHolder holder, int position) {

        final Kind_Model kind_model = kind_models.get(position);
        holder.tvKind.setText(kind_model.getTitleKind());
        holder.imgKind.setImageResource(kind_model.getImgKind());


        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vocabulary = new Intent(v.getContext(), List_Vocabulary_Activity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("object", kind_model);
                intent_vocabulary.putExtras(bundle1);
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
        private ImageView imgKind;
        private TextView tvKind;
        public KindViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKind = itemView.findViewById(R.id.imgKind);
            tvKind = itemView.findViewById(R.id.txtKind);
            layout_item = itemView.findViewById(R.id.kind_item);

        }

//        public void setDataKind(String name_kind){
//            tvKind.setText(name_kind);
//        }
    }



}
