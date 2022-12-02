package com.example.nscc_form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nscc_form.databinding.FragmentAddBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFragment extends Fragment {
    FragmentAddBinding binding;
    //firebase database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://androidproject-bb272-default-rtdb.firebaseio.com");
    DatabaseReference databaseReferenceEMAIL = FirebaseDatabase.getInstance().getReference().child("user");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //variable declarion from fragment
        final EditText firstname = binding.firstname;
        final EditText lastname = binding.lastname;
        final EditText phone = binding.phone;
        final EditText email = binding.email;
        final EditText address = binding.address;
        final EditText notes = binding.notes;


        final Button btnSubmit = binding.submit;

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname1 = firstname.getText().toString();
                String lastname1 = lastname.getText().toString();
                String phone1 = phone.getText().toString();
                String email1 = email.getText().toString();
                String address1 = address.getText().toString();
                String notes1 = notes.getText().toString();
                //checks if one of the fields are empty is one is true, throw error
                if (firstname1.isEmpty() ||  lastname1.isEmpty()  || phone1.isEmpty() || email1.isEmpty() || address1.isEmpty() || notes1.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    //more data validation on phone number and email address
                    if (phone1.length() != 10) {
                        phone.setError("Phone number must be 10 digits");
                    } else if (!email1.contains("@") || !email1.contains(".")) {
                        email.setError("Please enter a valid email address");
                    } else {
                        databaseReferenceEMAIL.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                //we use a for loop to check if the input email matches a email in the database
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    String compare = dataSnapshot.child("email").getValue().toString();
                                    if (email1.equals(compare)) {
                                        email.setError("Email already exists");
                                        return;
                                    }
                                }
                                //insert data into the database after validation
                                UserInfo userInfo = new UserInfo(firstname1, lastname1, email1, phone1, address1, notes1);
                                databaseReference.child("user").push().setValue(userInfo);
                                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();
                                //clears all the fields after the data is inserted
                                clear();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }
            }
        });
        return root;
    }
    public void clear() {
        binding.firstname.setText("");
        binding.lastname.setText("");
        binding.phone.setText("");
        binding.email.setText("");
        binding.address.setText("");
        binding.notes.setText("");
    }
}