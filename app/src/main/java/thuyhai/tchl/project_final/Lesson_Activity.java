package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import thuyhai.tchl.project_final.adapter.Slide_Photo_Adapter;
import thuyhai.tchl.project_final.models.Photo_Model;

public class Lesson_Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private Slide_Photo_Adapter photoAdapter;
    private List<Photo_Model> mListPhoto;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


        Intent intent = getIntent();

        viewPager = findViewById(R.id.view_Pager);
        mListPhoto = getListPhoto();


        // autoslide
        photoAdapter = new Slide_Photo_Adapter(this, mListPhoto);
        viewPager.setAdapter(photoAdapter);
        AutoSlideImage();

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
    protected void onDestroy() {
        super.onDestroy();
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }
}