package com.example.nscc_form;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ContactAdapter extends FirebaseRecyclerAdapter<UserData, ContactAdapter.contactViewHolder> {
    public ContactAdapter(@NonNull FirebaseRecyclerOptions<UserData> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull contactViewHolder holder, int position, @NonNull UserData data) {

        holder.fname.setText(data.getFname());
        holder.lname.setText(data.getLname());
        holder.email.setText(data.getEmail());
        holder.phone.setText(data.getPhone());
        holder.address.setText(data.getAddress());
        holder.notes.setText(data.getNotes());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtain data and redirect to clientdetail activity
                Intent intent = new Intent(v.getContext(), ClientDetail.class);
                Toast.makeText(v.getContext(), "Tapped on " + data.getFname() +" " + data.getLname(), Toast.LENGTH_SHORT).show();
                intent.putExtra("fname", data.getFname());
                intent.putExtra("lname", data.getLname());
                intent.putExtra("email", data.getEmail());
                intent.putExtra("phone", data.getPhone());
                intent.putExtra("address", data.getAddress());
                intent.putExtra("notes", data.getNotes());
                v.getContext().startActivity(intent);
            }
        });
    }
    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new ContactAdapter.contactViewHolder(view);
    }
    class contactViewHolder extends RecyclerView.ViewHolder {
        TextView fname,lname, email, phone, address, notes;
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

