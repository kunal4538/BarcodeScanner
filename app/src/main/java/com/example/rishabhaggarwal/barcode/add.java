package com.example.rishabhaggarwal.barcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add extends AppCompatActivity {
    MyDBHandler DBHandler;
    String a,b;
    EditText e1,e2;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        String a= getIntent().getStringExtra("format");

        String b= getIntent().getStringExtra("content");
        t1=(TextView)findViewById(R.id.textView);
        View t=(TextView)findViewById(R.id.textView);
        t.setVisibility(View.GONE);
        t2=(TextView)findViewById(R.id.textView2);
        t1.setText(a);
        t2.setText(b);
        DBHandler=new MyDBHandler(this,null,null,1);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText4);

    }
    public void added(View v){
        String price=e1.getText().toString();
        String ptype=e2.getText().toString();
        String a1=t1.getText().toString();
        String a2=t2.getText().toString();
        int flag=0;

        if(e1.getText().toString().trim().equalsIgnoreCase("")){
            e1.setError("Enter Price");
            flag=1;
        }

        if(flag!=1){
            information i=new information(a1,a2,price,ptype );
            DBHandler.adduser(i);
            Toast.makeText(this.getApplicationContext(),"PRODUCT ADDED",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();

        }

    }
}
