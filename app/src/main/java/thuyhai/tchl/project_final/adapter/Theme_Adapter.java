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

import java.io.Serializable;
import java.util.List;

import thuyhai.tchl.project_final.List_Vocabulary_Activity;
import thuyhai.tchl.project_final.Question_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.Theme_Model;

public class Theme_Adapter extends RecyclerView.Adapter<Theme_Adapter.ThemeViewHolder> {
    private List<Theme_Model> mTheme;
    private Context mContext;

    public Theme_Adapter(List<Theme_Model> mTheme, Context mContext) {
        this.mTheme = mTheme;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theme, parent, false);

        return  new ThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeViewHolder holder, int position) {

        final  Theme_Model modelTheme = mTheme.get(position);
        holder.txtTheme.setText(modelTheme.getTitleTheme());
        holder.imgTheme.setImageResource(modelTheme.getImageTheme());



        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vocabulary = new Intent(v.getContext(), List_Vocabulary_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", modelTheme);
                intent_vocabulary.putExtras(bundle);
                v.getContext().startActivity(intent_vocabulary);

            }
        });

  }


    @Override
    public int getItemCount() {
        return mTheme.size();
    }

    public class ThemeViewHolder  extends RecyclerView.ViewHolder{
        private LinearLayout layout_item;
        private ImageView imgTheme;
        private TextView txtTheme;
        public ThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTheme = itemView.findViewById(R.id.imgTheme);
            txtTheme = itemView.findViewById(R.id.txtTheme);
            layout_item = itemView.findViewById(R.id.layout_item);
        }
    }
}
