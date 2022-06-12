package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.question_response;

public class Question_Adapter extends RecyclerView.Adapter<Question_Adapter.Question_ViewHolder> {
    private List<question_response> question_models;
    private Context context;


    public Question_Adapter(List<question_response> question_models) {
        this.question_models = question_models;
    }

    @NonNull
    @Override
    public Question_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item, parent, false);

        return new Question_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Question_ViewHolder holder, int position) {

        final String  name_qs = question_models.get(position).getName();
        holder.tv_Name.setText(name_qs);

        final   String body_qs = question_models.get(position).getBody();
        holder.tv_Question.setText(body_qs);


    }

    @Override
    public int getItemCount() {
        return question_models.size();
    }

    public class Question_ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_Name, tv_Question;
        public Question_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Name = itemView.findViewById(R.id.tv_name);
            tv_Question = itemView.findViewById(R.id.tv_question);
        }
    }
}
