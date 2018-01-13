package com.example.rishabhaggarwal.barcode;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabhaggarwal.barcode.google.zxing.integration.android.IntentIntegrator;
import com.example.rishabhaggarwal.barcode.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t4;
    private Button scanBtn;
    private TextView formatTxt, contentTxt, result;
    private String pass;
    MyDBHandler DBHandler = new MyDBHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View regbtn=(Button)findViewById(R.id.adminreg);
        int a=regcount();
        if(a==1){
        regbtn.setVisibility(View.GONE);
        }


    }


    public void onClick(View v) {
        if (v.getId() == R.id.scan_button) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    public void admlogin(View v) {
        Intent i = new Intent(MainActivity.this, logincheck.class);


        startActivity(i);
    }

    public void admreg(View v) {

        Intent i = new Intent(MainActivity.this, addlogin.class);


        startActivity(i);

    }

    public void guest(View v) {


        Intent i = new Intent(MainActivity.this, guestActivity.class);

        startActivity(i);

    }

    public int regcount() {

        int count = DBHandler.count();
        return count;
    }





   /* public void price(View view) {
        result = (TextView) findViewById(R.id.textView3);
        String s1 = formatTxt.getText().toString();
        String s2 = contentTxt.getText().toString();
        pass = DBHandler.price(s2);
        String rs="Rs.";
        result.setText(rs.concat(pass));
        String p = result.getText().toString();
    }

    public void update(View v){
        String a= formatTxt.getText().toString();
        String b= contentTxt.getText().toString();
        Intent i = new Intent(MainActivity.this, update.class);
        i.putExtra("format", a);
        i.putExtra("content", b);

        startActivity(i);

    }*/

}

