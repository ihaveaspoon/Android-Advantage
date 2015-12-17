package com.example.alvin.receiptmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Alvin on 14/12/2015.
 */
//Extending from ArrayAdapter library
public class ListViewAdapter extends ArrayAdapter {
//    Declaring variables that are going to be used
    int groupid;
    String[] item_list;
    ArrayList<String> desc;
    Context context;
//    Creating the ListViewAdapter
    public ListViewAdapter(Context context, int vg, int id, String[] item_list){
        super(context,vg, id, item_list);
        this.context=context;
        groupid=vg;
        this.item_list=item_list;
    }
    // Hold views of the ListView to improve its scrolling performance
    static class ViewHolder {
//        Declaring the textview and the buttons to its counterparts within the layout
        public TextView textview;
        public Button button;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // Inflate the list_item.xml file if convertView is null
        if(rowView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
//            Setting the values for the textview and the buttons
            viewHolder.textview= (TextView) rowView.findViewById(R.id.txt);
            viewHolder.button= (Button) rowView.findViewById(R.id.breakfast);
            rowView.setTag(viewHolder);
        }
        // Set text to each TextView of ListView item
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textview.setText(item_list[position]);
        holder.button.setText("Breakfast");
        return rowView;
    }

}

