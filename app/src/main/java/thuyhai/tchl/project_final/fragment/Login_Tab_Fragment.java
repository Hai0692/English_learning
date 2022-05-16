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
    private EditText edtEmail,edtPass;
    private TextView tvForget;
    private Button btnLogin;
    private float v=0;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        edtEmail = root.findViewById(R.id.email);
        edtPass = root.findViewById(R.id.password);
        tvForget = root.findViewById(R.id.foget);
        btnLogin = root.findViewById(R.id.btnLogin);

        edtEmail.setTranslationX(800);
        edtPass.setTranslationX(800);
        tvForget.setTranslationX(800);
        btnLogin.setTranslationX(800);

        edtEmail.setAlpha(v);
        edtPass.setAlpha(v);
        tvForget.setAlpha(v);
        btnLogin.setAlpha(v);

        edtEmail.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        edtPass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        tvForget.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();





        return root;
    }
}