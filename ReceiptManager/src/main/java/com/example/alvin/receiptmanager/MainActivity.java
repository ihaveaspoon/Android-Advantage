package com.example.alvin.receiptmanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Adding declarations for different functions
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

//      List View Creation - Populating with the buttons
        ListView listview = (ListView) findViewById(R.id.dateList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Please click the button in the middle", Toast.LENGTH_LONG).show();
            }
        });
/* The following block of code relates to the ListViewAdapter that is used to display the buttons within
* the home screen page, the String is incorporated which determines what the label is within the list
* view*/
        String[] items = {"Food"};
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.list_items, R.id.txt, items);
        listview.setAdapter(adapter);

//      Floating Action Button - when the floating action button is clicked it will provide a hint for the user
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click on a date to enter your purchase for that day", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//      Dialog fragment that is displayed when the application is opened providing assistance for the user
        FragmentManager fm = getFragmentManager();
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(fm, "Help");
    }
//    Assigning the newPage function to the buttons - these buttons will open new activity classes when clicked
    public void newPage(View view){
        Intent intent = new Intent(getApplicationContext(),ItemDetails.class);
        startActivity(intent);
    }

    public void newPage2(View view) {
        Intent intent = new Intent(getApplicationContext(), lunchdetails.class);
        startActivity(intent);
    }

    public void newPage3(View view){
        Intent intent = new Intent(getApplicationContext(),DinnerDetails.class);
        startActivity(intent);
    }

}
