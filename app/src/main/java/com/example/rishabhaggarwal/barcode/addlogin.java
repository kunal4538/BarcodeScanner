package com.example.rishabhaggarwal.barcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addlogin extends AppCompatActivity {
    EditText al1,ap1,ap2;
    MyDBHandler DBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlogin);
        DBHandler=new MyDBHandler(this,null,null,1);
    }
    public void alogin(View v) {
        al1 = (EditText) findViewById(R.id.aid);
        String aid=al1.getText().toString();
        ap1 = (EditText) findViewById(R.id.apass);
        String password=ap1.getText().toString();
        ap2=(EditText)findViewById(R.id.editText3);
        String cpassword=ap2.getText().toString();

        int flag = 0;


        if (ap1.getText().toString().trim().equalsIgnoreCase("")) {
            ap1.setError("Enter Password");
            flag = 1;
        }


        if (al1.getText().toString().trim().equalsIgnoreCase("")) {
            al1.setError("Enter Number");
            flag = 1;

        }
        boolean a=password.equals(cpassword);
        if(a==false){
            ap2.setError("Password Not Matched");
            flag=1;
        }
    if(flag!=1){
        information i=new information(aid,password);
        DBHandler.admin(i);
        Toast.makeText(this.getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
}
