package com.example.nscc_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    String fname,lname,email,phone,address;
    EditText editnotes;
    String editintent;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        save = findViewById(R.id.button);

        editnotes = findViewById(R.id.editnotes);
        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        address = getIntent().getStringExtra("address");
        editintent = getIntent().getStringExtra("notes");
        editnotes.setText(editintent);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notes = editnotes.getText().toString();
                Intent intent = new Intent(view.getContext(), ClientDetail.class);
                intent.putExtra("fname",fname);
                intent.putExtra("lname",lname);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
                intent.putExtra("notes",notes);

                startActivity(intent);

            }
        });

    }
}