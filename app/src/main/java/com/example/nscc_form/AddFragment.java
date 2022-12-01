package com.example.nscc_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.nscc_form.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {
    FragmentAddBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText firstname = binding.firstname;
        final EditText lastname = binding.lastname;
        final EditText phone = binding.phone;
        final EditText email = binding.email;
        final EditText address = binding.address;
        final Button btnSubmit = binding.submit;

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname1 = firstname.getText().toString();
                String lastname1 = lastname.getText().toString();
                String phone1 = phone.getText().toString();
                String email1 = email.getText().toString();
                String address1 = address.getText().toString();

                if (firstname1.isEmpty() || lastname1.isEmpty() || phone1.isEmpty() || email1.isEmpty() || address1.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data saved successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return root;
    }
}