package com.example.countach.cti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try
        {
            getActionBar().setDisplayHomeAsUpEnabled(false);
        }
        catch(NullPointerException v)
        {
            v.getCause();
        }

        setContentView(R.layout.activity_main);
    }

    //Called when the TrailerHire button in MainActivity View is clicked
    public void trailerHire(View looks)
    {
        //Specify which activity to load and start the Activity
        Intent mont = new Intent(this, TrailerHire.class);
        startActivity(mont);
    }

    //Called when the PayCalculator button in MainActivity View is clicked
    public void payCalculator(View looks)
    {
        //Specify which activity to load and start the Activity
        Intent mont = new Intent(this, PayCalculator.class);
        startActivity(mont);
    }

    //Called when the OrderCalculator button in MainActivity View is clicked
    public void orderCalculator(View looks)
    {
        //Specify which activity to load and start the Activity
        Intent mont = new Intent(this, OrderCalculator.class);
        startActivity(mont);
    }
}
