package com.spot.actday4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

//https://github.com/android/location-samples/blob/master/LocationAddress/app/src/main/java/com/google/android/gms/location/sample/locationaddress/FetchAddressIntentService.java

public class MyService extends Service {
    public MyService() {
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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
         String data = intent.getExtras().getString("actkey");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
       // stopSelf();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
