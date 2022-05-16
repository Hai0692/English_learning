package thuyhai.tchl.project_final.fragment;

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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import thuyhai.tchl.project_final.Kind_Activity;
import thuyhai.tchl.project_final.Question_Activity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.adapter.Slide_Photo_Adapter;
import thuyhai.tchl.project_final.models.Photo_Model;

public class Home extends Fragment  {

    private LinearLayout linearLayout;
    private CardView level1;



    private ViewPager viewPager;
    private Slide_Photo_Adapter photoAdapter;
    private List<Photo_Model> mListPhoto;
    private Timer mTimer;

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
        level1 = mView.findViewById(R.id.Level1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), Kind_Activity.class);
                startActivity(intent1);
            }
        });



        // autoslide
        viewPager = mView.findViewById(R.id.view_Pager);
        mListPhoto = getListPhoto();
        photoAdapter = new Slide_Photo_Adapter(getContext(), mListPhoto);
        viewPager.setAdapter(photoAdapter);
        AutoSlideImage();



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




}
