package thuyhai.tchl.project_final.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.Question_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.adapter.Level_Adapter;
import thuyhai.tchl.project_final.adapter.Slide_Photo_Adapter;
import thuyhai.tchl.project_final.models.Photo_Model;
import thuyhai.tchl.project_final.models.level_response;
import thuyhai.tchl.project_final.models.register_response;

public class Home extends Fragment  {

    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private Slide_Photo_Adapter photoAdapter;
    private List<Photo_Model> mListPhoto;
    private Timer mTimer;

    private Context context;
    private static RecyclerView rcvlevel;
    private  static  List<level_response> level;
    private static Level_Adapter level_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  mView= inflater.inflate(R.layout.home, container, false);
        linearLayout = mView.findViewById(R.id.linear_question);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Question_Activity.class);
                startActivity(intent);
            }
        });

        // autoslide
        viewPager = mView.findViewById(R.id.view_Pager);
        mListPhoto = getListPhoto();
        photoAdapter = new Slide_Photo_Adapter(getContext(), mListPhoto);
        viewPager.setAdapter(photoAdapter);
        AutoSlideImage();

        // getLevel

        rcvlevel = mView.findViewById(R.id.rcvLevel);
        level  = new ArrayList<>();
        getDataLevel();


        return  mView;
    }
    private List<Photo_Model> getListPhoto(){
        List<Photo_Model> list = new ArrayList<>();
        list.add(new Photo_Model((R.drawable.slide1)));
        list.add(new Photo_Model((R.drawable.slide2)));
        list.add(new Photo_Model((R.drawable.slide3)));
        list.add(new Photo_Model((R.drawable.slide4)));
        return list;
    }
    private void AutoSlideImage(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager ==null){
            return;
        }
        if(mTimer ==null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size()-1;
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });

            }
        }, 300, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }

    public static void getDataLevel(){
//        level_models = new ArrayList<>();
//        level_models.add(new level_response("Basic \nLevel"));
//        level_models.add(new level_response("Average \n Level"));
//        level_models.add(new level_response("Basic \n Level"));
//
//        level_adapter = new Level_Adapter(level_models, rcvlevel.getContext());
//        rcvlevel.setAdapter(level_adapter);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(rcvlevel.getContext(), 3);
//        rcvlevel.setLayoutManager(gridLayoutManager);


        Call <List<level_response>> call = Retrofit_Client.getInstance().getApi().level();
        call.enqueue(new Callback<List<level_response>>() {
            @Override
            public void onResponse(Call<List<level_response>> call, Response<List<level_response>> response) {
                List<level_response> levelResponses = response.body();
                if(levelResponses != null){
                    for(level_response post : levelResponses){
                        level.add(post);
                    }
                    PutDataInRecyclerView(level);

                }

            }

            @Override
            public void onFailure(Call<List<level_response>> call, Throwable t) {

            }
        });
    }
    private static void PutDataInRecyclerView(List<level_response> level) {
        level_adapter = new Level_Adapter(level);

        LinearLayoutManager llm = new LinearLayoutManager(rcvlevel.getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcvlevel.setLayoutManager(llm);
        rcvlevel.setAdapter(level_adapter);


    }

}
