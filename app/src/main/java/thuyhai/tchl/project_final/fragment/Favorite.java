package thuyhai.tchl.project_final.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import thuyhai.tchl.project_final.Lesson_Activity;
import thuyhai.tchl.project_final.R;

public class Favorite extends Fragment {
    private ImageView imgCup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.favorite, container, false);
        imgCup = root.findViewById(R.id.imgCup);
        imgCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Lesson_Activity.class);
                startActivity(intent);


            }
        });


        return root;
    }
}
