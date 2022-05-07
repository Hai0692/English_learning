package thuyhai.tchl.project_final.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import thuyhai.tchl.project_final.Lesson_Activity;
import thuyhai.tchl.project_final.Question_Activity;
import thuyhai.tchl.project_final.R;

public class History extends Fragment {
    private CardView card1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.history, container, false);
        return  view;
    }
}
