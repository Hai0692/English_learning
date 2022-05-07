package thuyhai.tchl.project_final.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import thuyhai.tchl.project_final.fragment.Login_Tab_Fragment;
import thuyhai.tchl.project_final.fragment.Singup_Tab_Fragment;

public class Login_Adapter extends FragmentPagerAdapter {



    public Login_Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public int getCount(){
        return  2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0:
                return  new Login_Tab_Fragment();
            case 1:
                return new Singup_Tab_Fragment();

            default:
                return new Login_Tab_Fragment();

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0:
                title = "Login";break;
            case 1:
                title = "Singup";break;


        }
        return title;
    }
}
