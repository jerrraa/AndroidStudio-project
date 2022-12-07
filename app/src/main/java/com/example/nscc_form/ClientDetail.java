package com.example.nscc_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientDetail extends AppCompatActivity {

    String fname,lname,email,phone,address,notes;
    TextView noteview;
    EditText fnameedit, lnameedit, emailedit, phoneedit, addressedit;
    Button delete, edit, save, close;
    ContactFragment contactfragment = new ContactFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        // grab data from intent
        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        address = getIntent().getStringExtra("address");
        notes = getIntent().getStringExtra("notes");

        fnameedit = findViewById(R.id.firstedit);
        lnameedit = findViewById(R.id.lastedit);
        emailedit = findViewById(R.id.emailedit);
        phoneedit = findViewById(R.id.phoneedit);
        addressedit = findViewById(R.id.addressedit);
        noteview = findViewById(R.id.notesview);

        delete = findViewById(R.id.deletebtn);
        edit = findViewById(R.id.editbtn);
        save = findViewById(R.id.savebtn);
        close = findViewById(R.id.closebtn);
        FillFields();
        // delete all of the fields and notes
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // delete from database


            }
        });
        //redirect to contact fragment
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //saves the notes in the textfield
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save to database
                notes = noteview.getText().toString();



            }
        });
        //redirects to different activity and edits notes
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditActivity.class);
                intent.putExtra("fname",fname);
                intent.putExtra("lname",lname);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
                intent.putExtra("notes", notes);
                view.getContext().startActivity(intent);
            }
        });

    }
    public void FillFields() {
        fnameedit.setText(fname);
        lnameedit.setText(lname);
        emailedit.setText(email);
        phoneedit.setText(phone);
        addressedit.setText(address);
        noteview.setText(notes);
    }
    public void ClearFields() {
        fnameedit.setText("");
        lnameedit.setText("");
        emailedit.setText("");
        phoneedit.setText("");
        addressedit.setText("");
        noteview.setText("");
    }
}