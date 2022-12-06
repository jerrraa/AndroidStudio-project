package com.example.nscc_form;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ContactAdapter extends FirebaseRecyclerAdapter<UserData, ContactAdapter.contactViewHolder> {
    public ContactAdapter(@NonNull FirebaseRecyclerOptions<UserData> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull contactViewHolder holder, int position, @NonNull UserData model) {
        holder.fname.setText(model.getFname());
        holder.lname.setText(model.getLname());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhone());
        holder.address.setText(model.getAddress());
        holder.notes.setText(model.getNotes());
    }
    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new ContactAdapter.contactViewHolder(view);
    }
    class contactViewHolder extends RecyclerView.ViewHolder {
        TextView fname, lname, email, phone, address, notes;
        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.recycle_fname);
            lname = itemView.findViewById(R.id.recycle_lname);
            email = itemView.findViewById(R.id.recycle_email);
            phone = itemView.findViewById(R.id.recycle_phone);
            address = itemView.findViewById(R.id.recycle_address);
            notes = itemView.findViewById(R.id.recycle_notes);
        }
    }
}

