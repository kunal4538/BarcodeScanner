package com.example.rishabhaggarwal.barcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends AppCompatActivity  {
    TextView t4;
    private Button scanBtn,addbtn;
    private TextView formatTxt, contentTxt, result;
    private String pass;
    EditText w1;
    MyDBHandler DBHandler = new MyDBHandler(this, null, null, 1);



    private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t4=(TextView)findViewById(R.id.textView4);
        Typeface myCustomFont;
        myCustomFont = Typeface.createFromAsset(getAssets(),"font/2Peas Champagne.ttf");
        t4.setTypeface(myCustomFont);
        scanBtn = (Button) findViewById(R.id.scan_button);
        formatTxt = (TextView) findViewById(R.id.scan_format);
        contentTxt = (TextView) findViewById(R.id.scan_content);
        View mb=(Button)findViewById(R.id.button3);
        View ad=(Button)findViewById(R.id.addbtn);
        String flag= getIntent().getStringExtra("flag");

        //   if(flag.equals("0")){
        //     mb.setVisibility(View.GONE);
        //}

    }

    public void scanCode(View view){
        scannerView=new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());

        setContentView(scannerView);
        scannerView.startCamera();

    }
    @Override
    public void onPause(){
        super.onPause();
        scannerView.stopCamera();



    }


    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler
    {


        public void handleResult(Result result){

            String resultCode=result.getText();

            Toast.makeText(Main2Activity.this,resultCode, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main2);
            scannerView.stopCamera();
            String a=resultCode;
            String b="0";
            contentTxt.setText(a);
            formatTxt.setText(b);
            //     i=new Intent(MainActivity.this, Main2Activity.class);
            //     i.putExtra("result", resultCode);
            //     startActivity(i);

        }


    }





    public void add(View v) {
        addbtn=(Button)findViewById(R.id.addbtn);

       // String pr=result.getText().toString();
      //  if(pr.equals("NULL")){
            String a = formatTxt.getText().toString();
            String b = contentTxt.getText().toString();
        if(b.equals("")||b.equals("null")){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Product missing");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        else {

            String s2 = contentTxt.getText().toString();
            pass = DBHandler.price(s2);
            String rs="Rs.";
            if(!(pass.equals("null"))){
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

                dlgAlert.setMessage("Product Already Exists");
                dlgAlert.setTitle("Error Message...");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });


            }
            else {
                Intent i = new Intent(Main2Activity.this, add.class);
                i.putExtra("format", a);
                i.putExtra("content", b);
                startActivity(i);


        }}}


     //   else {
       //     addbtn.setEnabled(false);

       // }


   /* public void price(View view){
        Intent i=new Intent(Main2Activity.this,productinfo.class);
        String pr=price1();
        i.putExtra("price",pr);
        startActivity(i);
    }*/


    public void price(View view) {



        String s2 = contentTxt.getText().toString();
        if(s2.equals("")){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Product Not Scanned");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        else {
            Intent i = new Intent(Main2Activity.this, price.class);
            i.putExtra("content", s2);
            startActivity(i);

        }
    }
        /*  result = (TextView) findViewById(R.id.textView3);
        String s1 = formatTxt.getText().toString();
        String s2 = contentTxt.getText().toString();
        pass = DBHandler.price(s2);
        String rs="Rs.";
        if(pass.equals("null")){
            result.setText("NULL");
        }
        else {
            result.setText(rs.concat(pass));
        }
        String p = result.getText().toString();
    */



    public void update(View v){
        String a= formatTxt.getText().toString();
        String b= contentTxt.getText().toString();
        if(b.equals("")){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Product Not Scanned");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        else {
            Intent i = new Intent(Main2Activity.this, update.class);
            i.putExtra("format", a);
            i.putExtra("content", b);

            startActivity(i);

        }
    }

}
