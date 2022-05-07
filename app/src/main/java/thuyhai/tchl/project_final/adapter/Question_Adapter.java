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
import thuyhai.tchl.project_final.models.Question_Model;

public class Question_Adapter extends RecyclerView.Adapter<Question_Adapter.Question_ViewHolder> {
    private List<Question_Model> question_models;
    private Context context;

    public Question_Adapter(List<Question_Model> question_models, Context context) {
        this.question_models = question_models;
        this.context = context;
    }

    @NonNull
    @Override
    public Question_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item, parent, false);

        return new Question_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Question_ViewHolder holder, int position) {
        Question_Model question_model =  question_models.get(position);
        holder.tv_Name.setText(question_model.getNameModel());
        holder.tv_Question.setText(question_model.getQuestionModel());
        holder.imgAvatar.setImageResource(question_model.getImageModel());

    }

    @Override
    public int getItemCount() {
        return question_models.size();
    }

    public class Question_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tv_Name, tv_Question;
        public Question_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avt);
            tv_Name = itemView.findViewById(R.id.tv_name);
            tv_Question = itemView.findViewById(R.id.tv_question);
        }
    }
}
