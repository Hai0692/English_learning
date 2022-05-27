package thuyhai.tchl.project_final.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thuyhai.tchl.project_final.MainActivity;
import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.REST_API.Retrofit_Client;
import thuyhai.tchl.project_final.Storage.SharedPrefManager;
import thuyhai.tchl.project_final.models.login_response;


public class Login_Tab_Fragment extends Fragment {
    private EditText edtEmail,edtPass;
    private TextView tvForget;
    private Button btnLogin;
    private float v=0;
    SharedPrefManager sharedPrefManager;




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


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });
          sharedPrefManager = new SharedPrefManager(getContext());
        return root;


    }


        public void loginUser() {
             String email = edtEmail.getText().toString().trim();
            String password = edtPass.getText().toString().trim();

            if (email.isEmpty()){
                edtEmail.requestFocus();
                edtEmail.setError("Please Enter Email");
                return;
            }

            if (password.isEmpty()||password.length()<6) {
                edtPass.requestFocus();
                edtPass.setError("Please re-Enter Password");
                return;
            }

            Call<login_response> call =  Retrofit_Client.getInstance().getApi().login(email,password);
            call.enqueue(new Callback<login_response>() {
                @Override
                public void onResponse(Call<login_response> call, Response<login_response> response) {
                    if(response.isSuccessful()) {
                        login_response loginResponse = response.body();
                        if (loginResponse.getMessage().equals("true") ) {
                            if(sharedPrefManager != null) {

                                sharedPrefManager.SaveUser(loginResponse.getUser());
                                Toast.makeText(getActivity(), "login success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }

                        } else {
                            Toast.makeText(getActivity(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                @Override
                public void onFailure(retrofit2.Call<login_response> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    @Override
    public void onStart() {
        super.onStart();
        if(sharedPrefManager != null && sharedPrefManager.isLoggedIn() ){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }

        }


