package com.example.itubeapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupFragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        EditText etName = v.findViewById(R.id.edt_fullname);
        EditText etUser = v.findViewById(R.id.edt_new_username);
        EditText etPass = v.findViewById(R.id.edt_new_password);
        EditText etConf = v.findViewById(R.id.edt_confirm_password);
        Button bCreate = v.findViewById(R.id.btn_create);

        bCreate.setOnClickListener(__ -> {
            String name = etName.getText().toString().trim();
            String user = etUser.getText().toString().trim();
            String pass = etPass.getText().toString();
            String conf = etConf.getText().toString();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(user)
                    || TextUtils.isEmpty(pass) || !pass.equals(conf)) {
                Toast.makeText(requireContext(),
                        "Please fill all and match passwords", Toast.LENGTH_SHORT).show();
                return;
            }
            // TODO: actually save user if you like...
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return v;
    }
}
