package com.example.countach.cti;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrailerHire extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_hire);

        try
        {
            //Throws NullPointerException that crashes application.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch(NullPointerException v)
        {
            v.getCause();
        }

        //Extract input from UI
        final EditText days = (EditText) findViewById(R.id.editText);
        final EditText trav = (EditText) findViewById(R.id.editText2);

        //Initialize button and assign listener to it.
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //To avoid NullPointerException crashes
                if(days != null && trav != null)
                {
                    //Parse parameters to strings for convenience.
                    computeCost(days.getText().toString(), trav.getText().toString());
                }
            }
        });
    }

    private void computeCost(String D, String T)
    {
        //Parse parameters back to numeric types.
        Double days = Double.parseDouble(D);
        Double trav = Double.parseDouble(T);
        Double total = (300.0)*days;

        //Where the result will be written to in UI.
        TextView tView = (TextView) findViewById(R.id.textView6);

        if(trav < 40)
        {
            //Compute result and write to UI View
            total = total + (total * 0.05);
            tView.setText("R" + total.toString());
        }
        else if(trav > 200)
        {
            //Compute result and write to UI View
            total = total - (total * 0.11);
            tView.setText("R" + total.toString());
        }
        else
        {
            //Case not given in assignment specification.
            tView.setText("Test Case Not Supported");
        }
    }
}
