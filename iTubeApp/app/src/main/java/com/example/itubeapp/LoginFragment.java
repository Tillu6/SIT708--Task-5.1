package com.example.itubeapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        EditText etUser = v.findViewById(R.id.edt_username);
        EditText etPass = v.findViewById(R.id.edt_password);
        Button bLogin = v.findViewById(R.id.btn_login);
        Button bSignup = v.findViewById(R.id.btn_signup);

        bLogin.setOnClickListener( __ -> {
            if (!etUser.getText().toString().trim().isEmpty()
                    && !etPass.getText().toString().trim().isEmpty()) {
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new HomeFragment())
                        .commit();
            } else {
                // you could show a Toast here
            }
        });

        bSignup.setOnClickListener( __ ->
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new SignupFragment())
                        .addToBackStack(null)
                        .commit()
        );

        return v;
    }
}
