package com.example.alvin.receiptmanager;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Alvin on 16/12/2015.
 */
// Extending the class from the DialogFragment library
public class MyDialogFragment extends DialogFragment {
    @Override
//  The onCreateView method is used to return the instance of the view for the dialog fragment
/*The instance of the layout inflater is used to inflate the dialog screen when it appears
* The viewgroup represents the parent view for the fragment while the bundle allows for the
* fragment to restor to its previous state*/
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.help_dialog,container,false);
        getDialog().setTitle("Help");
//        Associating the dismiss function to the button within the layout file
        final Button dismiss = (Button) rootView.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener(){
            @Override
//          Creating an onClick function that is to be associated with the dismiss button
            public void onClick (View v){
                dismiss();
            }
        });
        return rootView;
    }
}

