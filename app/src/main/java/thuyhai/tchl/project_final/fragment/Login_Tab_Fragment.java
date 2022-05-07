package thuyhai.tchl.project_final.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import thuyhai.tchl.project_final.R;


public class Login_Tab_Fragment extends Fragment {
    private EditText email,pass;
    private TextView foget;
    private Button login;
    private float v=0;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.password);
        foget = root.findViewById(R.id.foget);
        login = root.findViewById(R.id.btnLogin);
//
//        Typeface roboto = Typeface.createFromAsset(mContext.getAssets(), "font/Roboto-Bold.ttf");
//        email.setTypeface(roboto);
//        pass.setTypeface(roboto);
//        foget.setTypeface(roboto);
//        login.setTypeface(roboto);
//


        email.setTranslationX(800);
        pass.setTranslationX(800);
        foget.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        foget.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        foget.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();



        return root;
    }
}