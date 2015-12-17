package com.example.alvin.receiptmanager;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ItemDetails extends AppCompatActivity {
//    Declaring variables that will be used for Data persistency
    EditText name;
    EditText price;
    EditText date;
    EditText details;
    public static final String fileName = "data.txt";
    File file;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
//  When this activity is opened it sets the variables equal to the edittexts in the item_details xml layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (EditText) findViewById(R.id.nameText);
        price = (EditText) findViewById(R.id.priceText);
        date = (EditText) findViewById(R.id.dateText);
        details = (EditText) findViewById(R.id.detailsText);
        file = new File(this.getFilesDir(),fileName);
    }

    public void add(View v){
        String data = name.getText().toString() + "|"  + price.getText().toString() + "|"+ date.getText().toString() + "|" + details.getText().toString();
        try{
            outputStream = new FileOutputStream(file);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(View v){
        int length =(int) file.length();
        byte[] bytes = new byte[length];
        try{
            inputStream = new FileInputStream(file);
            inputStream.read(bytes);
            inputStream.close();
            String data = new String(bytes);
            name.setText(data.split("\\|")[0]);
            price.setText(data.split("\\|")[1]);
            date.setText(data.split("\\|")[2]);
            details.setText(data.split("\\|")[3]);
            Toast.makeText(getBaseContext(),"Data Loaded",Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
