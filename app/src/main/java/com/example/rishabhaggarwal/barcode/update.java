package com.example.rishabhaggarwal.barcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update extends AppCompatActivity {
    MyDBHandler DBHandler;
    String a, b;
    EditText e;
    TextView t1, t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        View t=(TextView)findViewById(R.id.textView6);
        t.setVisibility(View.GONE);
        String a= getIntent().getStringExtra("format");
        String b= getIntent().getStringExtra("content");
        t1=(TextView)findViewById(R.id.textView6);
        t2=(TextView)findViewById(R.id.textView7);
        t1.setText(a);
        t2.setText(b);
        DBHandler=new MyDBHandler(this,null,null,1);
        e=(EditText)findViewById(R.id.editText2);

    }

    public void update(View v){
        String price=e.getText().toString();
        String a1=t1.getText().toString();
        String a2=t2.getText().toString();

        //  information i=new information(a1,a2,price );
        DBHandler.delete(a2,price);
        // DBHandler.adduser(i);
        Toast.makeText(this.getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();




    }
    public void deleted(View v){
        String a1=t2.getText().toString();

        String pass=DBHandler.delete2(a1);
        Toast.makeText(this.getApplicationContext(),"DELETED",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}

