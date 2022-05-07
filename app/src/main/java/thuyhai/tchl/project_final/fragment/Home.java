package thuyhai.tchl.project_final.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import thuyhai.tchl.project_final.Question_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.adapter.Question_Adapter;
import thuyhai.tchl.project_final.adapter.Theme_Adapter;
import thuyhai.tchl.project_final.models.Theme_Model;


public class Home extends Fragment  {

    private RecyclerView rcvTheme;
    private List<Theme_Model> modelThemes;
    private Theme_Adapter adapter;
    private Context mContext;
    private  View mView;
    private LinearLayout linearLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  mView= inflater.inflate(R.layout.home, container, false);



        rcvTheme= mView.findViewById(R.id.recyclerTheme);
        modelThemes = new ArrayList<>();
        modelThemes.add(new Theme_Model(R.drawable.theme1,"Family"));
        modelThemes.add(new Theme_Model(R.drawable.theme2," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme3," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme4," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme5," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme6," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme7," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme8," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme9," Giao tiếp"));
        modelThemes.add(new Theme_Model(R.drawable.theme10," Giao tiếp"));

        adapter = new Theme_Adapter(modelThemes, mContext);
        rcvTheme.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        rcvTheme.setLayoutManager(gridLayoutManager);


        linearLayout = mView.findViewById(R.id.linear_question);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Question_Activity.class);
                startActivity(intent);


            }
        });




        return  mView;


    }




}
