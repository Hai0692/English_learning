package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thuyhai.tchl.project_final.Kind_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.level_response;

public class Level_Adapter extends RecyclerView.Adapter<Level_Adapter.Level_View_Holder> {
    private List<level_response> level_models;
    private Context mContext;


    public Level_Adapter(List<level_response> level_models) {
        this.level_models = level_models;
    }

    @NonNull
    @Override
    public Level_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_list_item, parent, false);

        return new Level_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Level_View_Holder holder, int position) {


            String Name_level = level_models.get(position).getLevel();
            holder.setDataLevel(Name_level);
            holder.card_level.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_level = new Intent(v.getContext(), Kind_Activity.class);
                    intent_level.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent_level);
                }
            });

    }

    @Override
    public int getItemCount() {
        return level_models.size();
    }

    public class Level_View_Holder extends RecyclerView.ViewHolder {

        private CardView card_level;
        private TextView name_level;
        public Level_View_Holder(@NonNull View itemView) {
            super(itemView);
            name_level = itemView.findViewById(R.id.name_level);
            card_level = itemView.findViewById(R.id.cardlevel);

        }
        public void setDataLevel(String Name_level){
            name_level.setText(Name_level);
        }
    }



}
