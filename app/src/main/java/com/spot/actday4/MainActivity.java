package com.spot.actday4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

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
            case R.id.buttonbind:
                Intent cricServiceIntent = new Intent(MainActivity.this,CricScoreService.class);
                bindService(cricServiceIntent,connection,BIND_AUTO_CREATE);//1
                break;
            case R.id.buttonUnbind:
                unbindService(connection);
                break;
        }
    }

    CricScoreService cricScoreService;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {//3
            CricScoreService.LocalBinder binder = (CricScoreService.LocalBinder) iBinder;
            cricScoreService = binder.getService();
            int cricketScore = cricScoreService.getRandomNumber();
            Toast.makeText(MainActivity.this, "score = "+cricketScore, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(MainActivity.this, "service disconnected", Toast.LENGTH_SHORT).show();

        }
    };
}
