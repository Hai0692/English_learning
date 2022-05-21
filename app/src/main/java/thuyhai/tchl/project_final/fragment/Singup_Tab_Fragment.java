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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.REST_API.RegisterClient;
import thuyhai.tchl.project_final.models.register_response;

public class Singup_Tab_Fragment extends Fragment {

    Button btnRegister;
    EditText edtEmail, edtPhone, edtName, edtPass;
    TextView tvResult;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.singup_tab_fragment, container, false);



        btnRegister = root.findViewById(R.id.btnSingUp);
        edtEmail = root.findViewById(R.id.email);
        edtPass = root.findViewById(R.id.password);
        edtName = root.findViewById(R.id.user_name);
        edtPhone = root.findViewById(R.id.phone);
        tvResult = root.findViewById(R.id.txtSuccess);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        return root;
    }
    private void registerUser() {

        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String password = edtPass.getText().toString().trim();

        if (name.isEmpty()){
            edtName.requestFocus();
            edtName.setError("Please Enter Name");
            return;
        }
        if (email.isEmpty()){
            edtEmail.requestFocus();
            edtEmail.setError("Please Enter Email");
            return;
        }

        if (phone.isEmpty()|| phone.length() != 10){
            edtPhone.requestFocus();
            edtPhone.setError("Please re-enter your phone number");
            return;
        }
        if (password.isEmpty()||password.length()<6){
            edtPass.requestFocus();
            edtPass.setError("Please re-Enter Password");
            return;

        }

        Call<register_response> call = RegisterClient.getInstance().getApi().register(name,email,phone,password);
        call.enqueue(new Callback<register_response>() {
            @Override
            public void onResponse(Call<register_response> call, Response<register_response> response) {

                if(response.isSuccessful()){

                    edtName.setText("");
                    edtEmail.setText("");
                    edtPhone.setText("");
                    edtPass.setText("");
                    tvResult.setText("register success");
                    tvResult.setVisibility(View.VISIBLE);



                }
                else {
                    tvResult.setText("This account already exists");
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
            @Override

            public void onFailure(Call<register_response> call, Throwable t) {

            }
        });
    }
}
