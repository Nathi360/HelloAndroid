package com.example.countach.cti;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PayCalculator extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_calculator);

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
        final EditText rate = (EditText) findViewById(R.id.editText4);
        final EditText hours = (EditText) findViewById(R.id.editText3);

        //Initialize button and assign listener to it.
        Button b = (Button) findViewById(R.id.button6);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //To avoid NullPointerException crashes
                if(rate != null && hours != null)
                {
                    //Parse parameters to strings for convenience.
                    computePay(rate.getText().toString(), hours.getText().toString());
                }
            }
        });
    }

    private void computePay(String Rx, String H)
    {
        //Parse parameters back to numeric types.
        Double rate = Double.parseDouble(Rx);
        Double hours = Double.parseDouble(H);
        Double pay;

        //Where the result will be written to in UI.
        TextView tView = (TextView) findViewById(R.id.textView8);

        //Compute result and write to UI View
        if(hours == 40 && rate < 28.50)
        {
            pay = hours * (rate + 1.50);
            tView.setText("R" + pay.toString());
        }
        else if(hours == 40 && rate >= 28.50)
        {
            pay = hours * (rate + 1.20);
            tView.setText("R" + pay.toString());
        }
        else if(hours > 40 && rate >= 28.50)
        {
            pay = hours * (rate + (rate * 0.015));
            tView.setText("R" + pay.toString());
        }
        else if(hours < 40)
        {
            pay = hours * (rate - 0.50);
            tView.setText("R" + pay.toString());
        }
    }
}
