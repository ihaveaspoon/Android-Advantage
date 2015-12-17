package com.example.alvin.receiptmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alvin.receiptmanager.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class lunchdetails extends AppCompatActivity {
    EditText name2;
    EditText price2;
    EditText date2;
    EditText details2;
    public static final String fileName2 = "data2.txt";
    File file2;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunchdetails);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name2 = (EditText) findViewById(R.id.nameText2);
        price2 = (EditText) findViewById(R.id.priceText2);
        date2 = (EditText) findViewById(R.id.dateText2);
        details2 = (EditText) findViewById(R.id.detailsText2);
        file2 = new File(this.getFilesDir(),fileName2);
    }

    public void add2(View v){
        String data = name2.getText().toString() + "|" + price2.getText().toString() + "|" + date2.getText().toString() + "|" + details2.getText().toString();
        try {
            outputStream = new FileOutputStream(file2);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load2 (View v){
        int length = (int) file2.length();
        byte [] bytes = new byte[length];
        try{
            inputStream = new FileInputStream(file2);
            inputStream.read(bytes);
            inputStream.close();
            String data = new String(bytes);
            name2.setText(data.split("\\|")[0]);
            price2.setText(data.split("\\|")[1]);
            date2.setText(data.split("\\|")[2]);
            details2.setText(data.split("\\|")[3]);
            Toast.makeText(getBaseContext(),"Data Loaded", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
