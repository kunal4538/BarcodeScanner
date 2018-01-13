package com.example.rishabhaggarwal.barcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class price extends AppCompatActivity {

    MyDBHandler DBHandler = new MyDBHandler(this, null, null, 1);
    String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        TextView price=(TextView)findViewById(R.id.textView9) ;
        TextView pt=(TextView)findViewById(R.id.textView10);
        // s2= getIntent().getStringExtra("content");
        String pr= cost();
        String p= type();

        pt.setText(pr);
        price.setText(p);

    }

    public String cost() {
        // result = (TextView) findViewById(R.id.textView3);
        // String s1 = formatTxt.getText().toString();
        String s2= getIntent().getStringExtra("content");
        s2= getIntent().getStringExtra("content");
        String pass = DBHandler.pcontent(s2);
        String rs="Rs.";
        if(pass.equals("null")){
            a="NULL";
        }
        else {

            a= pass;
        }
        return a;
    }

    public String type() {
        // result = (TextView) findViewById(R.id.textView3);
        // String s1 = formatTxt.getText().toString();
        String s2= getIntent().getStringExtra("content");
        s2= getIntent().getStringExtra("content");
        String pass = DBHandler.price(s2);
        String rs="Rs.";
        if(pass.equals("null")){
            b="NULL";
        }
        else {

            b= (rs.concat(pass));
        }
        return b;
    }
}
