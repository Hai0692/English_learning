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

    private EditText edtEmail,edtPass,edtPhone,edtUsername;
    private Button btnSingUp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.singup_tab_fragment, container, false);




        return root;
    }
}
