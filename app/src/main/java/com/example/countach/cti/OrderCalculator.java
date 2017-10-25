package com.example.countach.cti;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrderCalculator extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_calculator);

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
        final EditText slices = (EditText) findViewById(R.id.editText6);
        final EditText vodka = (EditText) findViewById(R.id.editText7);
        final EditText park = (EditText) findViewById(R.id.editText5);

        //Initialize button and assign listener to it.
        Button b = (Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //To avoid NullPointerException crashes
                if(slices != null && vodka != null && park != null)
                {
                    computePrice(slices.getText().toString(), vodka.getText().toString(), park.getText().toString());
                }
            }
        });
    }

    private void computePrice(String sli, String vod, String par)
    {
        //Parse parameters back to numeric types.
        Integer slices = Integer.parseInt(sli);
        Integer vodka = Integer.parseInt(vod);
        Integer parking = Integer.parseInt(par);
        Integer total = (20*slices + 25*vodka + 5*parking);

        //Where the result will be written to in UI.
        TextView tView = (TextView) findViewById(R.id.textView12);
        //Write result to the View.
        tView.setText("R" + total.toString());
    }

}
