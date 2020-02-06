package com.spot.actday4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {
        Intent serviceIntent = new Intent(MainActivity.this,MyService.class);
        switch (view.getId()){
            case R.id.buttonstart:
                serviceIntent.putExtra("actkey","act training");
                startService(serviceIntent);
                break;
            case R.id.buttonstop:
                stopService(serviceIntent);
                break;
        }
    }
}
