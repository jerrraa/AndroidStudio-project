package com.example.nscc_form;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nscc_form.databinding.FragmentContactBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class ContactFragment extends Fragment {
    FragmentContactBinding binding;
    RecyclerView recyclerView;
    DatabaseReference datareference;
    ContactAdapter contactAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerList;

        datareference = FirebaseDatabase.getInstance().getReference().child("user");
        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<UserData> options
                = new FirebaseRecyclerOptions.Builder<UserData>()
                .setQuery(datareference, UserData.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        contactAdapter = new ContactAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(contactAdapter);

        return root;
    }
    @Override public void onStart()
    {
        super.onStart();
        contactAdapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override public void onStop()
    {
        super.onStop();
        contactAdapter.stopListening();
    }
}

