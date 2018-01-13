package com.example.rishabhaggarwal.barcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class logincheck extends AppCompatActivity {
    EditText a1,a2;
    String flag;
    MyDBHandler DBHandler = new MyDBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincheck);
    }
    public void adlogin(View v){
      a1=(EditText)findViewById(R.id.aid) ;
        a2=(EditText)findViewById(R.id.apass) ;
    String d1=a1.getText().toString();
        String d2=a2.getText().toString();
        String pass = DBHandler.getpass(d1);
        if (d2.equals(pass)) {
            Intent i=new Intent(logincheck.this, Main2Activity.class);
            startActivity(i);
            finish();

    }
        else{

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

                dlgAlert.setMessage("Invalid User ID or Password");
                dlgAlert.setTitle("Error Message");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        });
            a1.setText("");
            a2.setText("");
            }


}}