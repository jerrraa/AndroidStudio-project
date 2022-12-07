package com.example.nscc_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    String fname,lname,email,phone,address;
    EditText editnotes, editfname, editlname, editemail, editphone, editaddress;
    String editintent;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        save = findViewById(R.id.button);
        editnotes = findViewById(R.id.editnotes);
        editfname = findViewById(R.id.firstedit2);
        editlname = findViewById(R.id.lastedit2);
        editemail = findViewById(R.id.emailedit2);
        editphone = findViewById(R.id.phoneedit2);
        editaddress = findViewById(R.id.addressedit2);


        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        address = getIntent().getStringExtra("address");
        editintent = getIntent().getStringExtra("notes");


        editfname.setText(fname);
        editlname.setText(lname);
        editemail.setText(email);
        editphone.setText(phone);
        editaddress.setText(address);
        editnotes.setText(editintent);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                InsertEditintoStrings();
                Intent intent = new Intent(view.getContext(), ClientDetail.class);
                intent.putExtra("fname",fname);
                intent.putExtra("lname",lname);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
                intent.putExtra("notes",editintent);

                startActivity(intent);
            }
        });

    }
    public void InsertEditintoStrings() {
        editintent = editnotes.getText().toString();
        fname = editfname.getText().toString();
        lname = editlname.getText().toString();
        email = editemail.getText().toString();
        phone = editphone.getText().toString();
        address = editaddress.getText().toString();

    }
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}