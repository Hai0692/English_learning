package thuyhai.tchl.project_final.fragment;

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

public class Singup_Tab_Fragment extends Fragment {

    private EditText email,pass,re_pass,user_name;
    private Button singup;
    private float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.singup_tab_fragment, container, false);
//
//        email = root.findViewById(R.id.email);
//        pass = root.findViewById(R.id.password);
//        re_pass = root.findViewById(R.id.re_password);
//        user_name = root.findViewById(R.id.user_name);
//        singup = root.findViewById(R.id.btnSingUp);
//
//        email.setTranslationX(800);
//        pass.setTranslationX(800);
//        re_pass.setTranslationX(800);
//        user_name.setTranslationX(800);
//        singup.setTranslationX(800);
//
//        email.setAlpha(v);
//        pass.setAlpha(v);
//        re_pass.setAlpha(v);
//        user_name.setAlpha(v);
//        singup.setAlpha(v);
//
//        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
//        pass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
//        re_pass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
//        user_name.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();
//        singup.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();
//



        return root;
    }
}
