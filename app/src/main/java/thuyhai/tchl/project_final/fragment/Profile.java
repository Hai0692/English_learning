package thuyhai.tchl.project_final.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.Storage.SharedPrefManager;

public class Profile extends Fragment {
    public TextView pass_change, name_change, email_change, phone_change;
    SharedPrefManager sharedPrefManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_profile, container, false);


        pass_change = root.findViewById(R.id.password);
        name_change = root.findViewById(R.id.name);
        phone_change = root.findViewById(R.id.phone);
        email_change = root.findViewById(R.id.email);

        sharedPrefManager = new SharedPrefManager(getActivity());

        String username = sharedPrefManager.getUser().getName();
        name_change.setText(username);

        String email = sharedPrefManager.getUser().getEmail();
        email_change.setText(email);

        String phone = sharedPrefManager.getUser().getPhone();
        phone_change.setText(phone);

        return root;
    }
}