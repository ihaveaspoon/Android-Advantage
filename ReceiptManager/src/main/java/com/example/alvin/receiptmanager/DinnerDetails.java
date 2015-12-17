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

public class DinnerDetails extends AppCompatActivity {
    EditText name3;
    EditText price3;
    EditText date3;
    EditText details3;
    public static final String fileName3 = "data3.txt";
    File file3;
    FileOutputStream outputStream;
    FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name3 = (EditText) findViewById(R.id.nameText3);
        price3 = (EditText) findViewById(R.id.priceText3);
        date3 = (EditText) findViewById(R.id.dateText3);
        details3 = (EditText) findViewById(R.id.detailsText3);
        file3 = new File(this.getFilesDir(), fileName3);
    }

    public void add3(View v) {
        String data = name3.getText().toString() + "|" + price3.getText().toString() + "|" + date3.getText().toString() + "|" + details3.getText().toString();
        try {
            outputStream = new FileOutputStream(file3);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load3(View v) {
        int length = (int) file3.length();
        byte[] bytes = new byte[length];
        try {
            inputStream = new FileInputStream(file3);
            inputStream.read(bytes);
            inputStream.close();
            String data = new String(bytes);
            name3.setText(data.split("\\|")[0]);
            price3.setText(data.split("\\|")[1]);
            date3.setText(data.split("\\|")[2]);
            details3.setText(data.split("\\|")[3]);
            Toast.makeText(getBaseContext(), "Data Loaded", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}