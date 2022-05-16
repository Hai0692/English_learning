package thuyhai.tchl.project_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import thuyhai.tchl.project_final.adapter.Login_Adapter;

public class Login_Activity extends AppCompatActivity {

     TabLayout tabLayout;
     ViewPager viewPager;
     Login_Adapter adapter;
     FloatingActionButton fb, gg,gm;
    private float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent2 = getIntent();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_facebook);
        gg = findViewById(R.id.fab_google);
        gm = findViewById(R.id.fab_gmail);



        tabLayout.addTab(tabLayout.newTab().setText("LogIn"));
        tabLayout.addTab(tabLayout.newTab().setText("SingUp"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        adapter = new Login_Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        fb.setTranslationY(300);
        gg.setTranslationY(300);
        gm.setTranslationY(300);
        tabLayout.setTranslationY(300);


        fb.setAlpha(v);
        gg.setAlpha(v);
        gm.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        gg.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        gm.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }
}