package com.spot.actday4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

//https://developer.android.com/guide/components/bound-services
public class CricScoreService extends Service {

    public CricScoreService() {
    }

    private final IBinder binder = new LocalBinder();


    public class LocalBinder extends Binder {

        CricScoreService getService() {
            // Return this instance of LocalService so clients can call public methods
            return CricScoreService.this;
        }
    }
    private final Random mGenerator = new Random();

    @Override
    public IBinder onBind(Intent intent) {//2
        return binder;
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();

    }

}
